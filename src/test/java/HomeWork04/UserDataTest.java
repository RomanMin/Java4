package HomeWork04;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;

public class UserDataTest {

    @Test

    public void getUserDataTest() throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader("src/main/resources/userData.json"));
        JSONObject jo = (JSONObject) obj;
        String username = (String) jo.get("username");
        String spoonacularPassword = (String) jo.get("spoonacularPassword");
        String hash = (String) jo.get("hash");

        System.out.println(username + "\n" + spoonacularPassword  + "\n" +  hash);

    }
}
