package WFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;

    public WebDriver initalizeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\ViNUS\\IdeaProjects\\WebAutomationFramework\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println("chrome");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\ViNUS\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        long time = 2000;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        return driver;
    }
}
