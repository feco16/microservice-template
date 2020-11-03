package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository;

import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout findByUuid(String uuid);

    List<Workout> findByApplicationUser(ApplicationUser applicationUser);

}
