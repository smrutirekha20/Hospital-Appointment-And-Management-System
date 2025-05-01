package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Patient;
import com.hams.hamsvc.exception.EmailAlreadyExistsException;
import com.hams.hamsvc.mapper.PatientMapper;
import com.hams.hamsvc.repository.PatientRepository;
import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PatientRepository patientRepository;

   public PatientResponse registerPatient(PatientRequest patientRequest){
       if(patientRepository.findByEmail(patientRequest.getEmail()).isPresent()){
           throw  new EmailAlreadyExistsException("Email alredy exist"+patientRequest.getEmail());
       }
       Patient patient = patientMapper.mapToPatient(patientRequest);
       Patient savedPatient = patientRepository.save(patient);
       return patientMapper.mapToPatientResponse(savedPatient);
   }

}

