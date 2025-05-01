package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Patient;
import com.hams.hamsvc.requestDTO.PatientRequest;
import com.hams.hamsvc.responseDTO.PatientResponse;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient mapToPatient(PatientRequest patientRequest){
        Patient patient=new Patient();
        patient.setPatientName(patientRequest.getPatientName());
        patient.setEmail(patientRequest.getEmail());
        patient.setPassword(patientRequest.getPassword());
        patient.setPhoneNumber(patientRequest.getPhoneNumber());
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());

        return patient;
    }
    public PatientResponse mapToPatientResponse(Patient patient){
        PatientResponse patientResponse=new PatientResponse();
        patientResponse.setPatientId(patient.getPatientId());
        patientResponse.setPatientName(patient.getPatientName());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setPhoneNumber(patient.getPhoneNumber());
        patientResponse.setAge(patient.getAge());
        patientResponse.setGender(patient.getGender());

        return patientResponse;
    }
}
