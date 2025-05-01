package com.hams.hamsvc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_no")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
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
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
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
