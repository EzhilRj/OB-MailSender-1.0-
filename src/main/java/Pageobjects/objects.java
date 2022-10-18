package Pageobjects;

import Basefunctions.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class objects {

    @FindBy(id = "txtUsername")
    public static WebElement username;

    @FindBy(id = "txtPassword")
    public static WebElement password;

    @FindBy(id = "txtClient")
    public static WebElement company;

    @FindBy(id = "btnLogin")
    public static WebElement submit;

    @FindBy(xpath = "//*[text()='Reports']")
    public static WebElement clickReports;

    @FindBy(xpath = "//*[text()='Pending OnBoard Employee Report']")
    public static WebElement clickpendingreport;

    @FindBy(id = "ctl00_Content_btnExport")
    public static WebElement export;

    @FindBy(className = "welcomeUser")
    public static WebElement logout0;

    @FindBy(xpath = "//*[text()='Log out']")
    public static WebElement logout1;






}
