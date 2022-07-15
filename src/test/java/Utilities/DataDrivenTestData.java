package Utilities;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static Utilities.constants.*;
import static io.restassured.RestAssured.given;


public class DataDrivenTestData extends Base {
    public  static String excelPath = "./DataDriven/TestData.xlsx";
    public  static String sheetName = "TestData";
    //Fetching read end point URLS and request body payload
    public DataDrivenTestData(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    // method to get rowcount
//    @DataProvider(name = "getCount")
//    public static int getRowCount() {
//        int rowcount = sheet.getPhysicalNumberOfRows();
//        return rowcount;
//
//    }
    @BeforeClass
    public static void main(String[] args) throws Exception {
        DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelPath, sheetName);
        excelURLPayload.getCellData();


    }

    @DataProvider(name = "getURLInfo")
    public static Object[][] getCellData() throws NullPointerException {
//        DataFormatter formatter = new DataFormatter();
        Object[][] value = new Object[0][];
        try {
            value = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    value[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                    System.out.println(value[i][j]);

                }

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return value;

    }

}

//    @DataProvider(name = "getURIInfo")
//    public static Object[][] getURL(String url) throws Exception {
////        DataFormatter formatter = new DataFormatter();
////        try {
//        Object uri = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()].toString();
//
//        while (uri [][] != null) {
//            return [];
//        }
//    }
//}









