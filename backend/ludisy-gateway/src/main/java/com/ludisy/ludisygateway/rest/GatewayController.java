package com.ludisy.ludisygateway.rest;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class GatewayController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome at Ludisy!";
    }

    @GetMapping("/workout/{userId}")
    public List<WorkoutDTO> getWorkoutsByUserId(@PathVariable(value = "userId") String userId){
        return workoutService.getWorkoutDTOList(userId);
    }
}
