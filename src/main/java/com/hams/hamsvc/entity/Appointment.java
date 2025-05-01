package com.hams.hamsvc.entity;

import com.hams.hamsvc.enums.AppointmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "appointment_id")
    private Integer appointmentId;

    @Column(name = "appointment_date_and_time")
    private LocalDateTime appointmentDateAndTime;

    @Column(name = "appointment_status")
    private AppointmentStatus appointmentStatus;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    public Integer getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateAndTime;
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateAndTime = appointmentDateTime;
    }
    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}

