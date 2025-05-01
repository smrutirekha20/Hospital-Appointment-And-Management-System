package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Specialization;
import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.exception.DepartmentNotFoundException;
import com.hams.hamsvc.exception.DuplicateSpecializationException;
import com.hams.hamsvc.mapper.SpecializationMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.DepartmentRepository;
import com.hams.hamsvc.repository.SpecializationRepository;
import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.SpecializationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecializationServiceImpl implements SpecializationService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private SpecializationMapper specializationMapper;

    @Override
    public SpecializationResponse addSpecializationToDepartment(Integer adminId, Integer departmentId, SpecializationRequest specializationRequest) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new AdminNotFoundException("Admin with ID " + adminId + " not found"));

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with ID " + departmentId + " not found"));

        Optional<Specialization> existingSpecialization = specializationRepository
                .findBySpecializationNameAndDepartment(specializationRequest.getSpecializationName(), department);

        if (existingSpecialization.isPresent()) {
            throw new DuplicateSpecializationException(
                    "Specialization '" + specializationRequest.getSpecializationName() +
                            "' already exists in department '" + department.getDepartmentName()+".");
        }

        Specialization specialization = new Specialization();
        specialization.setSpecializationName(specializationRequest.getSpecializationName());
        specialization.setDepartment(department);

        Specialization savedSpecialization = specializationRepository.save(specialization);

        return specializationMapper.mapToSpecializationResponse(savedSpecialization);
    }
}


