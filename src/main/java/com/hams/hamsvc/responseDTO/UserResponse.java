package com.hams.hamsvc.responseDTO;

import com.hams.hamsvc.enums.UserRole;

public class UserResponse {
    private Integer userId;
    private String email;
    private UserRole userRole;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
