package HomeWork06;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.lessThan;

public class MiniMarketApiTest {

    private static final String BASE_URL = "https://minimarket1.herokuapp.com/market";
    private static final String FOOD_ID = "100";



    @BeforeAll
    static  void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }



     @Test
    void MiniMarketGetTest() {
        RestAssured.given()
                .get("/api/v1/products/" + FOOD_ID)
                .then()
                .statusCode(200)
                .time(lessThan(2500L))
                .log()
                .all()
        ;

    }

}
