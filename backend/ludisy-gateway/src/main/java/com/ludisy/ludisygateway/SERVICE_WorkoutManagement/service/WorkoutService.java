package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutDTOConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.Biking;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutDTOConverter workoutDTOConverter;

    public List<WorkoutDTO> getWorkoutDTOList (String userId){
        Workout workout = workoutRepository.findByUuid(userId);
        WorkoutDTO workoutDTO = workoutDTOConverter.convert(workout);

        List<WorkoutDTO> workoutDTOList = new ArrayList<>();
        workoutDTOList.add(workoutDTO);
        return workoutDTOList;
    }
}
