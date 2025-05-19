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


        String resp2 = given().log().all()
                .queryParam("count","4")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().statusCode(200).extract().asString();

        JsonPath jsonPath2 = new JsonPath(resp2);
        int size = jsonPath2.get("cards.size()");

        for(int i=0;i<size;i++) {
            String img1 = jsonPath2.getString("cards["+i+"].image");

            System.out.println("img1=" + img1);

        }

    }
}
