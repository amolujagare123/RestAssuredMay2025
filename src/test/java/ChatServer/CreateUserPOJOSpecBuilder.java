package ChatServer;

import POJO.chatserver.UserDetails;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUserPOJOSpecBuilder {




    @Test
    public void fetAllUsers1()
    {

        UserDetails ob = new UserDetails();
        ob.setUsername("muskan111");
        ob.setPassword("m12345");
        ob.setEmail("muskan2@gmail.com");
        ob.setName("Muskan");
        ob.setSurname("xyz");
        ob.setChat_nickname("mu1234");
       // int[] dept = {1,2};

        ArrayList<Integer> dept = new ArrayList<>();
        dept.add(1);
        dept.add(2);
        ob.setDepartments(dept);

       // int[] dept_read = {2};
        ArrayList<Integer> dept_read = new ArrayList<>();
        dept_read.add(2);
        ob.setDepartments_read(dept_read);

        //int[] groups = {1};
        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1);
        ob.setDepartment_groups(groups);
        ob.setUser_groups(groups);

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("demo");

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://demo.livehelperchat.com/site_admin/")
                .addHeader("Content-Type", "application/json")
                .setAuth(auth).build();

        RequestSpecification request = given().log().all().spec(reqSpec).body(ob);

        Response response = request.when().post("/restapi/user");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String respStr = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println("respStr="+respStr);







       /* given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                 .body(ob)
                .when().post("/restapi/user")
                .then().log()
                .all().assertThat().statusCode(200);*/

    }
}
