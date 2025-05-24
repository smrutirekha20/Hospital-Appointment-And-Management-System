package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Patient;
import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.enums.UserRole;
import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.exception.PatientNotFoundException;
import com.hams.hamsvc.mapper.PatientMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.PatientRepository;
import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;
import com.hams.hamsvc.security.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private AdminRepository adminRepository;

   public PatientResponse registerPatient(PatientRequest patientRequest){
       User user = authUtil.getCurrentUser();
       if(patientRepository.findByUser(user).isPresent()){
           throw new PatientNotFoundException("Patient not found with email"+user.getEmail());
       }
       Patient patient = patientMapper.mapToPatient(patientRequest,new Patient());
       patient.setUser(user);
       Patient savedPatient = patientRepository.save(patient);

       return patientMapper.mapToPatientResponse(savedPatient);
   }

   public PatientResponse updatePatientProfile(PatientRequest patientRequest,Integer patientId) {
       User user = authUtil.getCurrentUser();

       if (user.getUserRole() != UserRole.ADMIN) {
           throw new AdminNotFoundException("Only Admins can update patient profiles.");
       }
       Admin admin = adminRepository.findByUser(user)
               .orElseThrow(() -> new AdminNotFoundException("Admin not found"));

       Patient existingPatient = patientRepository.findById(patientId)
               .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

       patientMapper.mapToPatient(patientRequest, existingPatient);

       Patient updatedPatient = patientRepository.save(existingPatient);

       return patientMapper.mapToPatientResponse(updatedPatient);
   }
}

