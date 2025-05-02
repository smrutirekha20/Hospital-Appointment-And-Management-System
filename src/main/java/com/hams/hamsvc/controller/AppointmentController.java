package com.hams.hamsvc.controller;

import com.hams.hamsvc.responseDTO.DoctorResponse;
import com.hams.hamsvc.service.AppointmentService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @GetMapping("/search/doctors/{departmentName}/{specializationName}")
    public ResponseEntity<ResponseStructure<List<DoctorResponse>>> searchDoctors (@PathVariable String departmentName, @PathVariable String specializationName) {
       List<DoctorResponse> doctors = appointmentService.getDoctorsByDepartmentAndSpecialization(departmentName,specializationName);
       return appResponseBuilder.success(HttpStatus.OK,"Doctors found", doctors);
    }
}
