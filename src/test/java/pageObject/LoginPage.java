package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    By userName= By.name("email");

    public WebElement getUserName(){
        return driver.findElement(userName);
    }
}
