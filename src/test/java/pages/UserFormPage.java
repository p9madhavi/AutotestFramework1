package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class UserFormPage extends BasePage{

    By firstNameBy = By.id("user.firstName");
    By successMsgBy = By.xpath("//div[@class='alert alert-success']");
    By lastNameBy = By.name("user.lastName");
    By formErrorMsgBy  = By.xpath("//strong[contains(text(),'Form Errors')]");
    By lastNameErrorMsgBy = By.className("help-inline");

    public UserFormPage(BasePage theCallingPage) {

        theWebDriver = theCallingPage.theWebDriver;
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonBy));
    }
    public void changeFirstName(String changedFirstName){
        theWebElement = theWebDriver.findElement(firstNameBy);
        theWebElement.clear();
        theWebElement.sendKeys(changedFirstName);
    }
    public void clickSaveButton(){
        theWebElement = theWebDriver.findElement(buttonBy);

        ((JavascriptExecutor) theWebDriver).executeScript("arguments[0].scrollIntoView();", theWebElement);
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonBy));
        theWebElement.click();
    }
    public String getSuccessMsg(){
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(successMsgBy));
        theWebElement = theWebDriver.findElement(successMsgBy);
        return theWebElement.getText();
    }
    public void clearLastName(){
        theWebElement = theWebDriver.findElement(lastNameBy);
        theWebElement.clear();
    }
    public String getFormErrorMsg(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(formErrorMsgBy));
        theWebElement = theWebDriver.findElement(formErrorMsgBy);
        return theWebElement.getText();
    }
    public String getInputBoxErrorMsg(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(lastNameErrorMsgBy));
        theWebElement = theWebDriver.findElement(lastNameErrorMsgBy);
        return theWebElement.getText();
    }


}
