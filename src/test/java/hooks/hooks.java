package hooks;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static Utilities.constants.*;
import static io.restassured.RestAssured.given;


public class hooks extends Base {





    @Before
    @DataProvider(name = "getData")
    public Object[][] getData() throws Exception {
        Object testData[][] = DataDrivenTestData.getCellData();
//        System.out.println(DataDrivenTestData.getCellData());
        return (testData);

    }

    @BeforeClass
    public static void main(String[] args) throws Exception {
        DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelPath, sheetName);
        excelURLPayload.getCellData();


    }

}