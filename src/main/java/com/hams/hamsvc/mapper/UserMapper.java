package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.requestDTO.UserRequest;
import com.hams.hamsvc.responseDTO.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserRequest userRequest) {
        User user = new User();
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setUserRole(userRequest.getUserRole());

        return user;
    }
    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUserRole(user.getUserRole());

        return userResponse;
    }
}
