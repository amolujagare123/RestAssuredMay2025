package sampleAPI;

import POJO.sampleUserPOJO.SampleUserPojo;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        SampleUserPojo sampleUserPojo = new SampleUserPojo();
        sampleUserPojo.setName("pooja");
        sampleUserPojo.setJob("HR");

        given().log().all()
                .header("Content-Type","application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(sampleUserPojo)
                .when().post("/api/users")
                .then().log().all().statusCode(201);

    }
}
