package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutTypeRepository extends JpaRepository<WorkoutType, Long> {

    WorkoutType findByType(int type);

}
