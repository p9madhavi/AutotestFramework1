package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class EmployeeSearchPage extends BasePage{

    By srchfirstNameBy = By.xpath(" //input[@id='firstName']");
    By srchlastNameBy = By.xpath("//input[@id='lastName']");
    By srchButtonBy = By.xpath("//button[@class='btn btn-primary']");
    By srchErrorMsgBy = By.xpath(" //span[@id='firstName.errors']");


    public EmployeeSearchPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
//        wait = new FluentWait<>(theWebDriver);
//        wait.until(ExpectedConditions.presenceOfElementLocated(empSearchBy));
    }
    public void enterFirstName(String firstName){
        theWebElement = theWebDriver.findElement(srchfirstNameBy);
        theWebElement.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        theWebElement = theWebDriver.findElement(srchlastNameBy);
        theWebElement.sendKeys(lastName);
    }
    public void clickSearch(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(buttonBy));
        theWebElement = theWebDriver.findElement(buttonBy);
        theWebElement.click();
    }
    public String checkSearchErrorMsg(){
//        wait = new FluentWait<>(theWebDriver);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(srchErrorMsgBy));
        theWebElement =  theWebDriver.findElement(srchErrorMsgBy);
        return theWebElement.getText();
    }
}
