package com.hams.hamsvc.repository;

import com.hams.hamsvc.entity.Doctor;
import com.hams.hamsvc.entity.Slot;
import com.hams.hamsvc.enums.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
    List<Slot> findSlotBySlotStatus(SlotStatus slotStatus);
    Optional<Slot> findByDoctorAndSlotDateAndSlotTimeAndSlotStatus(Doctor doctor, LocalDate date, LocalTime time, SlotStatus status);
}
