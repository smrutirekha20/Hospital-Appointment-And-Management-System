package com.hams.hamsvc.service;

import com.hams.hamsvc.requestDTO.SlotRequest;
import com.hams.hamsvc.responseDTO.SlotResponse;


import java.util.List;


public interface SlotService {
    SlotResponse addSlot(Integer adminId, Integer doctorId, SlotRequest slotRequest);
    List<SlotResponse> getAvailableSlots();
}
