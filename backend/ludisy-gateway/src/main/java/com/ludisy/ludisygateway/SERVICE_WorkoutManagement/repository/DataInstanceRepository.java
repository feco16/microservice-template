package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.DataInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataInstanceRepository extends JpaRepository<DataInstance, Long> {

    DataInstance findByWorkoutData(WorkoutData workoutData);

    @Query("from DataInstance di " +
            "where di.workout = ?1 " +
            "group by di.dataInstanceId, di.listIndex")
    List<DataInstance> findByWorkout(Workout workout);

}
