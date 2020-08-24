package com.ludisy.ludisygateway.SERVICE_UserManagement.converter;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutDTOConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApplicationUserDTOConverter implements Converter<ApplicationUser, ApplicationUserDTO> {

    @Autowired
    private WorkoutDTOConverter workoutDTOConverter;

    @Override
    public ApplicationUserDTO convert(ApplicationUser source) {
        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
        applicationUserDTO.setUserId(source.getUserId());
        applicationUserDTO.setUsername(source.getUsername());
        applicationUserDTO.setPassword(source.getPassword());

        List<WorkoutDTO> workoutDTOList = new ArrayList<>();
        for (Workout workout : source.getWorkouts()) {
            workoutDTOList.add(workoutDTOConverter.convert(workout));
        }
        applicationUserDTO.setWorkouts(workoutDTOList);

        return applicationUserDTO;
    }
}
