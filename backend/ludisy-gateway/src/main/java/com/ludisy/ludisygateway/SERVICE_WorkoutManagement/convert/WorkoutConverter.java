package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.DataInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutType;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.DataInstanceRepository;
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
    DataInstanceRepository dataInstanceRepository;

    public Workout convert(WorkoutDTO source, ApplicationUser applicationUser) {
        Workout workout = new Workout();
        workout.setUuid(source.getId());
        workout.setDuration(source.getDuration());
        workout.setTimeStamp(source.getTimeStamp());
        workout.setCal(source.getCal());

        WorkoutType workoutType = workoutTypeRepository.findByTypeCode(source.getType());
        List<WorkoutData> workoutDataList = workoutType.getWorkoutData();

        // TODO optimise stack variables
        parse(workout, source.getData(), workoutDataList);

        workout.setWorkoutType(workoutType);
        applicationUser.addWorkout(workout);

        return workout;
    }

    private void parse(Workout workout, String json, List<WorkoutData> workoutDataList) {

        List<DataInstance> dataInstanceList = new ArrayList<>();
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(json);
            iterateNode(workout, rootNode, workoutDataList, dataInstanceList, -1);
        } catch (Exception e) {
            logger.error("An error occurred at workout converter!", e);
        }
        dataInstanceRepository.saveAll(dataInstanceList);

    }

    private void iterateNode(Workout workout, JsonNode jsonNode, List<WorkoutData> workoutDataList,
                             List<DataInstance> dataInstanceList, int listIndex) {
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = jsonNode.fields();
        while (fieldsIterator.hasNext()) {

            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());

            if (field.getValue().getNodeType().ordinal() == 0) {
                for (int index = 0; index < field.getValue().size(); index++) {
                    iterateNode(workout, field.getValue().get(index), workoutDataList, dataInstanceList, index);
                }
            } else {
                Optional<WorkoutData> typeArgument = retrieveArgument(field.getKey(), workoutDataList);
                if (typeArgument.isPresent()) {
                    DataInstance dataInstance = new DataInstance();
                    dataInstance.setValue(new Double(field.getValue().toString()));
                    dataInstance.setListIndex(listIndex);
                    dataInstance.setWorkoutData(typeArgument.get());
                    dataInstance.setWorkout(workout);
                    dataInstanceList.add(dataInstance);
                } else {
                    logger.debug("Workout with id {} doesn't have field {}", workout.getWorkoutId(),
                            field.getKey());
                }
            }
        }
    }

    private Optional<WorkoutData> retrieveArgument(String key, List<WorkoutData> workoutDataList) {
        return workoutDataList.stream()
                .filter(arg -> arg.getName().equals(key))
                .findFirst();
    }

}
