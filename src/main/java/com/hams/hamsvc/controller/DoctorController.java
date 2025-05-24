//package com.hams.hamsvc.controller;
//
//import com.hams.hamsvc.requestDTO.DepartmentRequest;
//import com.hams.hamsvc.requestDTO.DoctorRequest;
//import com.hams.hamsvc.responseDTO.DepartmentResponse;
//import com.hams.hamsvc.responseDTO.DoctorResponse;
//import com.hams.hamsvc.service.DoctorService;
//import com.hams.hamsvc.utility.AppResponseBuilder;
//import com.hams.hamsvc.utility.ResponseStructure;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("${hospital.base_url}")
//public class DoctorController {
//
//    @Autowired
//    private AppResponseBuilder appResponseBuilder;
//    @Autowired
//    private DoctorService doctorService;
//
//    @PostMapping("admin/doctor/{departmentId}/{specializationId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<ResponseStructure<DoctorResponse>> createDoctorProfile(@RequestBody DoctorRequest doctorRequest,
//                                                                                     @PathVariable int adminId,
//                                                                                     @PathVariable int departmentId,
//                                                                                     @PathVariable int specializationId) {
//        DoctorResponse doctorResponse = doctorService.createDoctorProfile(doctorRequest,adminId, departmentId,specializationId);
//        return  appResponseBuilder.success(HttpStatus.CREATED, "doctor created by admin successfully", doctorResponse);
//    }
//    @GetMapping("patients/search/doctors/{departmentName}/{specializationName}")
//    public ResponseEntity<ResponseStructure<List<DoctorResponse>>> searchDoctors (@PathVariable String departmentName, @PathVariable String specializationName) {
//        List<DoctorResponse> doctors = doctorService.getDoctorsByDepartmentAndSpecialization(departmentName,specializationName);
//        return appResponseBuilder.success(HttpStatus.OK,"Doctors found", doctors);
//    }
//}
