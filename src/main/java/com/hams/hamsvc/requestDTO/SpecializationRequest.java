package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SpecializationRequest {

    @NotBlank(message = "specialization name is required")
    public String specializationName;

    public void setSpecializationName(String specializationName){
        this.specializationName=specializationName;
    }
    public String getSpecializationName(){
        return specializationName;
    }

}
