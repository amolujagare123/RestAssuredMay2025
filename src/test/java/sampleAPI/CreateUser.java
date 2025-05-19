package sampleAPI;

import POJO.sampleUserPOJO.Employee;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        Employee responseObj = given().log().all()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().statusCode(201).extract().as(Employee.class);

        String name = responseObj.getName();
        String job = responseObj.getJob();
        String id = responseObj.getId();
        String createdAt = responseObj.getCreatedAt();

        System.out.println("name="+name);
        System.out.println("job="+job);
        System.out.println("id="+id);
        System.out.println("createdAt="+createdAt);

    }
}
