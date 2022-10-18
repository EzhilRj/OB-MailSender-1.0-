package Scripts;

import Basefunctions.Setup;
import Utils.DownloadUtils;
import Utils.EmailUtils;
import org.apache.commons.mail.EmailException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Arvind extends Setup {

    @Test
    public static void arvindlogin() throws IOException, EmailException, InterruptedException {

        FileInputStream File = new FileInputStream(excelpath);
        XSSFWorkbook workbook = new XSSFWorkbook(File);
        XSSFSheet sheet = workbook.getSheet("Arvind");
        int noforows = sheet.getLastRowNum();


        for (int row = 1; row <= noforows; row++) {

            XSSFRow currentrow = sheet.getRow(row);
            String username = currentrow.getCell(0).getStringCellValue();
            String password = currentrow.getCell(1).getStringCellValue();
            String company = currentrow.getCell(2).getStringCellValue();


            DownloadUtils.download(username, password, company);

             Setup.renamefile("Arvind-");

             String sendfilepath = String.valueOf(rename);

             EmailUtils.mailsender(sendfilepath,"ezhilraj@fieldlytics.in", "Arvind");


        }
    }

}
