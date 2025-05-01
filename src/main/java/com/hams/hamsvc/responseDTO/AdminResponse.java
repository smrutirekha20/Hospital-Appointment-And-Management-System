package com.hams.hamsvc.responseDTO;

import lombok.Data;

@Data
public class AdminResponse {

    private int adminId;
    private String name;
    private String email;

    public void setAdminId(int adminId){
        this.adminId=adminId;
    }
    public int getAdminId(){
        return adminId;
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
}
