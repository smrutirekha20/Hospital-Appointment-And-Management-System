package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.requestDTO.DepartmentRequest;
import com.hams.hamsvc.responseDTO.DepartmentResponse;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
        public Department mapToDepartment(DepartmentRequest departmentRequest, Admin admin) {
            Department department = new Department();
            department.setDepartmentName(departmentRequest.getDepartmentName());
            department.setAdmin(admin);  // Linking the department to the admin
            return department;
        }
        public DepartmentResponse mapToDepartmentResponse(Department department) {
            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setDepartmentId(department.getDepartmentId());
            departmentResponse.setDepartmentName(department.getDepartmentName());
            departmentResponse.setCreatedByAdminName(department.getAdmin().getName());
            return departmentResponse;
        }
    }


