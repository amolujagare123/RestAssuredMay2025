package sampleAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static payload.sample.CreateUserPayLoad.getCreateUserPayLoad;

public class CreateUserSpecBuilder {

    public static void main(String[] args) {

      //  RestAssured.baseURI = "https://reqres.in/";


        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec)
                .body(getCreateUserPayLoad("Dipti", "Tester"));

        Response response = request.when().post("/api/users");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();

        String respStr =  response.then().log().all().spec(respSpec)
                .body("name", equalTo("Dipti"))
                .time(lessThan(600l))
                .extract().asString();



        /*String respStr = given().log().all()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(getCreateUserPayLoad("Dipti", "Tester"))
                .when().post("/api/users")
                .then().log().all().statusCode(201).extract().asString();*/
















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
