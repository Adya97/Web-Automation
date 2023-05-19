package pageObject;

import ScreenManager.ScreenManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class Homepage extends ScreenManager{

    public WebDriver driver;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='navbar-collapse-header']/div/a[1]")
    public WebDriver loginOnHompage;
}
