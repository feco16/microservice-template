package com.ludisy.ludisygateway.SERVICE_UserManagement.converter;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ApplicationUserDTOConverter implements Converter<ApplicationUser, ApplicationUserDTO> {

    @Override
    public ApplicationUserDTO convert(ApplicationUser source) {
        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
        applicationUserDTO.setUserId(applicationUserDTO.getUserId());
        applicationUserDTO.setUsername(applicationUserDTO.getUsername());
        applicationUserDTO.setPassword(applicationUserDTO.getPassword());
        applicationUserDTO.setWorkouts(applicationUserDTO.getWorkouts());

        return applicationUserDTO;
    }
}
