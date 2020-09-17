package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CountriesPage extends BasePage {

    By regionEUBy = By.linkText("Europe");
    By trCountryTagBy = By.tagName("tr");
    By tbodyCountryTagBy = By.tagName("tbody");

    public CountriesPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
    }
    public void clickOnEuropeRegion(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(regionEUBy));
        theWebElement = theWebDriver.findElement(regionEUBy);
        theWebElement.click();
    }
    public int countriesTotal(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trCountryTagBy));
        theWebElement = theWebDriver.findElement(tbodyCountryTagBy);
        return theWebElement.findElements(trCountryTagBy).size();
    }
}
