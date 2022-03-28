package HomeWork03;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.lessThan;

public class SpoonaccularApiTest {
    private static final String API_KEY = "4f8be7f04b4d4b2882145a0d65f832ba";
    private static final String BASE_URL = "https://api.spoonacular.com";
    private static final String RECIPE_ID = "68546";
    private static final String USER_NAME = "RomanMinaev3";
    private static final String START_DATE = "2022-04-03";
    private static final String USER_HASH = "30a48916222283f96c40243be61083adb89e56da";



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
                .queryParam("tiitle", "Tacos")
                .queryParam("ingredientList", "corn pancakes stuffed with meat, red, yellow and green chilis, with onion and tomato")
                .log()
                .all()
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
            .when()
            .post("/recipes/cuisine");}
/*
    @Test
    void testPostUser() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .body("{ \"username\":" + USER_NAME + ", }")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .post("/users/connect");
    }
*/
    @Test
    void testPostWeekPlan() {
        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("hash", USER_HASH)
                .body("{\n" +
                        "    \"date\": 1589500800,\n" +
                        "    \"slot\": 1,\n" +
                        "    \"position\": 0,\n" +
                        "    \"type\": \"INGREDIENTS\",\n" +
                        "    \"value\": {\n" +
                        "        \"ingredients\": [\n" +
                        "            {\n" +
                        "                \"name\": \"1 banana\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .post("/mealplanner/"+ USER_NAME + "/items");

    }
    @Test
    void testGetMealPlan(){

        RestAssured.given()
                .queryParams("apiKey", API_KEY)
                .queryParam("hash", USER_HASH)
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .statusCode(200)
                .time(lessThan(1500L))
                .when()
                .get("/mealplanner/"+ USER_NAME + "/week/2022-04-04/");

    }
}
