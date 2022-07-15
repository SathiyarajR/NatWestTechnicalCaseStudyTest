package hooks;

import Utilities.Base;
import Utilities.DataDrivenTestData;
import org.junit.Before;
import org.testng.annotations.DataProvider;


import static Utilities.constants.*;


public class hooks extends Base {



    public void InitExcel()
    {
        DataDrivenTestData excelURLPayload = new DataDrivenTestData(excelPath, sheetName);

    }


@Before
@DataProvider(name = "getData")
    public Object[][] getData() throws Exception{
        Object testData[][] = DataDrivenTestData.getCellData();
        System.out.println(DataDrivenTestData.getCellData());
        return testData;

    }

}
