package ChatServer;

import POJO.chatserver.CreateUserChatServerPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin/";
    }



    @Test
    public void fetAllUsers1()
    {

        CreateUserChatServerPOJO ob = new CreateUserChatServerPOJO();
        ob.setUsername("muskan");
        ob.setPassword("m12345");
        ob.setEmail("muskan@gmail.com");
        ob.setName("Muskan");
        ob.setSurname("xyz");
        ob.setChat_nickname("mu1234");
        int[] dept = {1,2};
        ob.setDepartments(dept);

        int[] dept_read = {2};
        ob.setDepartments_read(dept_read);

        int[] groups = {1};
        ob.setDepartment_groups(groups);
        ob.setUser_groups(groups);

        given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                 .body(ob)
                .when().post("/restapi/user")
                .then().log()
                .all().assertThat().statusCode(200);

    }
}
