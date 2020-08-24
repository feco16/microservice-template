package com.ludisy.ludisygateway.SERVICE_WorkoutManagement;

import java.util.Arrays;

public class Constants {

    public enum WORKOUT_TYPE {

        STAIRING(0),
        BIKING(1),
        ROLLER_SKATING(2),
        RUNNING(3);

        private int value;

        WORKOUT_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static WORKOUT_TYPE getByValue(int value) {
            return Arrays.stream(WORKOUT_TYPE.values())
                    .filter(t -> t.getValue() ==value)
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
