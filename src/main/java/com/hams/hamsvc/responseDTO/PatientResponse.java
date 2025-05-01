package com.hams.hamsvc.responseDTO;

import lombok.Data;

@Data
public class PatientResponse {
    private Integer patientId;
    private String patientName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String age;
    public void setPatientId(Integer patientId){
        this.patientId=patientId;
    }
    public Integer getPatientId(){
        return patientId;
    }
    public void setPatientName(String patientName){
        this.patientName=patientName;
    }

    public String getPatientName(){
        return patientName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getAge(){
        return age;
    }
}
