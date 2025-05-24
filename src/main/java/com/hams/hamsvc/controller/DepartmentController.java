//package com.hams.hamsvc.controller;
//
//import com.hams.hamsvc.requestDTO.DepartmentRequest;
//import com.hams.hamsvc.requestDTO.SpecializationRequest;
//import com.hams.hamsvc.responseDTO.DepartmentResponse;
//import com.hams.hamsvc.responseDTO.SpecializationResponse;
//import com.hams.hamsvc.service.DepartmentService;
//import com.hams.hamsvc.utility.AppResponseBuilder;
//import com.hams.hamsvc.utility.ResponseStructure;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("${hospital.base_url}")
//public class DepartmentController {
//
//        @Autowired
//        private DepartmentService departmentService;
//        @Autowired
//        private AppResponseBuilder appResponseBuilder;
//
//        @PostMapping("/admin/departments")
//        @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<ResponseStructure<DepartmentResponse>> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
//            DepartmentResponse departmentResponse = departmentService.createDepartment( departmentRequest);
//            return  appResponseBuilder.success(HttpStatus.CREATED, "Department created successfully by admin", departmentResponse);
//        }
//
//    }


