package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.entity.Specialization;
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

    public DoctorResponse createDoctorProfile(DoctorRequest doctorRequest, int adminId, int departmentId, int specializationId) {

        Admin admin = adminRepository.findById(adminId)
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


