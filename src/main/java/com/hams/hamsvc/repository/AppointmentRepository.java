package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Appointment;
import com.hams.hamsvc.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    //boolean existsByDoctorAndAppointmentDateTime(Doctor doctor, LocalDateTime appointmentDateTime);
}
