package Exercise1;

import Utilities.Base;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test_1_Validate_Headers extends Base {


    @BeforeClass
    void getResponse() {
         request = RestAssured.given();
         headers =get("https://swapi.dev/api/").getHeaders();
        System.out.print(headers);
    }


    //test to validate content type header is present
    @Test
    void VerifyContentTypeIsPresent() {

        given()
                .get("https://swapi.dev/api/")
                .then().header("Content-Type", "application/json");

    }
    //test to validate content type is application/json
    @Test
    void VerifyContentTypeIsJSON() {
        given()
                .get("https://swapi.dev/api/")
                .then()
                .assertThat().header("Content-Type", "application/json");

    }

}
