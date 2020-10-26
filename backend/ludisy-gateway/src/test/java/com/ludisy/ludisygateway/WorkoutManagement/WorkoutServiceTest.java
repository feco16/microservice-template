package com.ludisy.ludisygateway.WorkoutManagement;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert.WorkoutDTOConverter;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.service.WorkoutService;
import com.ludisy.ludisygateway.TestUtils;
import com.ludisy.ludisygateway.builder.WorkoutDTOBuilder;
import com.ludisy.ludisygateway.builder.WorkoutDataDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getId());
        assertNotNull(createdWorkout);

    }

    @Test
    public void testCreateWorkoutWithBikingSnapshots() {
        String workoutId = UUID.randomUUID().toString();

        String userId = UUID.randomUUID().toString();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserId(userId);

        applicationUserRepository.save(applicationUser);

        List<Object> snapShots = TestUtils.createBikingSnapshots();
        WorkoutDTO workoutDTO = createWorkout(workoutId, snapShots);
        workoutService.createWorkout(workoutDTO, userId);

        Workout createdWorkout = workoutRepository.findByUuid(workoutDTO.getId());
        assertNotNull(createdWorkout);

        WorkoutDTO createdWorkoutDTO = workoutDTOConverter.convert(createdWorkout);
//        assertNotNull(createdWorkoutDTO.getData().getSnapShots());
//        assertEquals(snapShots.size(), createdWorkoutDTO.getData().getSnapShots().size());
    }

    private WorkoutDTO createWorkout(String workoutId, List<Object> snapshots) {
        String testJson = "{\n" +
                "        \"distance\" : 5.036980927530882,\n" +
                "        \"snapShots\" : [ {\n" +
                "          \"altitude\" : 415.3999938964844,\n" +
                "          \"latitude\" : 46.7582304,\n" +
                "          \"longitude\" : 23.6175224,\n" +
                "          \"speed\" : 0,\n" +
                "          \"whenSec\" : 0\n" +
                "        } ]\n" +
                "}";

        return new WorkoutDTOBuilder().id(workoutId).duration(10).type(1).data(testJson).build();
    }

}
