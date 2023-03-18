package com.academy.techcenture;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;

public class BasicRestAssuredTest {
    @Test
    public void testStatus() {
        /**
         * *using Assertion **/
//        Response response = RestAssured.get("https://simple-tool-rental-api.glitch.me/status");
//        Assert.assertEquals(200, response.getStatusCode());
        /**
         * Using validatable response same results you can test the body , header
         * in this eg we tested  the status-Code */

      RestAssured.get("https://simple-tool-rental-api.glitch.me/status")
              .then().statusCode(200);
    }

    @Test
    public void testSingleTool() {
        /**
         * *using Assertion **/

//        Response response = RestAssured.get("https://simple-tool-rental-api.glitch.me/tools/4643");
//        Assert.assertEquals(200, response.getStatusCode());
        /**
         * Using validatable response same results you can test the body , header
         * in this eg we tested the body and the status-Code */

        RestAssured.get("https://simple-tool-rental-api.glitch.me/tools/4643")
                .then().statusCode(200).
                body("id", equalTo(4643)).
                body("category", equalTo("plumbing")).
                body("name", equalTo("PEX Clamp Tool")).
                body("manufacturer", equalTo("JWGJW")).
                body("price", equalTo( 3.45F)).
                body("current-stock", equalTo( 14)).
                body("inStock", equalTo( true)).
                header("Connection", "keep-alive");
    }
    @Test
    public void testOutStockTool() {
        /**
         * *using validatable response **/
       RestAssured.get("https://simple-tool-rental-api.glitch.me/tools/?available=false").
                then().statusCode(200).body("size()",greaterThan(0))
               .body("id",hasItems(6543,5851)).
                body("category",hasItems("electric-generators","power-tools")).
                body("name",hasItems("GENMAX 3200 Watt Inverter Generator","20V MAX Cordless Drill Combo Kit")).
                body("inStock",hasItems( false,false));

        System.out.println(RestAssured.get("https://simple-tool-rental-api.glitch.me/tools/?available=false").body().asString());

    }

}
