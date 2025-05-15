package GoRest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUserWithJSON {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }


    String name = "kirti";
    String email = "kirti@gmail.com";
    String gender = "female";
    String status = "active";

    @Test
    public void fetAllUsers1() throws IOException {


        Path myPath = Paths.get("json/createUserGOREST.json");

        byte[] allBytes = Files.readAllBytes(myPath);

        String jsonFile = new String(allBytes);

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(jsonFile)
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }


}
