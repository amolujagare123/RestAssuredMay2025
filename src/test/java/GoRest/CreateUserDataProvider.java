package GoRest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUserDataProvider {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }


   /* String name = "kirti";
    String email = "kirti@gmail.com";
    String gender = "female";
    String status = "active";*/

    @Test (dataProvider = "getData")
    public void fetAllUsers1(String name,String email,String gender,String status)
    {

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(getCreateUserPayLoad(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data = new Object[5][4];

        data[0][0] = "Kirti";
        data[0][1] = "kirti" + System.currentTimeMillis() + "@gmail.com";
        data[0][2] = "female";
        data[0][3] = "active";

        data[1][0] = "Rahul";
        data[1][1] = "rahul" + System.currentTimeMillis() + "@gmail.com";
        data[1][2] = "male";
        data[1][3] = "active";

        data[2][0] = "Anjali";
        data[2][1] = "anjali" + System.currentTimeMillis() + "@gmail.com";
        data[2][2] = "female";
        data[2][3] = "inactive";

        data[3][0] = "Amit";
        data[3][1] = "amit" + System.currentTimeMillis() + "@gmail.com";
        data[3][2] = "male";
        data[3][3] = "active";

        data[4][0] = "Sneha";
        data[4][1] = "sneha" + System.currentTimeMillis() + "@gmail.com";
        data[4][2] = "female";
        data[4][3] = "active";

        return data;
    }

}
