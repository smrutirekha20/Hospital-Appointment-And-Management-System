package com.hams.hamsvc.controller;
import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;
import com.hams.hamsvc.service.PatientService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${hospital.base_url}")
@Slf4j
public class PatientController {

    @Autowired
    private  PatientService patientService;
    @Autowired
    private  AppResponseBuilder appResponseBuilder;

    @PostMapping("/patients")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ResponseStructure<PatientResponse>> registerPatient(@RequestBody PatientRequest request){
        PatientResponse patientResponse = patientService.registerPatient(request);
       return appResponseBuilder.success(HttpStatus.CREATED,"patient registered successfully",patientResponse);
    }

    @PutMapping("/admin/patients/{patientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseStructure<PatientResponse>> updatePatientRegisteredProfile(@RequestBody PatientRequest patientRequest, @PathVariable Integer patientId){

        System.out.println(" /admin/patients/" + patientId);
        System.out.println("Received name: " + patientRequest.getPatientName());
        PatientResponse patientResponse = patientService.updatePatientProfile(patientRequest,patientId);
        return appResponseBuilder.success(HttpStatus.CREATED,"Patient details updated",patientResponse);
    }
//    @GetMapping("/whoami")
//    public ResponseEntity<?> whoami() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return ResponseEntity.ok(auth.getAuthorities());
//    }
}
