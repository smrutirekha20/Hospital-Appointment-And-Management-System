package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.DepartmentRequest;
import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.DepartmentResponse;
import com.hams.hamsvc.responseDTO.SpecializationResponse;

public interface DepartmentService {

        DepartmentResponse createDepartment( DepartmentRequest departmentRequest);

    }


