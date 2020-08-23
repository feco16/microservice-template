package com.ludisy.ludisygateway.rest;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class GatewayController {

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome at Ludisy!";
    }

    @GetMapping("/user/{userId}")
    public ApplicationUserDTO getUserById(@PathVariable(value = "userId") long userId) {
        return applicationUserService.getDTOById(userId);
    }

    @PostMapping("/workout")
    public int postWorkout(@RequestBody WorkoutDTO workoutDTO, @RequestParam(value = "userId") long userId) {
        return workoutService.createWorkout(workoutDTO, userId);
    }
}
