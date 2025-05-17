package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.DoctorRequest;
import com.hams.hamsvc.responseDTO.DoctorResponse;

import java.util.List;

public interface DoctorService {
     DoctorResponse createDoctorProfile( DoctorRequest doctorRequest, int adminId, int departmentId, int specializationId);
     List<DoctorResponse> getDoctorsByDepartmentAndSpecialization(String departmentName, String specializationName);


}
