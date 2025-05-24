package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUser(User user);
    Optional<Admin> findByUser_userId(Integer userId);

}
