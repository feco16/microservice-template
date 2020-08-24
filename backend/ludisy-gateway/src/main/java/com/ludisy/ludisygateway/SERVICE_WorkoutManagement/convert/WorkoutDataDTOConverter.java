package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDataDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Biking;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutDataDTOConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public WorkoutDataDTO convert(WorkoutData source) {
        WorkoutDataDTO workoutDataDTO = new WorkoutDataDTO();

        List<Object> bikingList = new ArrayList<>();
        for (Biking biking:source.getBikingList()) {
            bikingList.add(objectMapper.convertValue(biking, Object.class));
        }
        workoutDataDTO.setSnapShots(bikingList);
        workoutDataDTO.setDistance(source.getDistance());
        return workoutDataDTO;
    }
}
