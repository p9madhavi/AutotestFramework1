package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class RegionsPage extends BasePage{

    By trRegionTagBy = By.tagName("tr");
    By tbodyRegionTagBy = By.tagName("tbody");

    public RegionsPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(regiondetailsBy));
    }
    public int checkRegionsTotal(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trRegionTagBy));
        theWebElement = theWebDriver.findElement(tbodyRegionTagBy);
        return theWebElement.findElements(trRegionTagBy).size();

    }


}
