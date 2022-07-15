package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static Utilities.constants.excelPath;
import static Utilities.constants.sheetName;

public class Base {
    public static RequestSpecification request;
    public static ResponseBody response;
    public static Headers headers;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelPath, sheetName);

    public void setup() {
        // Setting BaseURI once
        RestAssured.baseURI = "https://swapi.dev/api/";

    }
}