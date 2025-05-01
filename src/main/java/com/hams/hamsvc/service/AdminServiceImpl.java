package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.exception.EmailAlreadyExistsException;
import com.hams.hamsvc.mapper.AdminMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminResponse createAdmin(AdminRequest request) {
        if (adminRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
        }

        Admin admin = adminMapper.toadmin(request);
        Admin savedAdmin = adminRepository.save(admin);
        return adminMapper.toAdminResponse(savedAdmin);
    }
}

