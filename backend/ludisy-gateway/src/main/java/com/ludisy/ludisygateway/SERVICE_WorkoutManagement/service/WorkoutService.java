package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.Biking;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<WorkoutDTO> getWorkoutDTOList (String userId){
        Biking biking = new Biking();
        biking.setDistance(16);

        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId("1");
        workoutDTO.setType(1);
        workoutDTO.setData(biking);

        List<WorkoutDTO> workoutDTOList = new ArrayList<>();
        workoutDTOList.add(workoutDTO);
        return workoutDTOList;
    }
}
