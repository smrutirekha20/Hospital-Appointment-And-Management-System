package com.hams.hamsvc.service;


import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.mapper.UserMapper;
import com.hams.hamsvc.repository.UserRepository;

import com.hams.hamsvc.requestDTO.UserRequest;
import com.hams.hamsvc.responseDTO.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

       @Autowired
       private  UserRepository userRepository;

       @Autowired
        private PasswordEncoder passwordEncoder;

       @Autowired
        private UserMapper userMapper;
    public UserResponse saveUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

     User user = userMapper.mapToUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword())); // encrypting password
     user = userRepository.save(user);

        return userMapper.mapToUserResponse(user);
    }

}




//    public UserResponse login(String email, String password) {
//        // Step 1: Authenticate credentials
//        UsernamePasswordAuthenticationToken authToken =
//                new UsernamePasswordAuthenticationToken(email, password);
//
//        Authentication authentication = authenticationManager.authenticate(authToken);
//
//        // Step 2: Set authenticated user in context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Step 3: Retrieve logged-in user entity using AuthUtil
//        User loggedInUser = authUtil.getCurrentUser();
//
//        // Step 4: Map to response DTO (create mapper as needed)
//        UserResponse userResponse = new UserResponse();
//        userResponse.setUserId(loggedInUser.getUserId());
//        userResponse.setUserName(loggedInUser.getUserName());
//        userResponse.setEmail(loggedInUser.getEmail());
//        userResponse.setUserRole(loggedInUser.getUserRole());
//
//        return userResponse;
//    }


