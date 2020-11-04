package com.ludisy.ludisygateway.UserManagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.TestUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationUserServiceTest {

    Logger logger = LoggerFactory.getLogger(ApplicationUserServiceTest.class);

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    WorkoutConverter workoutConverter;

    @Test
    public void testApplicationUser() {
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

    // TODO ! optimize hibernate relation to make the test work
    @Ignore
    @Test
    public void testGetUserWorkouts() throws JsonProcessingException {
        logger.info("testGetUserWorkouts started");

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(102);
        applicationUser.setUsername("Test username");
        applicationUser.setUserId(userId);

        String biking1 = TestUtils.readJson("biking1.json");

        ObjectMapper objectMapper = new ObjectMapper();
        WorkoutDTO workoutDTO = objectMapper.readValue(biking1, WorkoutDTO.class);

        applicationUser.setWorkouts(Collections.singletonList(workoutConverter.convert(workoutDTO, applicationUser)));

        applicationUserRepository.save(applicationUser);

        ApplicationUser createdApplicationUser = applicationUserService.getById(userId);

        assertEquals(applicationUser.getWorkouts().get(0).getDataInstances().size(),
                createdApplicationUser.getWorkouts().get(0).getDataInstances().size());
    }

    // TODO
    @Ignore
    @Test
    public void testDeleteWorkoutsByUserId() {

    }

}
