package com.ludisy.ludisygateway.UserManagement;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testApplicationUser() {
        logger.error("testApplicationUser started");

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setApplicationUserId(123);
        applicationUser.setUsername("Test username");
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        ApplicationUser createdApplicationUser = applicationUserService.getById(userId);
        assertNotNull(createdApplicationUser);
        assertEquals(applicationUser.getUsername(), createdApplicationUser.getUsername());

    }

}
