package com.hams.hamsvc.controller;

import com.hams.hamsvc.requestDTO.DepartmentRequest;
import com.hams.hamsvc.requestDTO.DoctorRequest;
import com.hams.hamsvc.responseDTO.DepartmentResponse;
import com.hams.hamsvc.responseDTO.DoctorResponse;
import com.hams.hamsvc.service.DoctorService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class DoctorController {

    @Autowired
    private AppResponseBuilder appResponseBuilder;
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/{adminId}/save-doctor/{departmentId}/{specializationId}")
    public ResponseEntity<ResponseStructure<DoctorResponse>> createDoctorProfile(@RequestBody DoctorRequest doctorRequest,
                                                                                     @PathVariable int adminId,
                                                                                     @PathVariable int departmentId,
                                                                                     @PathVariable int specializationId) {
        DoctorResponse doctorResponse = doctorService.createDoctorProfile(doctorRequest,adminId, departmentId,specializationId);
        return  appResponseBuilder.success(HttpStatus.CREATED, "doctor created by admin successfully", doctorResponse);
    }
}
