package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class
WorkoutConverter implements Converter<WorkoutDTO, Workout> {

    @Override
    public Workout convert(WorkoutDTO source) {
        Workout workout = new Workout();
        workout.setUuid(source.getId());
        workout.setDuration(source.getDuration());
        workout.setTimeStamp(source.getTimeStamp());
        workout.setCal(source.getCal());

        return workout;
    }
}
