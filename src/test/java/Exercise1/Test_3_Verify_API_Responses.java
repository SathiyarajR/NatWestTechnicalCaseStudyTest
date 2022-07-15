package Exercise1;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static Utilities.constants.*;
import static io.restassured.RestAssured.given;

public class Test_3_Verify_API_Responses extends Base {
    DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelPath, sheetName);





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


    @Test(dataProvider = "getURLInfo",dataProviderClass = DataDrivenTestData.class)
    void testResponseCode400(String URL, String uri) {
        given()
                .pathParam("URL",uri)
                .pathParam("URI",uri)
                .get("https://swapi.dev/api/{uri}/")
                .then().statusCode(RESPONSE_CODE_400);

    }


    @Test(dataProvider = "getURLInfo",dataProviderClass = DataDrivenTestData.class)
    public void testParameterization(String baseURI, String uri) {
        try {
            Map<String, Object > req= new HashMap<String, Object>();
            req.put("URL",baseURI);
            req.put("URI",uri);
            given().pathParams(baseURI,uri)
                    .get("{baseURI}/{URL}/")
                    .then().statusCode(RESPONSE_CODE_200);


        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}



