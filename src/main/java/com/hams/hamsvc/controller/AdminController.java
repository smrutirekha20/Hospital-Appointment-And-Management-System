package com.hams.hamsvc.controller;

import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;
import com.hams.hamsvc.service.AdminService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody @Valid AdminRequest request) {
        AdminResponse response = adminService.createAdmin(request);
        return appResponseBuilder.success(HttpStatus.CREATED, "Admin created successfully", response);
    }
}


