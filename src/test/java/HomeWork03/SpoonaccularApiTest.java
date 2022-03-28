package HomeWork03;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.lessThan;

public class SpoonaccularApiTest {
    private static final String API_KEY = "4f8be7f04b4d4b2882145a0d65f832ba";
    private static final String BASE_URL = "https://api.spoonacular.com";
    private static final String RECIPE_ID = "68546";


    @BeforeAll
    static  void beforeAll() {
        RestAssured.baseURI = BASE_URL;
    }
    @Test
    void testGetSearchRecipes() {
          RestAssured.given()
                  .queryParams("apiKey", API_KEY)
                  .queryParam("query", "burger")
                  .log()
                  .uri()
                  .expect()
                  .log()
                  .body()
                  .statusCode(200)
                  .time(lessThan(1500L))
                  .body("results[9].id", Matchers.notNullValue())
                  .when()
                  .get("/recipes/complexSearch");

    }
    @Test
    void testGetSearchByIngredients() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("ingridients", "carrots,tomatoes")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .body("results[1].id", Matchers.notNullValue())
                .when()
                .get("/recipes/complexSearch");

    }
    @Test
    void testGetSearchByNutrients() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("minSugar", "0")
                .queryParam("maxSugar", "250")
                .queryParam("offset", "1")
                .queryParam("number", "2")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .body("results[1].id", Matchers.notNullValue())
                .when()
                .get("/recipes/complexSearch");
    }
    @Test
    void testGetRecipeInformation() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("includeNutrition", "suga")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .body("results[1].id", Matchers.notNullValue())
                .when()
                .get("/recipes/complexSearch");
    }
    @Test
    void testGetTasteById() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .get("/recipes/"+ RECIPE_ID + "/tasteWidget.json");
    }
    @Test
    void testPost1() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("query", "burger")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .post("/recipes/cuisine");

    }
    @Test
    void testPost2() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("title", "bamboo burger")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .body("confidence", Matchers.notNullValue())
                .when()
                .post("/recipes/cuisine");
    }
    @Test
    void testPost3() {  RestAssured.given()
            .queryParams("apiKey", API_KEY)
            .queryParam("ingredientList", "carrot, pasta, pork")
            .queryParam("title", "beaff")
            .queryParam("image", "https://spoonacular.com/recipeImages/157106-312x231.jpg")
            .queryParam("language", "en")
            .log()
            .uri()
            .expect()
            .log()
            .body()
            .statusCode(200)
            .time(lessThan(1500L))
            .when()
            .post("/recipes/cuisine");}
    @Test
    void testPost4() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("tiitle", "burger")
                .body("{ingredientList:carrot, pasta, pork}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .post("/recipes/cuisine");
    }
    @Test
    void testPost5() {  RestAssured.given()
            .queryParams("apiKey", API_KEY)
            .queryParam("query", "burger")
            .log()
            .uri()
            .expect()
            .log()
            .body()
            .statusCode(200)
            .time(lessThan(1500L))
            //  .body("results[9].id", Matchers.notNullValue())
            .when()
            .post("/recipes/cuisine");}
}
