package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class EmployeesPage extends BasePage {

        By trTagBy = By.tagName("tr");
        By tbodyTagBy = By.tagName("tbody");
        By empIdAdamBy = By.linkText("121");
        By tdempAdamPhoneNoBy = By.xpath("//td[contains(text(),'650.123.2234')]");

        public EmployeesPage(BasePage theCallingPage){
                theWebDriver = theCallingPage.theWebDriver;
                wait = new FluentWait<>(theWebDriver);
                wait.until(ExpectedConditions.presenceOfElementLocated(thirdDropDownBy));
        }
        public int checkEmpTotal(){
                wait = new FluentWait<>(theWebDriver);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trTagBy));
                theWebElement = theWebDriver.findElement(tbodyTagBy);
                return theWebElement.findElements(trTagBy).size();
        }
        public String  checkAdamPhoneNumber(){
                wait = new FluentWait<>(theWebDriver);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tdempAdamPhoneNoBy));
                theWebElement = theWebDriver.findElement(empIdAdamBy);
                return theWebElement.findElement(tdempAdamPhoneNoBy).getText();
        }

}
