package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Slot;
import com.hams.hamsvc.requestDTO.SlotRequest;
import com.hams.hamsvc.responseDTO.SlotResponse;
import org.springframework.stereotype.Component;

@Component
public class SlotMapper {
    public Slot mapToSlot(SlotRequest slotRequest){
        Slot slot = new Slot();
        slot.setSlotDate(slotRequest.getSlotDate());
        slot.setSlotTime(slotRequest.getSlotTime());
        return slot;
    }
    public SlotResponse mapToSlotResponse(Slot slot){
        SlotResponse slotResponse = new SlotResponse();
        slotResponse.setSlotId(slot.getSlotId());
        slotResponse.setSlotDate(slot.getSlotDate());
        slotResponse.setSlotTime(slot.getSlotTime());
        slotResponse.setSlotStatus(slot.getSlotStatus());

        return slotResponse;
    }
}
