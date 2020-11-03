package com.ludisy.ludisygateway.SERVICE_UserManagement.converter;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApplicationUserConverter implements Converter<ApplicationUserDTO, ApplicationUser> {

    @Autowired
    private WorkoutConverter workoutConverter;

    @Override
    public ApplicationUser convert(ApplicationUserDTO source) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserId(source.getUserId());
        applicationUser.setUsername(source.getUsername());
        applicationUser.setPassword(source.getPassword());

        List<Workout> workoutList = new ArrayList<>();
        for (WorkoutDTO workoutDTO : source.getWorkouts()) {
            workoutList.add(workoutConverter.convert(workoutDTO, applicationUser));
        }
        applicationUser.setWorkouts(workoutList);

        return applicationUser;
    }
}
