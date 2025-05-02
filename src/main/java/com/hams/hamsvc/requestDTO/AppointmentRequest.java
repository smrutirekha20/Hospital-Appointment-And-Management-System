package com.hams.hamsvc.requestDTO;

import com.hams.hamsvc.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class AppointmentRequest {
    private LocalDateTime appointmentDateAndTime;
    private AppointmentStatus appointmentStatus;

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
}
