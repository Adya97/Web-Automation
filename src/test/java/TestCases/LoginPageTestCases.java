package TestCases;

import Base.base;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.Homepage;
import pageObject.LoginPage;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginPageTestCases extends base {
    public WebDriver driver;
    @BeforeMethod
    public void installDriver() throws IOException {
        driver = initalizeDriver();
        log.info("Driver is intialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to the URL");
    }
    @Test(dataProvider="getData")
    public void enterUserName(String Username){
        extentReports.createTest("Enter User Name");
        Homepage h = new Homepage(driver);
        h.getLogin().click();
        LoginPage l = new LoginPage(driver);
        l.getUserName().sendKeys(Username);
        log.info("Username successfully entered under username");
        extentReports.flush();
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][1];
        data[0][0] = "avnisal@gmail.com";
        data[1][0] = "abc@gmail.com";
        return data;
    }
    @AfterMethod
    public void killDriver(){
        driver.quit();
    }
}
