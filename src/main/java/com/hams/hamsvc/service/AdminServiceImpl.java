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
import org.springframework.beans.factory.annotation.Autowired;
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
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminResponse createAdmin(Principal principal, AdminRequest adminRequest) {
        String email=principal.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        if (user.getUserRole() != UserRole.ADMIN) {
            throw new IllegalArgumentException("User is not assigned role ADMIN");
        }

        Admin admin = new Admin();
        admin.setUser(user);
        admin.setName(adminRequest.getName());
        admin.setEmail(adminRequest.getEmail());

        Admin savedAdmin = adminRepository.save(admin);
        System.out.println("Saved admin ID: " + savedAdmin.getAdminId());

        return adminMapper.toAdminResponse(savedAdmin);
    }
}

