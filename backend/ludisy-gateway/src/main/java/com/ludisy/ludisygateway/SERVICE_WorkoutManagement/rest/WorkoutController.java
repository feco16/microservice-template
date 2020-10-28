package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.rest;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    @Autowired
    public WorkoutService workoutService;

    @PostMapping("/workout")
    public void createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        workoutService.createWorkout(workoutDTO, "100");
    }

}
