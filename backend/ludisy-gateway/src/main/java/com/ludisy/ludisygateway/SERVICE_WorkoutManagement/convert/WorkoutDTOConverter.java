package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.Constants;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeArgument;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.TypeInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.TypeInstanceRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class WorkoutDTOConverter implements Converter<Workout, WorkoutDTO> {

    @Autowired
    private WorkoutDataDTOConverter workoutDataDTOConverter;

    @Autowired
    TypeInstanceRepository typeInstanceRepository;

    @Override
    public WorkoutDTO convert(Workout source) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(source.getUuid());
        workoutDTO.setDuration(source.getDuration());
        workoutDTO.setTimeStamp(source.getTimeStamp());
        workoutDTO.setCal(source.getCal());

        JSONObject jsonObject = new JSONObject();
        for (TypeArgument typeArgument : source.getWorkoutType().getTypeArguments()) {
            TypeInstance typeInstance = typeInstanceRepository.findByTypeArgument(typeArgument);
            jsonObject.put(typeArgument.getName(), typeInstance.getValue());
        }

        workoutDTO.setData(jsonObject.toJSONString());

        return workoutDTO;
    }
}
