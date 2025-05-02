package com.hams.hamsvc.responseDTO;

import com.hams.hamsvc.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class AppointmentResponse {

    private Integer appointmentId;
    private LocalDateTime appointmentDateAndTime;
    private AppointmentStatus appointmentStatus;

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentId(){
        return appointmentId;
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
}
