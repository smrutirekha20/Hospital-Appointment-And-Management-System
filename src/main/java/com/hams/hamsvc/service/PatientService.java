package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;

public interface PatientService {
    PatientResponse registerPatient(PatientRequest patientRequest);
    PatientResponse updatePatientRegisteredProfile(PatientRequest patientRequest,Integer patientId);
}
