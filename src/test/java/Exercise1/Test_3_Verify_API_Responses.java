package Exercise1;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.testng.annotations.Test;

import static Utilities.constants.*;
import static io.restassured.RestAssured.*;

public class Test_3_Verify_API_Responses extends Base {




    @Test
    void testResponseCode200() {
        given()
                .get("https://swapi.dev/api/planets/34/")
                .then().statusCode(RESPONSE_CODE_200);

    }

    @Test
    void testResponseCode404() {
        given()
                .get("https://swapi.dev/api/planets/1/1")
                .then().statusCode(RESPONSE_CODE_404);

    }

    
    @Test
    void testResponseCode400() {
        given()
                .get("https://swapi.dev/api/planets/3/")
                .then().statusCode(RESPONSE_CODE_400);

    }

    @Test(dataProvider = "getUrlData")
    void testParameterization(String url)
    {
        given().pathParam("URL",url)
                .get("https://swapi.dev/api/{URL}/")
                .then().statusCode(RESPONSE_CODE_200);

    }




}
