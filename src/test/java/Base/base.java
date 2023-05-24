package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pageObject.Homepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

public class base {
    public WebDriver driver;
    //public static Homepage homepage;
    public Properties prop;
    public ExtentSparkReporter spark;
    public ExtentReports extentReports;
    public static final Logger log = Logger.getLogger(base.class.getName());

    public WebDriver initalizeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/adityanisal/IdeaProjects/Web-Automation/src/main/java/resources/data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/adityanisal/Downloads/chromedriver_mac64/chromedriver");
            driver = new ChromeDriver();
        }
        long time = 2000;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        return driver;
    }

    @BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "//reports//index.html";
        spark = new ExtentSparkReporter(path);
        spark.config().setReportName("Aditya Nisal - Web Automation Results");
        spark.config().setDocumentTitle("Test Automation Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Tester","Aditya Nisal");
    }
}
