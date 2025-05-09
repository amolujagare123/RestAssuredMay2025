package sampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .header("x-api-key", "reqres-free-v1")
                .when().put("/api/users/7")
                .then().log().all().statusCode(200);

    }
}
