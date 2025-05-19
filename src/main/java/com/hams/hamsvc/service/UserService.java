package com.hams.hamsvc.service;


import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.mapper.UserMapper;
import com.hams.hamsvc.repository.UserRepository;

import com.hams.hamsvc.requestDTO.LoginRequest;
import com.hams.hamsvc.requestDTO.UserRequest;
import com.hams.hamsvc.responseDTO.UserResponse;
import com.hams.hamsvc.security.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthUtil authUtil;

    public UserResponse saveUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = userMapper.mapToUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword())); // encrypting password
        user = userRepository.save(user);

        return userMapper.mapToUserResponse(user);
    }

    public UserResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            User user = userRepository
                    .findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found "));


            UserResponse userResponse = new UserResponse();

            userResponse.setUserId(user.getUserId());
            userResponse.setEmail(user.getEmail());
            userResponse.setUserRole(user.getUserRole());

            return userResponse;
        } else {
            throw new UsernameNotFoundException("Failed to found username");
        }

    }
}

