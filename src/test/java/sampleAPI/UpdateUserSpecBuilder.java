package sampleAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserSpecBuilder {

    @Test
    public void updateUser()
    {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        RequestSpecification request = given().log().all().spec(reqSpec)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}");

        Response response = request.when().put("/api/users/2");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String respStr = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println("respStr = "+respStr);
    }
}
