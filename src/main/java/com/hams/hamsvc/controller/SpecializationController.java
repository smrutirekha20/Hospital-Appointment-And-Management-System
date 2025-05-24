package com.hams.hamsvc.controller;

import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.SpecializationResponse;
import com.hams.hamsvc.service.SpecializationService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${hospital.base_url}")
public class SpecializationController {
    @Autowired
    private AppResponseBuilder appResponseBuilder;
    @Autowired
    private SpecializationService specializationService;

    @PostMapping("admin/{adminId}/departments/{departmentId}/specializations")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseStructure<SpecializationResponse>> addSpecializationToDepartment(@PathVariable Integer adminId, @PathVariable Integer departmentId,
                                                                                                   @RequestBody SpecializationRequest specializationRequest){
        SpecializationResponse specializationResponse=specializationService.addSpecializationToDepartment(adminId,departmentId, specializationRequest);
        return appResponseBuilder.success(HttpStatus.CREATED,"Specialization added to department",specializationResponse);
    }
}
