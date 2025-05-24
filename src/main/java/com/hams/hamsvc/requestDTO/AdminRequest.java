package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;

@Data
public class AdminRequest {

    @NotBlank(message = "name is required")
    private String name;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}
