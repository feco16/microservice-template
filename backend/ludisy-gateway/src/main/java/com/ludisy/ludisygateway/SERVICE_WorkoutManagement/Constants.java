package com.ludisy.ludisygateway.SERVICE_WorkoutManagement;

import java.util.Arrays;

public class Constants {

    public enum WORKOUT_TYPE {

        STAIRING("0"),
        BIKING("1"),
        ROLLER_SKATING("2"),
        RUNNING("3");

        private String value;

        WORKOUT_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static WORKOUT_TYPE getByName(String type) {
            return Arrays.stream(WORKOUT_TYPE.values())
                    .filter(t -> t.getValue().equalsIgnoreCase(type))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "WORKOUT_TYPE{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
