package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
   Optional<Patient> findByEmail(String email);
}
