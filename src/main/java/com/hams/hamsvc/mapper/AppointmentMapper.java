package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Appointment;
import com.hams.hamsvc.requestDTO.AppointmentRequest;
import com.hams.hamsvc.responseDTO.AppointmentResponse;

public class AppointmentMapper {

    public Appointment mapToAppointment(AppointmentRequest appointmentRequest){
        Appointment appointment=new Appointment();
        appointment.setAppointmentDateTime(appointmentRequest.getAppointmentDateTime());
        appointment.setAppointmentStatus(appointmentRequest.getAppointmentStatus());
        return appointment;
    }
    public AppointmentResponse mapToAppointmentResponse(Appointment appointment){
        AppointmentResponse appointmentResponse=new AppointmentResponse();
        appointmentResponse.setAppointmentId(appointment.getAppointmentId());
        appointmentResponse.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appointmentResponse.setAppointmentStatus(appointment.getAppointmentStatus());

        return appointmentResponse;
    }
}
