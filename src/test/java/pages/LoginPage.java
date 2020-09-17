package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage extends BasePage{

    By usernameBy = By.xpath("//input[@id='j_username']");
    By pwdBy = By.name("j_password");
    By strongBy = By.tagName("strong");

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeD\\chromedriver.exe");
        theWebDriver = new ChromeDriver();
        theWebDriver.get("http://23.120.24.187:10080/autotoolsv2");
    }
    public void enterUserName(String username){
        theWebElement = theWebDriver.findElement(usernameBy);
        theWebElement.sendKeys(username);
    }
    public void enterPwd(String pwd){
        theWebElement = theWebDriver.findElement(pwdBy);
        theWebElement.sendKeys(pwd);
    }
    public void clickSignIn(){
        theWebElement = theWebDriver.findElement(buttonBy);
        theWebElement.click();
    }
    public LoginPage(BasePage theCallingPage){
        theWebDriver = theCallingPage.theWebDriver;
        wait = new FluentWait<WebDriver>(theWebDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(strongBy));
    }
    public String getErrorMsg(){
        theWebElement = theWebDriver.findElement(strongBy);
        return theWebElement.getText();
    }
}
