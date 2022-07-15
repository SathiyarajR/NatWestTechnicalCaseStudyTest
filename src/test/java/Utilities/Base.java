package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Base {
    public static RequestSpecification request;
    public static ResponseBody response;
    public static Headers headers;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;



}