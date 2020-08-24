package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.Constants;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDataDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Biking;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutDataDTOConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public WorkoutDataDTO convert(WorkoutData source, Constants.WORKOUT_TYPE type) {
        WorkoutDataDTO workoutDataDTO = new WorkoutDataDTO();

        if (type.equals(Constants.WORKOUT_TYPE.BIKING)) {
            List<Object> bikingList = new ArrayList<>();
            if (!CollectionUtils.isEmpty(source.getBikingList())) {
                for (Biking biking : source.getBikingList()) {
                    bikingList.add(objectMapper.convertValue(biking, Object.class));
                }
            }
            workoutDataDTO.setSnapShots(bikingList);


        }
        workoutDataDTO.setDistance(source.getDistance());
        return workoutDataDTO;
    }
}
