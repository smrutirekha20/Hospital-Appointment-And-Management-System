package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.requestDTO.DoctorRequest;
import com.hams.hamsvc.responseDTO.DoctorResponse;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

        public Doctor mapToDoctor(DoctorRequest doctorRequest) {
            Doctor doctor = new Doctor();
            doctor.setName(doctorRequest.getName());
            doctor.setEmail(doctorRequest.getEmail());
            doctor.setExperienceYears(doctorRequest.getExperienceYears());
            return doctor;
        }

        public DoctorResponse mapToDoctorResponse(Doctor doctor) {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setDoctorId(doctor.getDoctorId());
            doctorResponse.setName(doctor.getName());
            doctorResponse.setEmail(doctor.getEmail());
            doctorResponse.setExperienceYears(doctor.getExperienceYears());
            return doctorResponse;
        }
    }


