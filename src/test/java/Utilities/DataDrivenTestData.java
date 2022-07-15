package Utilities;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class DataDrivenTestData extends Base {

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
    @DataProvider(name = "getCount")
    public int getRowCount() {
        int rowcount = sheet.getPhysicalNumberOfRows();
        return rowcount;

    }


    @DataProvider(name = "getURLInfo")
    public static Object[][] getCellData() throws Exception {
//        DataFormatter formatter = new DataFormatter();

        Object[][] value = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                value[i][j] = sheet.getRow(i + 1).getCell(j).toString();
//                System.out.println(value[i][j]);

            }
        }
        return value;

    }
}









