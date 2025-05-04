package com.hams.hamsvc.controller;

import com.hams.hamsvc.entity.Slot;
import com.hams.hamsvc.requestDTO.SlotRequest;
import com.hams.hamsvc.responseDTO.SlotResponse;
import com.hams.hamsvc.service.SlotService;
import com.hams.hamsvc.utility.AppResponseBuilder;
import com.hams.hamsvc.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {
    @Autowired
    private AppResponseBuilder appResponseBuilder;
    @Autowired
    private SlotService slotService;

    @PostMapping("/admin/{adminId}/doctor/{doctorId}")
    public ResponseEntity<ResponseStructure<SlotResponse>> addSlot(@PathVariable Integer adminId, @PathVariable Integer doctorId, @RequestBody SlotRequest slotRequest){
        SlotResponse response = slotService.addSlot(adminId,doctorId,slotRequest);
        return appResponseBuilder.success(HttpStatus.CREATED,"Slot added",response);
    }
    @GetMapping
    public ResponseEntity<ResponseStructure<List<SlotResponse>>> getAvailableSlot(){
        List<SlotResponse> slots =slotService.getAvailableSlots();
        return appResponseBuilder.success(HttpStatus.FOUND,"Available slot fetched successfully",slots);
    }
}
