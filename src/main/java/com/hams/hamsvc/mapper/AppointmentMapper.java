package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Appointment;
import com.hams.hamsvc.requestDTO.AppointmentRequest;
import com.hams.hamsvc.responseDTO.AppointmentResponse;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public Appointment mapToAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentStatus(appointmentRequest.getAppointmentStatus());
        return appointment;
    }

    public AppointmentResponse mapToAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentId(appointment.getAppointmentId());
        appointmentResponse.setAppointmentDateAndTime(appointment.getAppointmentDateAndTime());
        appointmentResponse.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentResponse.setDoctorName(appointment.getDoctor().getName());
        appointmentResponse.setSlotDate(appointment.getSlot().getSlotDate());
        appointmentResponse.setSlotTime(appointment.getSlot().getSlotTime());

        return appointmentResponse;
    }
}
