package com.techcenture.academy;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello Java!");
        System.out.println(RestAssured.get("https://simple-tool-rental-api.glitch.me").body().asString());
        Response response = RestAssured.get("https://simple-tool-rental-api.glitch.me/tools/4643");
        System.out.println("==== Body===");
        System.out.println(response.body().asString());
        System.out.println("==== Status Code ===");
        System.out.println(response.statusCode());
        System.out.println("==== Headers ===");
        System.out.println(response.headers());
        System.out.println("====JSON Category ===");
        System.out.println(response.body().jsonPath().getString("category"));
      //  Assert.assertEquals(200, response.statusCode());
        System.out.println("====JSON PRICE ===");
        System.out.println(response.jsonPath().getString("price"));

    }

}
