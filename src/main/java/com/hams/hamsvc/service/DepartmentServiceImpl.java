package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Specialization;
import com.hams.hamsvc.entity.User;
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
import com.hams.hamsvc.security.AuthUtil;
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

        @Autowired
        private AuthUtil authUtil;

        public DepartmentResponse createDepartment( DepartmentRequest departmentRequest) {
            User loggedInUser = authUtil.getCurrentUser();
            System.out.println("User ID: " + loggedInUser.getUserId());
            Admin admin = adminRepository.findByUser_userId(loggedInUser.getUserId())
                    .orElseThrow(() -> new
                            AdminNotFoundException("Admin with Id not found"));
            System.out.println("Admin ID: " + admin.getAdminId());

            Department department = departmentMapper.mapToDepartment(departmentRequest, admin);
            Department savedDepartment = departmentRepository.save(department);

            return departmentMapper.mapToDepartmentResponse(savedDepartment);
        }

    }


