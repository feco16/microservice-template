package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutType;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutTypeArgument;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class WorkoutConverter {

    @Autowired
    WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    WorkoutDataConverter workoutDataConverter;

    // TODO populate database with fields from source.getData()
    public Workout convert(WorkoutDTO source, ApplicationUser applicationUser) {
        Workout workout = new Workout();
        workout.setUuid(source.getId());
        workout.setDuration(source.getDuration());
        workout.setTimeStamp(source.getTimeStamp());
        workout.setCal(source.getCal());
//        workout.setType(source.getType());

        WorkoutType workoutType = workoutTypeRepository.findByType(source.getType());

        List<WorkoutTypeArgument> workoutTypeArgumentList = new ArrayList<>();
        parse(source.getData());

        applicationUser.addWorkout(workout);

        return workout;
    }

    private void parse(String json) {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(json);
            Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
            while (fieldsIterator.hasNext()) {

                Map.Entry<String,JsonNode> field = fieldsIterator.next();
                System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
            }
        } catch (Exception e) {

        }

    }
}
