package TestCases;

import Base.base;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.Homepage;
import pageObject.LoginPage;

import java.io.IOException;
import java.util.logging.Logger;

public class LanuchPageTestCases extends base {

    public WebDriver driver;
    @BeforeMethod
    public void installDriver() throws IOException {
        driver = initalizeDriver();
        log.info("Driver is intialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to the URL");
    }
    @Test
    public void invokeLanuchPage(){
        extentReports.createTest("Launch of Amazon");
        log.info("Homepage is opened");
        Homepage h = new Homepage(driver);
        h.getLogin().click();
        extentReports.flush();
    }
    @AfterMethod
    public void killDriver(){
        driver.quit();
    }
}
