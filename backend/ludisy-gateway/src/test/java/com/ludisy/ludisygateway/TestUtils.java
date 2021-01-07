package com.ludisy.ludisygateway;

import com.ludisy.ludisygateway.shared.CustomBadRequestException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TestUtils {

    private static Random random = new Random();

    public static int getRandomInt() {
        return random.nextInt() * 100;
    }

    public static double getRandomDouble() {
        return random.nextDouble() * 100;
    }

    public static String readJson(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/test/resources/json/" + fileName));
            return obj.toString();
        } catch (IOException | ParseException e) {
            throw new CustomBadRequestException("Can't read json object!");
        }
    }

    public static JSONObject createTestJson() {
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

        JSONParser jsonParser = new JSONParser();
        try {
            return (JSONObject) jsonParser.parse(testJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

}
