package HomeWork04;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserCreationTest {

        private static final String API_KEY = "8776802a60d84a7b8630baf7fe1f3198";
        private static final String BASE_URL = "https://api.spoonacular.com";
        private static final String USER_NAME = "RomanMinaev";
        ResponseSpecification responseSpecification = null;
        RequestSpecification requestSpecification = null;

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = BASE_URL;
    }

    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .expectHeader("Access-Control-Allow-Origin", "*")
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .setBody("{ \"username\":" + USER_NAME + ", }")
                .build();
    }

    @Test
    void testPostUser() {
        RestAssured.given()
                .spec(requestSpecification)
                .expect()
                .when()
                .post("/users/connect")
                .then()
                .spec(responseSpecification);
    }
}
