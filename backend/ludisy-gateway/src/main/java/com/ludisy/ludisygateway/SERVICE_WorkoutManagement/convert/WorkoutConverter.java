package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.BikingDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkoutConverter {

    @Autowired
    WorkoutDataConverter workoutDataConverter;

    public Workout convert(WorkoutDTO source, ApplicationUser applicationUser) {
        Workout workout = new Workout();
        workout.setUuid(source.getId());
        workout.setDuration(source.getDuration());
        workout.setTimeStamp(source.getTimeStamp());
        workout.setCal(source.getCal());

        WorkoutData workoutData = workoutDataConverter.convert(source.getData(), source.getType());
        workout.setWorkoutData(workoutDataConverter.convert(source.getData(), source.getType()));
        applicationUser.addWorkout(workout);

        return workout;
    }
}
