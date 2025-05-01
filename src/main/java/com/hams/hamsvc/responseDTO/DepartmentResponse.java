package com.hams.hamsvc.responseDTO;

import lombok.Data;

@Data
public class DepartmentResponse {
        private Integer departmentId;
        private String departmentName;
        private String createdByAdminName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCreatedByAdminName() {
        return createdByAdminName;
    }

    public void setCreatedByAdminName(String createdByAdminName) {
        this.createdByAdminName = createdByAdminName;
    }
    }


