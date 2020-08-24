package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutConverter workoutConverter;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Transactional
    public int createWorkout(WorkoutDTO workoutDTO, String userId) {
        ApplicationUser applicationUser = applicationUserService.getById(userId);
        Workout workout = workoutConverter.convert(workoutDTO, applicationUser);
        return 201;
    }

}
