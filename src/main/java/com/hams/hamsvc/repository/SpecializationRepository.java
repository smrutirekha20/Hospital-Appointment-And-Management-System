package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Department;
import com.hams.hamsvc.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer> {
    Optional<Specialization> findBySpecializationNameAndDepartment(String specializationName, Department department);
    Optional<Specialization> findBySpecializationName(String specializationName);
}
