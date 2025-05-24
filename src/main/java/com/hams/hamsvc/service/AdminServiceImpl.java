package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.User;
import com.hams.hamsvc.enums.UserRole;
import com.hams.hamsvc.exception.EmailAlreadyExistsException;
import com.hams.hamsvc.mapper.AdminMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.UserRepository;
import com.hams.hamsvc.requestDTO.AdminRequest;
import com.hams.hamsvc.responseDTO.AdminResponse;
import com.hams.hamsvc.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public AdminResponse createAdmin(AdminRequest adminRequest) {
        User user = authUtil.getCurrentUser();

        if (user.getUserRole() != UserRole.ADMIN) {
            throw new IllegalArgumentException("User is not assigned role ADMIN");
        }

        Admin admin = adminRepository.findByUser(user)
                .orElseGet(() -> {
                    Admin newAdmin = new Admin();
                    newAdmin.setName(adminRequest.getName());
                    newAdmin.setUser(user);
                    // set fields
                    return adminRepository.save(newAdmin);
                });

        System.out.println("Saved admin ID: " + admin.getAdminId());

        return adminMapper.toAdminResponse(admin);
    }
}

