package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutDTOConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import com.ludisy.ludisygateway.shared.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutConverter workoutConverter;

    @Autowired
    private WorkoutDTOConverter workoutDTOConverter;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Transactional
    public WorkoutDTO createWorkout(WorkoutDTO workoutDTO, String userId) {
        ApplicationUser applicationUser = applicationUserService.getById(userId);
        if (null == applicationUser) {
            throw new NotFoundException("Application user with id " + userId + " does not exists");
        }
        workoutConverter.convert(workoutDTO, applicationUser);
        return workoutDTO;
    }

    public List<WorkoutDTO> getWorkoutsByTimestamp(String userId, Long startingDay, Long endingDay) {
        ApplicationUser applicationUser = applicationUserService.getById(userId);
        List<Workout> workoutList = workoutRepository.findByApplicationUser(applicationUser);

        List<WorkoutDTO> workoutDTOList = workoutList.stream()
                .filter(workout -> workout.getTimeStamp() > startingDay && workout.getTimeStamp() < endingDay)
                .map(workout -> workoutDTOConverter.convert(workout))
                .collect(Collectors.toList());

        return workoutDTOList;

    }
}
