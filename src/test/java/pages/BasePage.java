package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.ApplicationProperties;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BasePage {

    WebDriver theWebDriver;
    WebElement theWebElement;
    FluentWait<WebDriver> wait;
    ApplicationProperties appProps = new ApplicationProperties();

    By buttonBy  = By.className("btn-primary");
    By pTagBy = By.tagName("p");
    By seconddropdownToggleBy = By.className("dropdown-toggle");
    By myProfileBy = By.linkText("My Profile");
    By logoutBy = By.linkText("Logout");
    By thirdDropDownBy = By.xpath("//a[contains(text(),'Employee Information')]");
    By empDetailsBy = By.linkText("All Employees Details");
    By empSearchBy = By.linkText("Employee Search");
    By regiondetailsBy = By.linkText("Region Details");

    TakesScreenshot takesScreenshot;
    private static final Random rnd = new Random();
    private static final int UPPER_BOUND = 10000000;

    public void closePage()
    {
        theWebDriver.close();
    }
    public void clickSecondMenuItem(){
        theWebElement = theWebDriver.findElement(seconddropdownToggleBy);
        theWebElement.click();
    }
    public void clickMyProfile(){
        theWebElement = theWebDriver.findElement(myProfileBy);
        theWebElement.click();
    }
    public void clickLogOut(){
        theWebElement = theWebDriver.findElement(logoutBy);
        theWebElement.click();
    }
    public void clickThirdMenuItem(){
        theWebElement = theWebDriver.findElement(thirdDropDownBy);
        theWebElement.click();
    }
    public void clickAllEmployeeDetails(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(empDetailsBy));
        theWebElement = theWebDriver.findElement(empDetailsBy);
        theWebElement.click();
    }
    public void clickEmployeeSearch(){
        wait = new FluentWait<>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(empSearchBy));
        theWebElement = theWebDriver.findElement(empSearchBy);
        theWebElement.click();
    }
    public void clickFourthMenuItem(){
        theWebElement =  theWebDriver.findElement(regiondetailsBy);
        theWebElement.click();
    }
    public void takeScreenShot(String page){

        takesScreenshot = (TakesScreenshot) theWebDriver;
        try {
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE)
                    ,new File("src/test/resources/screenshots/"+page+rnd.nextInt(UPPER_BOUND)+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
