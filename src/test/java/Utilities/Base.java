package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.event.Level;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.logging.Logger;

public class Base {
    public static RequestSpecification request;
    public static ResponseBody response;
    public static Headers headers;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public static String excelpath = "./DataDriven/TestData.xlsx";
    public static String sheetname = "TestData";


    void setup() {
        RestAssured.baseURI = "https://swapi.dev/api/";
    }

//        public static void main(String[] args) {
//        DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelpath,sheetname);
//        System.out.println(excelURLPayload.getRowCount());
//        System.out.println(excelURLPayload.getCellData());
//    }


    @DataProvider(name = "getUrlData")
    public Object[][] getData() {
        Object testData[][] = DataDrivenTestData.getCellData();
        return testData;
    }
}


