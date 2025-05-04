package com.hams.hamsvc.requestDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotRequest {

    private LocalDate slotDate;
    private LocalTime slotTime;

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
}
