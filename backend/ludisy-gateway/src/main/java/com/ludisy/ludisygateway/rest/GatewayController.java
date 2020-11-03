package com.ludisy.ludisygateway.rest;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class GatewayController {

    private static final Logger logger = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome at Ludisy!";
    }

    // UserManagement
    @GetMapping("/user/{userId}")
    public ApplicationUserDTO getUserById(@PathVariable(value = "userId") String userId) {
        logger.info("Get user by id: {}", userId);
        return applicationUserService.getDTOById(userId);
    }

    @DeleteMapping("/user/{userId}/workouts")
    public int deleteWorkoutsByUserId(@PathVariable(value = "userId") String userId) {
        applicationUserService.deleteWorkoutsByUserId(userId);
        return 201;
    }

    // WorkoutManagement
    @PostMapping("/workout")
    public int postWorkout(@RequestBody WorkoutDTO workoutDTO, @RequestParam(value = "userId") String userId) {
        logger.info("Post workout to user with id {}", userId);
        logger.debug("Workout: {}", workoutDTO);
        return workoutService.createWorkout(workoutDTO, userId);
    }

    @GetMapping("/workouts")
    public List<WorkoutDTO> getWorkoutsByTimestamp(@RequestParam(value = "userId") String userId,
                                            @RequestParam(value = "startingDay") Long startingDay,
                                            @RequestParam(value = "endingDay") Long endingDay) {
        logger.info("Get workouts by timestamp for user id {} between {} and {}", userId, startingDay, endingDay);
        return workoutService.getWorkoutsByTimestamp(userId, startingDay, endingDay);
    }



}
