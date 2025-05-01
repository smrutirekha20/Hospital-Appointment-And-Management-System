package com.hams.hamsvc.controller;
import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;
import com.hams.hamsvc.service.PatientService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private  PatientService patientService;
    @Autowired
    private  AppResponseBuilder appResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<PatientResponse>> registerPatient(@RequestBody PatientRequest request){
        PatientResponse patientResponse = patientService.registerPatient(request);
       return appResponseBuilder.success(HttpStatus.CREATED,"patient registered successfully",patientResponse);
    }
}
