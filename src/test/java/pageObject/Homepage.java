package pageObject;

import ScreenManager.ScreenManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class Homepage{

    public WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver=driver;
    }

    By loginButton= By.xpath("//*[@id='nav-link-accountList-nav-line-1']");
   // @FindBy(xpath = "//*[@id='navbar-collapse-header']/div/a[1]")
    //public WebDriver loginOnHompage;

    public WebElement getLogin(){
        return driver.findElement(loginButton);
    }
}
