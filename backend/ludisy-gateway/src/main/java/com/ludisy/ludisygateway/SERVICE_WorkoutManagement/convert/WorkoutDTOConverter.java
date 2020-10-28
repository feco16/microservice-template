package com.ludisy.ludisygateway.SERVICE_WorkoutManagement.convert;

import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.dto.WorkoutDTO;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.WorkoutData;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.DataInstance;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.model.Workout;
import com.ludisy.ludisygateway.SERVICE_WorkoutManagement.repository.DataInstanceRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WorkoutDTOConverter implements Converter<Workout, WorkoutDTO> {

    @Autowired
    DataInstanceRepository dataInstanceRepository;

    @Override
    public WorkoutDTO convert(Workout source) {

        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setUuid(source.getUuid());
        workoutDTO.setDuration(source.getDuration());
        workoutDTO.setTimeStamp(source.getTimeStamp());
        workoutDTO.setCal(source.getCal());
        workoutDTO.setType(source.getWorkoutType().getTypeCode());

        List<DataInstance> dataInstanceList = dataInstanceRepository.findByWorkout(source);
        workoutDTO.setData(populateData(dataInstanceList));

        return workoutDTO;
    }

    private JSONObject populateData(List<DataInstance> dataInstanceList) {
        int listIndex = 0;
        boolean onlyDirect = true;

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectIndirect = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (DataInstance dataInstance : dataInstanceList) {
            if (null != dataInstance) {
                if (dataInstance.getListIndex() == -1) {
                    jsonObject.put(dataInstance.getWorkoutData().getName(), calculateType(dataInstance.getValue()));
                } else {
                    onlyDirect = false;
                    if (dataInstance.getListIndex() == listIndex) {
                        jsonObjectIndirect.put(dataInstance.getWorkoutData().getName(), calculateType(dataInstance.getValue()));
                    } else {
                        jsonArray.add(jsonObjectIndirect);
                        jsonObjectIndirect = new JSONObject();
                        jsonObjectIndirect.put(dataInstance.getWorkoutData().getName(), calculateType(dataInstance.getValue()));
                        listIndex++;
                    }
                }
            }
        }
        if (!onlyDirect) {
            jsonArray.add(jsonObjectIndirect);
            jsonObject.put("snapShots", jsonArray);
        }
        return jsonObject;
    }

    private Object calculateType(String value) {
        try {
            int intValue =  Integer.parseInt(value);
            return intValue;
        } catch (NumberFormatException e) {
            try {
                double doubleValue = Double.parseDouble(value);
                return doubleValue;
            } catch (NumberFormatException e1) {
                return value;
            }
        }
    }
}
