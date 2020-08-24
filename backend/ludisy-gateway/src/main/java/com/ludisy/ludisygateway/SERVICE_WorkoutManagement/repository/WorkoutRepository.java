package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout findByUuid(String uuid);

}
