package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class WorkoutDTOConverter implements Converter<Workout, WorkoutDTO> {

    @Override
    public WorkoutDTO convert(Workout source) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(source.getUuid());
        workoutDTO.setDuration(source.getDuration());
        workoutDTO.setTimeStamp(source.getTimeStamp());
        workoutDTO.setCal(source.getCal());

        return workoutDTO;
    }
}
