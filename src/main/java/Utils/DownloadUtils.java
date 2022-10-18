package Utils;

import Pageobjects.objects;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static Basefunctions.Setup.driver;

public class DownloadUtils {

    public static void download(String un , String pw , String comp) throws InterruptedException {

        PageFactory.initElements(driver,objects.class);

        objects.username.sendKeys(un);
        objects.password.sendKeys(pw);
        objects.company.sendKeys(comp);
        objects.submit.click();
        objects.clickReports.click();
        objects.clickpendingreport.click();
        objects.export.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(objects.logout0).build().perform();
        objects.logout1.click();


    }




    }




