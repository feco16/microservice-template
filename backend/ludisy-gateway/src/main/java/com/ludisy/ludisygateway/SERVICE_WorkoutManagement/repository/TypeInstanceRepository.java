package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeArgument;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeInstanceRepository extends JpaRepository<TypeInstance, Long> {

    TypeInstance findByTypeArgument(TypeArgument typeArgument);
}
