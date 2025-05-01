package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoctorRequest {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "email must be end with @gmail.com")
    private String email;

    @NotNull
    private double experienceYears;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setExperienceYears(double experienceYears){
        this.experienceYears=experienceYears;
    }
    public double getExperienceYears(){
        return experienceYears;
    }
}
