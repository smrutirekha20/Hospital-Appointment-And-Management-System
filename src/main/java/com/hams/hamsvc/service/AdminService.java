package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;

import java.security.Principal;

public interface AdminService {
    AdminResponse createAdmin( AdminRequest request);
}


