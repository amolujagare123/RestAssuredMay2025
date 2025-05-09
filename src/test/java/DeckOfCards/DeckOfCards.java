package DeckOfCards;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeckOfCards {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com/";

        given().log().all()
                .queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200);
    }
}
