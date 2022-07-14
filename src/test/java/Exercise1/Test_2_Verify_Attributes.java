package Exercise1;

import Utilities.Base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_2_Verify_Attributes extends Base {


    @BeforeClass
    void getResponse() {
        request = RestAssured.given();
        response = get("https://swapi.dev/api/people/").getBody();
        System.out.print(response);
    }

    @Test
    void GetCountOfStarWarsCharacters() {
        given()
                .get("https://swapi.dev/api/people/")
                .then().assertThat().body("count", equalTo(82));
    }


    @Test
    void ValidateSpecificStarWarsCharacterNames() {
        given()
                .get("https://swapi.dev/api/people/")
                .then().assertThat().body("results.name", hasItems("Biggs Darklighter", "Biggs Darklighter"));
    }

    @Test()
    void DisplayAllStarWarsCharacterNames()
    {
                  ArrayList<String> names = given()
                    .pathParam("url", "people/")
                    .get("https://swapi.dev/api/{url}")
                    .then().extract().path("results.name");


            System.out.println("Names of StarWarCharacters" + names);
            for (String name : names) {
                System.out.println(name);
            }
        }



}




