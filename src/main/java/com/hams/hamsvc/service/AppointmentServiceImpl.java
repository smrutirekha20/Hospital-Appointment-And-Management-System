package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.*;
import com.hams.hamsvc.enums.AppointmentStatus;
import com.hams.hamsvc.enums.SlotStatus;
import com.hams.hamsvc.exception.*;
import com.hams.hamsvc.mapper.AppointmentMapper;
import com.hams.hamsvc.mapper.DoctorMapper;
import com.hams.hamsvc.repository.*;
import com.hams.hamsvc.requestDTO.AppointmentRequest;
import com.hams.hamsvc.responseDTO.AppointmentResponse;
import com.hams.hamsvc.responseDTO.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<DoctorResponse> getDoctorsByDepartmentAndSpecialization(String departmentName, String specializationName) {

        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        Specialization specialization = specializationRepository.findBySpecializationName(specializationName)
                .orElseThrow(() -> new SpecializationNotFoundException("Specialization not found"));


        List<Doctor> doctors = doctorRepository.findByDepartmentAndSpecialization(department, specialization);

        return doctors.stream()
                .map(doctorMapper::mapToDoctorResponse)
                .collect(Collectors.toList());
    }
    public AppointmentResponse bookAppointment(Integer patientId, String doctorName, AppointmentRequest appointmentRequest) {

        Doctor doctor = doctorRepository.findByName(doctorName)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with name: " + doctorName));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));

        Slot slot = slotRepository.findByDoctorAndSlotDateAndSlotTimeAndSlotStatus(doctor, appointmentRequest.getSlotDate(), appointmentRequest.getSlotTime(),SlotStatus.AVAILABLE)
                .orElseThrow(() -> new NoSuchSlotAvailableException("No such slot exists on selected date and time."));

        if (slot.getSlotStatus() == SlotStatus.AVAILABLE) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentDateAndTime(LocalDateTime.of(appointmentRequest.getSlotDate(), appointmentRequest.getSlotTime()));
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setSlot(slot);
            appointment.setAppointmentStatus(AppointmentStatus.CONFIRMED);

            slot.setSlotStatus(SlotStatus.NOT_AVAILABLE);
            slotRepository.save(slot);

            Appointment savedAppointment = appointmentRepository.save(appointment);
            return appointmentMapper.mapToAppointmentResponse(savedAppointment);
        } else {
            throw new NoSuchSlotAvailableException("Slot is already booked.");
        }
    }

}
