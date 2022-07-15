package Exercise1;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Utilities.constants.excelPath;
import static Utilities.constants.sheetName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Test_2_Verify_Attributes extends Base {

    //Test to validate the count from response
    @Test
    void GetCountOfStarWarsCharacters() {
        given()
                .get("https://swapi.dev/api/people/")
                .then().assertThat().body("count", equalTo(82));
    }

    //Test to validate a specific character name from response
    @Test
    void ValidateSpecificStarWarsCharacterNames() {
        given()
                .get("https://swapi.dev/api/people/")
                .then().assertThat().body("results.name", hasItems("Biggs Darklighter", "Biggs Darklighter"));
    }

    //Test to validate and display the names from response
    @Test
    void DisplayAllStarWarsCharacterNames() {
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



