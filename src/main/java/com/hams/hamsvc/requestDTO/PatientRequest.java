package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PatientRequest {

    @NotNull
    @NotBlank(message = "name is required")
    private String patientName;

    @NotBlank(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "email must be end with @gmail.com")
    private String email;

    @NotNull
    @NotBlank(message = "password should not blank")
    private String password;

    @NotNull(message = "phone number is required")
    private String phoneNumber;

    @NotNull(message = "gender is required")
    private String gender;

    @NotNull(message = "age is required")
    private String age;

    public void setPatientName(String patientName){
        this.patientName = patientName;
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
