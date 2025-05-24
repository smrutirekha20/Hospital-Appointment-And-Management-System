package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoctorRequest {

    @NotBlank(message = "name is required")
    private String name;
    @NotNull
    @NotBlank(message = "experience is required")
    private double experienceYears;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setExperienceYears(double experienceYears){
        this.experienceYears=experienceYears;
    }
    public double getExperienceYears(){
        return experienceYears;
    }
}
