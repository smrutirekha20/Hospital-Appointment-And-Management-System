package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public Admin toadmin(AdminRequest request) {
        Admin admin = new Admin();
        admin.setName(request.getName());
        admin.setEmail(request.getEmail());
        return admin;
    }

    public AdminResponse toAdminResponse(Admin admin) {
        AdminResponse response = new AdminResponse();
        response.setAdminId(admin.getAdminId());
        response.setName(admin.getName());
        response.setEmail(admin.getEmail());
        return response;
    }
}
