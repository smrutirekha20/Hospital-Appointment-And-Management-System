package com.hams.hamsvc.controller;

import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;
import com.hams.hamsvc.service.AdminService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("${hospital.base_url}")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(Principal principal, @RequestBody @Valid AdminRequest request) {
        AdminResponse response = adminService.createAdmin(principal,request);
        return appResponseBuilder.success(HttpStatus.CREATED, "Admin created successfully", response);
    }
//    @GetMapping("/csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
}


