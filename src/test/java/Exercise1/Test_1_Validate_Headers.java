package Exercise1;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utilities.constants.excelPath;
import static Utilities.constants.sheetName;
import static io.restassured.RestAssured.*;

public class Test_1_Validate_Headers extends Base {

    //test to validate content type header is application/json
    @Test(dataProvider = "getURLInfo", dataProviderClass = DataDrivenTestData.class)
    void VerifyContentTypeIsApplicationJSON(String baseURI, String basePath, String contentType, String invalidURI, String invalidURL) {
        String response = given()
                .headers("Content-Type", contentType)
                .baseUri(baseURI)
                .basePath(basePath)
                .get()
                .then().assertThat().extract().contentType().toString();
        Assert.assertEquals(response, contentType);
    }

    //test to validate content type is Present in header
    @Test(dataProvider = "getURLInfo", dataProviderClass = DataDrivenTestData.class)
    void VerifyContentTypeIsPresent(String baseURI, String basePath, String contentType, String invalidURI, String invalidURL) {
        given()
                .baseUri(baseURI)
                .basePath(basePath)
                .get()
                .then().extract().header("Content-Type");
    }

    //test to validate display all the headers

    @Test(dataProvider = "getURLInfo", dataProviderClass = DataDrivenTestData.class)
    void TestToDisplayHeaders(String baseURI, String basePath, String contentType, String invalidURI, String invalidURL) {
        given()
                .baseUri(baseURI)
                .basePath(basePath)
                .get()
                .then().extract().headers();
    }

}
