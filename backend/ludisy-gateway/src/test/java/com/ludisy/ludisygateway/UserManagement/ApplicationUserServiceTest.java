package com.ludisy.ludisygateway.UserManagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.LudisyGatewayApplication;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.TestUtils;
import com.ludisy.ludisygateway.builder.ApplicationUserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LudisyGatewayApplication.class)
@ActiveProfiles("test")
public class ApplicationUserServiceTest {

    Logger logger = LoggerFactory.getLogger(ApplicationUserServiceTest.class);

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    WorkoutConverter workoutConverter;

    @Test
    public void testGetById() {
        logger.error("testApplicationUser started");

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(101);
        applicationUser.setUsername("Test username");
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        ApplicationUser createdApplicationUser = applicationUserService.getById(userId);
        assertNotNull(createdApplicationUser);
        assertEquals(applicationUser.getUsername(), createdApplicationUser.getUsername());

    }

    @Test
    public void testGetWorkouts() throws JsonProcessingException {
        logger.info("testGetUserWorkouts started");

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUserBuilder().applicationUserId(102).userId(userId)
                .username("Test username").build();

        String biking1 = TestUtils.readJson("biking2.json");

        ObjectMapper objectMapper = new ObjectMapper();
        WorkoutDTO workoutDTO = objectMapper.readValue(biking1, WorkoutDTO.class);

        applicationUser.setWorkouts(Collections.singletonList(workoutConverter.convert(workoutDTO, applicationUser)));

        applicationUserRepository.save(applicationUser);

        ApplicationUser createdApplicationUser = applicationUserService.getById(userId);

        assertEquals(1, createdApplicationUser.getWorkouts().size());
    }

    @Test
    public void testDeleteWorkoutsByUserId() throws JsonProcessingException {
        logger.info("testDeleteWorkoutsByUserId started");

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUserBuilder().applicationUserId(102).userId(userId)
                .username("Test username").build();

        String biking1 = TestUtils.readJson("biking2.json");

        ObjectMapper objectMapper = new ObjectMapper();
        WorkoutDTO workoutDTO = objectMapper.readValue(biking1, WorkoutDTO.class);

        applicationUser.setWorkouts(Collections.singletonList(workoutConverter.convert(workoutDTO, applicationUser)));

        applicationUserRepository.save(applicationUser);

        applicationUserService.deleteWorkoutsByUserId(applicationUser.getUserId());

        ApplicationUser createdApplicationUser = applicationUserService.getById(userId);

        assertEquals(0, createdApplicationUser.getWorkouts().size());
    }

}
