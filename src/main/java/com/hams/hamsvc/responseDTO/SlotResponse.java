package com.hams.hamsvc.responseDTO;

import com.hams.hamsvc.enums.SlotStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotResponse {
    private Integer slotId;
    private LocalDate slotDate;
    private LocalTime slotTime;
    private SlotStatus slotStatus;


    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public LocalDate getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
    }

    public LocalTime getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }
}
