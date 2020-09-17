package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LogOutPage extends BasePage {


    public LogOutPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutBy));
    }
}
