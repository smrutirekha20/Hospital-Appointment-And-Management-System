package com.hams.hamsvc.requestDTO;

import com.hams.hamsvc.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotNull
    @NotBlank(message = "please enter email in proper format")
    private String email;

    @NotNull
    @NotBlank(message = "please enter at least 5 character")
    @Size(min=5)
    private String password;

    @NotNull
    private UserRole userRole;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
