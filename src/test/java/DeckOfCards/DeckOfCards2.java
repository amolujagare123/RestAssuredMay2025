package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DeckOfCards2 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com/";

        String resp = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200)
                .extract().asString();

        System.out.println("resp="+resp);

        JsonPath jPath = new JsonPath(resp);

        String deckId = jPath.get("deck_id");

        System.out.println("deckID="+deckId);


        given().log().all()
                .queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().statusCode(200);

    }
}
