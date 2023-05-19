package TestCases;

import Base.base;
import org.testng.annotations.*;
import pageObject.Homepage;
import pageObject.LoginPage;

import java.io.IOException;
import java.lang.Object;
import java.util.Properties;

public class LanuchPage extends base {

    @BeforeTest
    public void installDriver() throws IOException {
        driver = initalizeDriver();
        prop.getProperty(url);
    }

    public void invokationOfHomePage(String Username) throws IOException {
        Homepage h = new Homepage(driver);
        h.getLogin().click();
    }
    @AfterTest
    public void killDriver(){
        driver.quit();
    }
}
