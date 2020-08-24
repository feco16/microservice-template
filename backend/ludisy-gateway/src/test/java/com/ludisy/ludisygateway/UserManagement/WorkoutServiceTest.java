package com.ludisy.ludisygateway.UserManagement;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import com.ludisy.ludisygateway.rest.GatewayController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutServiceTest {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    GatewayController gatewayController;

    @Test
    public void testCreateWorkout() {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(UUID.randomUUID().toString());
        workoutDTO.setDuration(123);

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        workoutService.createWorkout(workoutDTO, userId);

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getId());
        assertNotNull(createdWorkout);
    }

    @Test
    public void testCreateWorkoutFromJson() {
        String workoutJson = "";

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

    }

    @Test
    public void testController() {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(UUID.randomUUID().toString());
        workoutDTO.setDuration(123);

        gatewayController.postWorkout(workoutDTO);

    }
}
