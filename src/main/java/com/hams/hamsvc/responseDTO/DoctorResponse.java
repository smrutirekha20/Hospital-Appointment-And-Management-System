package com.hams.hamsvc.responseDTO;

import lombok.Data;

@Data
public class DoctorResponse {

    private int doctorId;
    private String name;
    private String email;
    private double experienceYears;

    public void setDoctorId(int doctorId){
        this.doctorId=doctorId;
    }
    public int getDoctorId(){
        return doctorId;
    }
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
