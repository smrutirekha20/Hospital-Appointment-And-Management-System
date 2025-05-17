package com.hams.hamsvc.controller;

import com.hams.hamsvc.requestDTO.AppointmentRequest;
import com.hams.hamsvc.responseDTO.AppointmentResponse;
import com.hams.hamsvc.responseDTO.DoctorResponse;
import com.hams.hamsvc.service.AppointmentService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${hospital.base_url}")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppResponseBuilder appResponseBuilder;


    @PostMapping("/patients/{patientId}/doctors/{doctorName}")
    public ResponseEntity<ResponseStructure<AppointmentResponse>> bookAppointments(@PathVariable Integer patientId, @PathVariable String doctorName, @RequestBody AppointmentRequest appointmentRequest){
        AppointmentResponse appointmentResponse = appointmentService.bookAppointment(patientId,doctorName,appointmentRequest);
        return appResponseBuilder.success(HttpStatus.CREATED,"Appointment Booked By Patient",appointmentResponse);
    }
}
