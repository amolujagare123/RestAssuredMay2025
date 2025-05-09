package sampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.sample.CreateUserPayLoad.getCreateUserPayLoad;

public class CreateUserUsingPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(getCreateUserPayLoad("Dipti","Tester"))
                .when().post("/api/users")
                .then().log().all().statusCode(201);

    }
}
