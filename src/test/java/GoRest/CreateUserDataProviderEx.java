package GoRest;

import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.GOREST.CreateUserPayload.getCreateUserPayLoad;

public class CreateUserDataProviderEx {

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }


   /* String name = "kirti";
    String email = "kirti@gmail.com";
    String gender = "female";
    String status = "active";*/

    @Test (dataProvider = "getData")
    public void fetAllUsers1(String name,String email,String gender,String status)
    {

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(getCreateUserPayLoad(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log()
                .all().assertThat().statusCode(201);

    }

    @DataProvider
    Object[][] getData() throws IOException {
        // 1. read the excel file
        FileInputStream fileInputStream = new FileInputStream("Data/UserDataSample.xlsx");

        // 2. store the file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 3. get the sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count rows and columns

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

       for (int i = 0; i < rowCount-1; i++) {

           XSSFRow row = sheet.getRow(i+1);

           for (int j=0;j<colCount;j++) {
               XSSFCell cell = row.getCell(j);

               if(cell==null)
                   data[i][j] = "";
               else {
                   cell.setCellType(CellType.STRING);
                   data[i][j] = cell.toString();
               }
           }

            /*data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
            data[i][3] = row.getCell(3).toString();*/
        }

      /*  data[0][0] = "Kirti";
        data[0][1] = "kirti" + System.currentTimeMillis() + "@gmail.com";
        data[0][2] = "female";
        data[0][3] = "active";

        data[1][0] = "Rahul";
        data[1][1] = "rahul" + System.currentTimeMillis() + "@gmail.com";
        data[1][2] = "male";
        data[1][3] = "active";

        data[2][0] = "Anjali";
        data[2][1] = "anjali" + System.currentTimeMillis() + "@gmail.com";
        data[2][2] = "female";
        data[2][3] = "inactive";

        data[3][0] = "Amit";
        data[3][1] = "amit" + System.currentTimeMillis() + "@gmail.com";
        data[3][2] = "male";
        data[3][3] = "active";

        data[4][0] = "Sneha";
        data[4][1] = "sneha" + System.currentTimeMillis() + "@gmail.com";
        data[4][2] = "female";
        data[4][3] = "active";*/

        return data;
    }

}
