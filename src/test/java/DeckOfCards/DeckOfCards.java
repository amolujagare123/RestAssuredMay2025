package DeckOfCards;

import POJO.DeckOfCards.ShuffleCardsResponse;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeckOfCards {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com/";

        ShuffleCardsResponse resp = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all()
                .statusCode(200)
                .extract().as(ShuffleCardsResponse.class);

        System.out.println("Success="+resp.isSuccess());
        System.out.println("Deck id="+resp.getDeck_id());
        System.out.println("Remaining="+resp.getRemaining());
        System.out.println("Shuffled="+resp.isShuffled());

    }
}
