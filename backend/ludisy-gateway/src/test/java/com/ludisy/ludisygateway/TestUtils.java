package com.ludisy.ludisygateway;

import java.util.Random;

public class TestUtils {

    private static Random random = new Random();

    public static int getRandomInt() {
        return random.nextInt() * 100;
    }

    public static double getRandomDouble() {
        return random.nextDouble() * 100;
    }

    public static String createTestJson() {
        String testJson = "{\n" +
                "\"distance\" : 5.036980927530882,\n" +
                "\"snapShots\" : [ {\n" +
                "\"altitude\" : 415.3999938964844,\n" +
                "\"latitude\" : 46.7582304,\n" +
                "\"longitude\" : 23.6175224,\n" +
                "\"speed\" : 0,\n" +
                "\"whenSec\" : 0\n" +
                "}, {\n" +
                "\"altitude\" : 359.3000183105469,\n" +
                "\"latitude\" : 46.7789396,\n" +
                "\"longitude\" : 23.7203228,\n" +
                "\"speed\" : 20.8153332,\n" +
                "\"whenSec\" : 1843\n" +
                "} ]\n" +
                "}";

        return testJson;
    }

}
