package com.bookit.utilities;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookItApiUtils {


    // static method 2 string aliyor ve return getiriyor
    public static String generateToken(String email, String password){
        Response response = given().queryParam("email", email)
                .and().queryParam("password", password)
                .when().get(ConfigurationReader.get("qa2api.uri") + "/sign");

        String token = response.path("accessToken");

        String finalToken = "Bearer "+ token; // Bearer basta + token
        System.out.println("finalToken = " + finalToken);

        return finalToken;
    }
}