package com.hams.hamsvc.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@AllArgsConstructor
public class DepartmentRequest {

        @NotBlank(message = "Department name is required")
        private String departmentName;

        public void setDepartmentName(String departmentName){
            this.departmentName=departmentName;
        }
        public String getDepartmentName(){
            return departmentName;
        }
    }


