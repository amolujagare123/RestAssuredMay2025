package GoRest;

import POJO.GoREST.GoRestCreatePOJO;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUserPOJO {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }


    String name = "kirti";
    String email = "kirti2@gmail.com";
    String gender = "female";
    String status = "active";



    @Test
    public void fetAllUsers1()
    {

        GoRestCreatePOJO ob = new GoRestCreatePOJO();
        ob.setName(name);
        ob.setEmail(email);
        ob.setGender(gender);
        ob.setStatus(status);

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(ob)
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }
    @Test
    public void fetAllUsers2()
    {

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body("{\n" +
                        "        \"name\": \"Dipti\",\n" +
                        "        \"email\": \"dipti2@gmail.test\",\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"status\": \"active\"\n" +
                        "    }")
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }

}
