package DeckOfCards;

import POJO.DeckOfCards.Cards;
import POJO.DeckOfCards.DrawCardsResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class DeckOfCardsDeserialization {

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


        DrawCardsResponse resp2 = given().log().all()
                .queryParam("count", "4")
                .when().get("/api/deck/" + deckId + "/draw/")
                .then().log().all().statusCode(200).extract().as(DrawCardsResponse.class);

    // print the link of 2 images (png)
        // also print svg

        ArrayList<Cards> cards = resp2.getCards();

        for(int i=0;i<cards.size();i++) {

          //  System.out.println(cards.get(i).getImage());
            System.out.println(cards.get(i).getImages().getSvg());
        }

    }
}
