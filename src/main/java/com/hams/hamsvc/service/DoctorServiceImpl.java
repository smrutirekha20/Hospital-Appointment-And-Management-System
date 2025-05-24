package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.*;
import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.exception.DepartmentNotFoundException;
import com.hams.hamsvc.exception.SpecializationNotFoundException;
import com.hams.hamsvc.mapper.DoctorMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.DepartmentRepository;
import com.hams.hamsvc.repository.DoctorRepository;
import com.hams.hamsvc.repository.SpecializationRepository;
import com.hams.hamsvc.requestDTO.DoctorRequest;
import com.hams.hamsvc.responseDTO.DoctorResponse;
import com.hams.hamsvc.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private AdminRepository adminRepository;

    private AuthUtil authUtil;

    public DoctorResponse createDoctorProfile(DoctorRequest doctorRequest, int adminId, int departmentId, int specializationId) {
         User loggedInUser = authUtil.getCurrentUser();
        Admin admin = adminRepository.findByUser_userId(loggedInUser.getUserId())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));


        Specialization specialization = specializationRepository.findById(specializationId)
                .orElseThrow(() -> new SpecializationNotFoundException("Specialization not found"));

        Doctor doctor = doctorMapper.mapToDoctor(doctorRequest);


        doctor.setAdmin(admin);
        doctor.setDepartment(department);
        doctor.setSpecialization(specialization);


        Doctor savedDoctor = doctorRepository.save(doctor);


        return doctorMapper.mapToDoctorResponse(savedDoctor);
    }

    @Override
    public List<DoctorResponse> getDoctorsByDepartmentAndSpecialization(String departmentName, String specializationName) {

        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        Specialization specialization = specializationRepository.findBySpecializationName(specializationName)
                .orElseThrow(() -> new SpecializationNotFoundException("Specialization not found"));


        List<Doctor> doctors = doctorRepository.findByDepartmentAndSpecialization(department, specialization);

        return doctors.stream()
                .map(doctorMapper::mapToDoctorResponse)
                .collect(Collectors.toList());
    }

}


