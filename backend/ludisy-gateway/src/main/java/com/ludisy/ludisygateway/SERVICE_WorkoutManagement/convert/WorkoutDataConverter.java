package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.Constants;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDataDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Biking;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutDataConverter {

    private ObjectMapper mapper = new ObjectMapper();

    public WorkoutData convert(WorkoutDataDTO source, int workoutType) {
        WorkoutData workoutData = new WorkoutData();
        if (workoutType == 1) {
            workoutData.setDistance(source.getDistance());
            if (!CollectionUtils.isEmpty(source.getSnapShots())) {
                for (Object object : source.getSnapShots()) {
                    Biking biking = mapper.convertValue(object, Biking.class);
                    workoutData.addBiking(biking);
                }
            }

        }
        return workoutData;
    }
}
