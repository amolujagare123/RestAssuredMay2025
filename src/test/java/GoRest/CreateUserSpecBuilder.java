package GoRest;

import POJO.GoREST.User;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUserSpecBuilder {



    String name = "kirti";
    String email = "kirti@gmail.com";
    String gender = "female";
    String status = "active";


    @Test
    public void createUser()
    {


        RestAssured.baseURI = "https://gorest.co.in";

        // Setup OAuth2Scheme
        OAuth2Scheme authScheme = new OAuth2Scheme();
        authScheme.setAccessToken("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd");

        // Build RequestSpecification with Auth Scheme
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")

                // .setAuth(authScheme)
                .setContentType(ContentType.JSON)
                .build();

        String requestBody = "{\n" +
                "                    \"name\": \"Dipti\",\n" +
                "                    \"email\": \"dipti3@gmail.test\",\n" +
                "                    \"gender\": \"female\",\n" +
                "                    \"status\": \"active\"\n" +
                "                }";



        Response response = given().log().all().spec(reqSpec)
                .body(requestBody)
                .when().post("/public/v2/users");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();

        String respStr = response.then().log().all().spec(respSpec).extract().asString();
        System.out.println("respStr=" + respStr);


     /*   User responseObj = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body("{\n" +
                        "        \"name\": \"Dipti\",\n" +
                        "        \"email\": \"dipti3@gmail.test\",\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"status\": \"active\"\n" +
                        "    }")
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201).extract().as(User.class);*/



    }

}
