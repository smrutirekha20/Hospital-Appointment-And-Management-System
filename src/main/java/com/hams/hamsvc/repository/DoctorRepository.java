package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    boolean existsByEmail(String email);
}
