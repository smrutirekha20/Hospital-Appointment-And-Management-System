package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    boolean existsByEmail(String email);
    List<Doctor> findByDepartmentAndSpecialization(Department department, Specialization specialization);
    Optional<Doctor> findByName(String name);
}
