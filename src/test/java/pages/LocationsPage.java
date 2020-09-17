package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LocationsPage extends BasePage{

    By regionUSBy = By.linkText("Americas");
    By countryDenBy = By.linkText("Denmark");
    By countryGerBy = By.linkText("Germany");
    By pTagLocationBy = By.tagName("p");
    By germanyIDBy = By.linkText("2700");
    By tdPostalCodeBy = By.xpath("//td[contains(text(),'80925')]");

    public LocationsPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
    }
    public void clickOnAmericasRegion(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(regionUSBy));
        theWebElement = theWebDriver.findElement(regionUSBy);
        theWebElement.click();
    }
    public void clickOnCountryDenmark(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryDenBy));
        theWebElement = theWebDriver.findElement(countryDenBy);
        theWebElement.click();
    }
    public String noLocationsMsg(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pTagLocationBy));
        return theWebDriver.findElement(pTagLocationBy).getText();
    }
    public void clickOnCountryGermany(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryGerBy));
        theWebElement = theWebDriver.findElement(countryGerBy);
        theWebElement.click();
    }
    public String chkPostalCode(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tdPostalCodeBy));
        theWebElement = theWebDriver.findElement(germanyIDBy);
        return theWebElement.findElement(tdPostalCodeBy).getText();

    }
}
