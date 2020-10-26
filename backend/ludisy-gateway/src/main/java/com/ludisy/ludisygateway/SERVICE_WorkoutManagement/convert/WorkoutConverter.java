package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Snapshot;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutType;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeArgument;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.TypeInstanceRepository;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.WorkoutTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class WorkoutConverter {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutConverter.class);

    @Autowired
    WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    TypeInstanceRepository typeInstanceRepository;

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

        WorkoutType workoutType = workoutTypeRepository.findByTypeCode(source.getType());
        List<TypeArgument> typeArgumentList = workoutType.getTypeArguments();

        parse(workout.getWorkoutId(), source.getData(), typeArgumentList);

        workout.setWorkoutType(workoutType);

        applicationUser.addWorkout(workout);

        return workout;
    }

    // TODO handle Snapshots
    private void parse(long workoutId, String json, List<TypeArgument> typeArgumentList) {

        List<TypeInstance> typeInstanceList = new ArrayList<>();
        List<Snapshot> snapshotList = new ArrayList<>();
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(json);
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
            while (fieldsIterator.hasNext()) {

                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());

                if (field.getValue().getNodeType().ordinal() == 0) {
                    Snapshot snapshot = new Snapshot();


                } else {
                    Optional<TypeArgument> typeArgument = retrieveArgument(field.getKey(), typeArgumentList);
                    if (typeArgument.isPresent()) {
                        TypeInstance typeInstance = new TypeInstance();
                        typeInstance.setValue(field.getValue().toString());
                        typeInstance.setTypeArgument(typeArgument.get());
                        typeInstanceList.add(typeInstance);
                    }
                }

            }
        } catch (Exception e) {
            logger.error("An error occurred at workout converter!", e);
        }
        typeInstanceRepository.saveAll(typeInstanceList);

    }

    private Optional<TypeArgument> retrieveArgument(String key, List<TypeArgument> typeArgumentList) {
        return typeArgumentList.stream()
                .filter(arg -> arg.getName().equals(key))
                .findFirst();
    }

}
