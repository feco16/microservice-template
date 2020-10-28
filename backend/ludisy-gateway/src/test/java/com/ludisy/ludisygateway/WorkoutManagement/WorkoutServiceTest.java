package com.ludisy.ludisygateway.WorkoutManagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutDTOConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import com.ludisy.ludisygateway.TestUtils;
import com.ludisy.ludisygateway.builder.WorkoutDTOBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

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
    WorkoutDTOConverter workoutDTOConverter;

    @Test
    public void testCreateWorkoutWithoutSnapshots() {
        String workoutId = UUID.randomUUID().toString();

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        WorkoutDTO workoutDTO = createWorkout(workoutId, null);
        workoutService.createWorkout(workoutDTO, userId);

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getUuid());
        assertNotNull(createdWorkout);

    }

    @Test
    public void testCreateWorkoutWithBikingSnapshots() {
        String workoutId = UUID.randomUUID().toString();

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(1);
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        WorkoutDTO workoutDTO = createWorkout(workoutId, TestUtils.createTestJson());
        workoutService.createWorkout(workoutDTO, userId);

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getUuid());
        assertNotNull(createdWorkout);

        WorkoutDTO createdWorkoutDTO = workoutDTOConverter.convert(createdWorkout);
        assertNotNull(createdWorkoutDTO);
        assertNotNull(createdWorkoutDTO.getData());
        assertEquals(5, ((JSONObject) ((JSONArray) createdWorkoutDTO.getData().get("snapShots")).
                get(0)).size());
        assertEquals(5, ((JSONObject) ((JSONArray) createdWorkoutDTO.getData().get("snapShots")).
                get(1)).size());
    }

    // TODO resolve cal double - int problem
    @Test
    public void testBikingWorkout1() {

        String biking1 = TestUtils.readJson("biking1.json");
        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(1);
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WorkoutDTO workoutDTO = objectMapper.readValue(biking1, WorkoutDTO.class);
            workoutService.createWorkout(workoutDTO, userId);

            Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getUuid());
            assertNotNull(createdWorkout);

            WorkoutDTO createdWorkoutDTO = workoutDTOConverter.convert(createdWorkout);

            String createdWorkoutJson = objectMapper.writeValueAsString(createdWorkoutDTO);

            char[] initArray = biking1.toCharArray();
            Arrays.sort(initArray);

            char[] createdArray = createdWorkoutJson.toCharArray();
            Arrays.sort(createdArray);

            assertEquals(new String(initArray), new String(createdArray));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    // TODO Test realworkouts.json
    @Test
    public void testRealJson() {
        TestUtils.readJson("realworkouts.json");
    }

    private WorkoutDTO createWorkout(String workoutId, JSONObject testJson) {

        return new WorkoutDTOBuilder().uuid(UUID.randomUUID().toString())
                .duration(10).type(1).data(testJson).build();
    }

}
