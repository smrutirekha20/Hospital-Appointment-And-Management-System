package com.hams.hamsvc.responseDTO;

public class SpecializationResponse {
    private Integer specializationId;
    private String specializationName;

    public void setSpecializationId(Integer specializationId){
        this.specializationId=specializationId;
    }
    public Integer getSpecializationId(){
        return specializationId;
    }
    public void setSpecializationName(String specializationName){
        this.specializationName=specializationName;
    }
    public String getSpecializationName(){
        return specializationName;
    }
}
