package Basefunctions;


import Utils.ReadUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Setup {

    public static WebDriver driver;
    protected static ChromeOptions options;
    long StartTime;
    long endTime;
    static String Baseurl = "http://hrms.ppms.co.in/";
    protected static String excelpath = "./src/main/resources/Datas/Credentials.xlsx";

   public static File rename;


    public static ReadUtils readUtils = new ReadUtils();

    static String Reportspath = System.getProperty("user.dir") + "\\Reports\\";


    @BeforeSuite
    public static void base() {

        HashMap preferences = new HashMap();
        preferences.put("download.default_directory", Reportspath);

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setExperimentalOption("prefs", preferences);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Baseurl);
        driver.manage().window().maximize();

    }

    @AfterSuite(enabled = true)
    public void closebrowser() throws InterruptedException {

        driver.quit();
        endTime = System.currentTimeMillis();
        long Totaltime = endTime - StartTime;
        System.out.println("TIMETAKEN:" + Totaltime);

    }


    public static String renamefile(String projname) throws IOException {

        File file = new File("./Reports/OnBoard_Employee_status.csv");
         rename = new File(System.getProperty("user.dir") +"/Reports/"+ projname + "-OnBoard_Employee_status"+Setup.Gettimestamp()+".csv");
        boolean flag = file.renameTo(rename);

        if (flag == true) {
            System.out.println();
        }
        return projname;
    }


    public static String Gettimestamp() throws IOException {

        String Datename = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


        return Datename;

    }



}
