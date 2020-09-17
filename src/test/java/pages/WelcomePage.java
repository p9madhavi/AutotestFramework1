package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WelcomePage extends BasePage{

    By footerBy = By.className("text-muted");

    public WelcomePage(BasePage theCallingPage) {

        theWebDriver = theCallingPage.theWebDriver;
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(pTagBy));
    }

    public String getWelcomeMsg(){
        theWebElement = theWebDriver.findElement(pTagBy);
        return theWebElement.getText();
    }
    public String getFooterMsg(){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(footerBy));
        theWebElement = theWebDriver.findElement(footerBy);
        return theWebElement.getText();
    }

}
