package com.hams.hamsvc.service;

import com.hams.hamsvc.entity.Admin;
import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.entity.Slot;
import com.hams.hamsvc.enums.SlotStatus;
import com.hams.hamsvc.exception.AdminNotFoundException;
import com.hams.hamsvc.exception.DoctorNotFoundException;
import com.hams.hamsvc.mapper.SlotMapper;
import com.hams.hamsvc.repository.AdminRepository;
import com.hams.hamsvc.repository.DoctorRepository;
import com.hams.hamsvc.repository.SlotRepository;
import com.hams.hamsvc.requestDTO.SlotRequest;
import com.hams.hamsvc.responseDTO.SlotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotServiceImpl implements SlotService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SlotMapper slotMapper;

    @Autowired
    private SlotRepository slotRepository;

    public SlotResponse addSlot(Integer adminId, Integer doctorId, SlotRequest slotRequest){
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(()-> new AdminNotFoundException("Admin not found by id"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new DoctorNotFoundException("Doctor not found"));

        Slot slot = slotMapper.mapToSlot(slotRequest);
        slot.setAdmin(admin);
        slot.setDoctor(doctor);
        slot.setSlotStatus(SlotStatus.AVAILABLE);

       Slot savedSlot = slotRepository.save(slot);
       return slotMapper.mapToSlotResponse(savedSlot);
    }
    public List<SlotResponse> getAvailableSlots(){
        List<Slot> slots = slotRepository.findSlotBySlotStatus(SlotStatus.AVAILABLE);
        return slots.stream()
                .map(slotMapper::mapToSlotResponse)
                .collect(Collectors.toList());
    }
}
