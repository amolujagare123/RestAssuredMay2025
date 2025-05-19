package sampleAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static payload.sample.CreateUserPayLoad.getCreateUserPayLoad;

public class CreateUserUsingPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String respStr = given().log().all()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(getCreateUserPayLoad("Dipti", "Tester"))
                .when().post("/api/users")
                .then().log().all().statusCode(201).extract().asString();

        System.out.println("respStr="+respStr);

        JsonPath jsonPath = new JsonPath(respStr);

        String name = jsonPath.get("name");
        String job = jsonPath.get("job");
        String id = jsonPath.get("id");
        String createdAt = jsonPath.get("createdAt");

        System.out.println("name="+name);
        System.out.println("job="+job);
        System.out.println("id="+id);
        System.out.println("createdAt="+createdAt);
    }
}
