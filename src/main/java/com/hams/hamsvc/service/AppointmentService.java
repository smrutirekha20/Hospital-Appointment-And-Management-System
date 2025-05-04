package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.AppointmentRequest;
import com.hams.hamsvc.responseDTO.AppointmentResponse;
import com.hams.hamsvc.responseDTO.DoctorResponse;

import java.util.List;

public interface AppointmentService {
        List<DoctorResponse> getDoctorsByDepartmentAndSpecialization(String departmentName, String specializationName);
        AppointmentResponse bookAppointment(Integer patientId, String doctorName, AppointmentRequest appointmentRequest);
    }


