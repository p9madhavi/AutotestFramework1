package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DepartmentsPage extends BasePage {

    By countryUSABy = By.linkText("United States of America");
    By seattleIDBy = By.linkText("1700");
    By trDepartmentTagBy = By.tagName("tr");
    By tbodyDepartmentTagBy = By.tagName("tbody");


    public DepartmentsPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
    }
    public void clickOnUSACountry(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryUSABy));
        theWebElement = theWebDriver.findElement(countryUSABy);
        theWebElement.click();
    }
    public void clickOnSeattleID(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(seattleIDBy));
        theWebElement = theWebDriver.findElement(seattleIDBy);
        theWebElement.click();
    }
    public int seattleDepartmentsTotal(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trDepartmentTagBy));
        theWebElement = theWebDriver.findElement(tbodyDepartmentTagBy);
        return theWebElement.findElements(trDepartmentTagBy).size();
    }
}
