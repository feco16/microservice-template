package com.ludisy.ludisygateway;

import com.ludisy.ludisygateway.builder.BikingDTOBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {

    private static Random random = new Random();

    public static int getRandomInt() {
        return random.nextInt() * 100;
    }

    public static double getRandomDouble() {
        return random.nextDouble() * 100;
    }

    public static List<Object> createBikingSnapshots() {
        List<Object> snapShots = new ArrayList<>();

        snapShots.add(new BikingDTOBuilder().build());
        snapShots.add(new BikingDTOBuilder().build());
        return snapShots;
    }
}
