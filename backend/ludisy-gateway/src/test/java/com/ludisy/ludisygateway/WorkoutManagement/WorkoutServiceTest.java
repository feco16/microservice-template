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
import com.ludisy.ludisygateway.TestConstants;
import com.ludisy.ludisygateway.TestUtils;
import com.ludisy.ludisygateway.builder.WorkoutDTOBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

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
    public void testCreateWorkoutWithBikingSnapshots() throws JsonProcessingException {
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
        assertTrue(compareWorkouts(workoutDTO, createdWorkoutDTO));
    }

    // TODO resolve cal double - int problem
    @Test
    public void testBikingWorkout1() throws JsonProcessingException {

        String biking1 = TestUtils.readJson("biking1.json");
        String userId = createUser();

        ObjectMapper objectMapper = new ObjectMapper();
        WorkoutDTO workoutDTO = objectMapper.readValue(biking1, WorkoutDTO.class);
        workoutService.createWorkout(workoutDTO, userId);

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getUuid());
        assertNotNull(createdWorkout);

        WorkoutDTO createdWorkoutDTO = workoutDTOConverter.convert(createdWorkout);

        assertTrue(compareWorkouts(workoutDTO, createdWorkoutDTO));

    }

    // TODO Test realworkouts.json
    @Ignore
    @Test
    public void testRealJson() throws JsonProcessingException {
        String realkWorkouts = TestUtils.readJson("realworkouts.json");

        String userId = createUser();
        ObjectMapper objectMapper = new ObjectMapper();

        List<WorkoutDTO> workoutDTOList = Arrays.asList(new ObjectMapper().readValue(realkWorkouts, WorkoutDTO[].class));
        workoutDTOList.stream()
                .forEach(workoutDTO ->  workoutService.createWorkout(workoutDTO, userId));
    }

    private boolean compareWorkouts(WorkoutDTO inputDTO, WorkoutDTO outputDTO) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(inputDTO);
        String outputJSON = objectMapper.writeValueAsString(outputDTO);

        char[] inputArray = inputJSON.toCharArray();
        Arrays.sort(inputArray);

        char[] outputArray = outputJSON.toCharArray();
        Arrays.sort(outputArray);

        return new String(inputArray).equals(new String(outputArray));
    }

    private String createUser() {
        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(TestConstants.TEST_APPLICATION_USER_ID);
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);
        return userId;
    }

    private WorkoutDTO createWorkout(String workoutId, JSONObject testJson) {

        return new WorkoutDTOBuilder().uuid(UUID.randomUUID().toString())
                .duration(10).type(1).data(testJson).build();
    }

}
