package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.DoctorRequest;
import com.hams.hamsvc.responseDTO.DoctorResponse;

public interface DoctorService {
     DoctorResponse createDoctorProfile( DoctorRequest doctorRequest, int adminId, int departmentId, int specializationId);
}
