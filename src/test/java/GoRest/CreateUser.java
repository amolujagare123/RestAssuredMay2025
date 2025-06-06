package GoRest;

import POJO.GoREST.User;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUser {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }


    String name = "kirti";
    String email = "kirti@gmail.com";
    String gender = "female";
    String status = "active";

    @Test
    public void fetAllUsers1()
    {

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(getCreateUserPayLoad(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }
    @Test
    public void createUser()
    {

        User responseObj = given().log().all()
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
                .all().assertThat().statusCode(201).extract().as(User.class);

          int id =   responseObj.getId();
          String name = responseObj.getName();
          String email = responseObj.getEmail();
          String gender = responseObj.getGender();
          String status = responseObj.getStatus();

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("status = " + status);

    }

}
