package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Specialization;
import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.exception.DepartmentNotFoundException;
import com.hams.hamsvc.mapper.DepartmentMapper;
import com.hams.hamsvc.mapper.SpecializationMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.DepartmentRepository;
import com.hams.hamsvc.repository.SpecializationRepository;
import com.hams.hamsvc.requestDTO.DepartmentRequest;
import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.DepartmentResponse;
import com.hams.hamsvc.responseDTO.SpecializationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{


        @Autowired
        private DepartmentRepository departmentRepository;

        @Autowired
        private AdminRepository adminRepository;

        @Autowired
        private DepartmentMapper departmentMapper;

        public DepartmentResponse createDepartment(Integer adminId, DepartmentRequest departmentRequest) {
            Admin admin = adminRepository.findById(adminId)
                    .orElseThrow(() -> new
                            AdminNotFoundException("Admin with ID " + adminId + " not found"));

            Department department = departmentMapper.mapToDepartment(departmentRequest, admin);
            Department savedDepartment = departmentRepository.save(department);

            return departmentMapper.mapToDepartmentResponse(savedDepartment);
        }

    }


