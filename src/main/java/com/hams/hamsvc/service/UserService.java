package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.entity.Patient;
import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.mapper.UserMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.DoctorRepository;
import com.hams.hamsvc.repository.PatientRepository;
import com.hams.hamsvc.repository.UserRepository;
import com.hams.hamsvc.requestDTO.UserRequest;
import com.hams.hamsvc.responseDTO.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private AdminRepository adminRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public UserResponse saveUser(@Valid @RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setUserRole(userRequest.getUserRole());

        switch (userRequest.getUserRole()) {
            case ADMIN -> {
                Admin admin = new Admin();
                admin.setUser(user);
                adminRepository.save(admin);
            }
            case DOCTOR -> {
                Doctor doctor = new Doctor();
                doctor.setUser(user);
                doctorRepository.save(doctor);
            }
            case PATIENT -> {
                Patient patient = new Patient();
                patient.setUser(user);
                patientRepository.save(patient);
            }
            default -> throw new IllegalArgumentException("Invalid role: " + userRequest.getUserRole());
        }

        return userMapper.mapToUserResponse(user);
    }

}

