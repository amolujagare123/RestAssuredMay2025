package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class GetAllUsers {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin/";
    }



    @Test
    public void fetAllUsers1()
    {



        given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                // .body("")
                .when().get("/restapi/getusers")
                .then().log()
                .all().assertThat().statusCode(200);

    }
}
