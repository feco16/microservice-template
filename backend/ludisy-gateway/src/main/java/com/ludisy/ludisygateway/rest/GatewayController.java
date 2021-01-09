package com.ludisy.ludisygateway.rest;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/user")
    public ResponseEntity<ApplicationUserDTO> postUser(@RequestBody ApplicationUserDTO applicationUserDTO) {
        logger.info("Create user with id: {}", applicationUserDTO.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(applicationUserService.createUser(applicationUserDTO));
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public void putUser(@RequestBody ApplicationUserDTO applicationUserDTO) {
        logger.info("Modify user with id: {}", applicationUserDTO.getUserId());
        applicationUserService.modifyUser(applicationUserDTO);
    }

    @GetMapping("/user/{userId}")
    public ApplicationUserDTO getUserById(@PathVariable(value = "userId") String userId) {
        logger.info("Get user by id: {}", userId);
        return applicationUserService.getDTOById(userId);
    }

    // WorkoutManagement

    @DeleteMapping("/user/{userId}/workouts")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkoutsByUserId(@PathVariable(value = "userId") String userId) {
        applicationUserService.deleteWorkoutsByUserId(userId);
    }

    @PostMapping("/user/{userId}/workout")
    public ResponseEntity<WorkoutDTO> postWorkout(@RequestBody WorkoutDTO workoutDTO, @PathVariable(value = "userId") String userId) {
        logger.info("Post workout to user with id {}", userId);
        logger.debug("Workout: {}", workoutDTO);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(workoutService.createWorkout(workoutDTO, userId));
    }

    @GetMapping("/user/{userId}/workouts")
    public List<WorkoutDTO> getWorkoutsByTimestamp(@PathVariable(value = "userId") String userId,
                                            @RequestParam(value = "startingDay") Long startingDay,
                                            @RequestParam(value = "endingDay") Long endingDay) {
        logger.info("Get workouts by timestamp for user id {} between {} and {}", userId, startingDay, endingDay);
        return workoutService.getWorkoutsByTimestamp(userId, startingDay, endingDay);
    }



}
