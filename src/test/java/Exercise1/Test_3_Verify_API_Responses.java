package Exercise1;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static Utilities.constants.*;
import static io.restassured.RestAssured.given;

public class Test_3_Verify_API_Responses extends Base {

    //Test to validate API response is 200
    @Test(dataProvider = "getURLInfo",dataProviderClass = DataDrivenTestData.class)
    void testResponseCode200(String baseURI, String basePath, String contentType, String invalidURI, String invalidURL) {
        given()
                .headers("Content-Type",contentType)
                .baseUri(baseURI)
                .basePath(basePath)
                .get()
                .then().statusCode(RESPONSE_CODE_200);

    }
    //Test to validate API response is 200
    @Test(dataProvider = "getURLInfo",dataProviderClass = DataDrivenTestData.class)
    void testResponseCode404(String baseURI, String basePath, String contentType, String invalidURI, String invalidURL) {
        given()
                .headers("Content-Type",contentType)
                .baseUri(baseURI)
                .basePath(invalidURI)
                .get()
                .then().statusCode(RESPONSE_CODE_404);

    }

    //Test to validate API response is 400
    @Test(dataProvider = "getURLInfo",dataProviderClass = DataDrivenTestData.class)
    void testResponseCode400(String baseURI, String basePath, String contentType,String invalidURI, String invalidURL) {
        given()
                .headers("Content-Type",contentType)
                .baseUri(baseURI)
                .basePath(invalidURI)
                .get()
                .then().statusCode(RESPONSE_CODE_404);

    }

}
