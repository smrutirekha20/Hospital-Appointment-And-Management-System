package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.SpecializationResponse;

public interface  SpecializationService {
    SpecializationResponse addSpecializationToDepartment(Integer adminId,Integer departmentId, SpecializationRequest specializationRequest);
    //SpecializationResponse deleteSpecialization(int specializationId);

}
