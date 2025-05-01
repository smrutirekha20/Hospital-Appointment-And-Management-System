package com.hams.hamsvc.mapper;

import com.hams.hamsvc.entity.Specialization;
import com.hams.hamsvc.requestDTO.SpecializationRequest;
import com.hams.hamsvc.responseDTO.SpecializationResponse;
import org.springframework.stereotype.Component;

@Component
public class SpecializationMapper {
  public Specialization mapToSpecialization(SpecializationRequest specializationRequest){
      Specialization specialization=new Specialization();
      specialization.setSpecializationName(specializationRequest.getSpecializationName());

      return specialization;
  }
    public SpecializationResponse mapToSpecializationResponse(Specialization specialization) {
        SpecializationResponse response = new SpecializationResponse();
        response.setSpecializationId(specialization.getSpecializationId());
        response.setSpecializationName(specialization.getSpecializationName());
        return response;
    }
}
