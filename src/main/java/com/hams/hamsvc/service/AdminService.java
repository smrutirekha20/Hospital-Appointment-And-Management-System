package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;

public interface AdminService {
    AdminResponse createAdmin(AdminRequest request);
}


