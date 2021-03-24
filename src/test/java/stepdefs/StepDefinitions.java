package stepdefs;

import domain.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import pages.*;
import utils.TestDataProvider;

import java.awt.font.ShapeGraphicAttribute;

public class StepDefinitions {

    private static final Logger LOG = Logger.getLogger(StepDefinitions.class);

    LoginPage theLoginPage;
    WelcomePage theWelcomePage;
    UserFormPage theUserFormPage;
    LogOutPage theLogOutPage;
    EmployeesPage theEmployeesPage;
    EmployeeSearchPage theEmployeeSearchPage;
    RegionsPage theRegionsPage;
    CountriesPage theCountriesPage;
    LocationsPage theLocationsPage;
    DepartmentsPage theDepartmentsPage;
    BasePage theCurrentPage;
    User validUser;
    User inValidUser;

    TestDataProvider theTestDataProvider = new TestDataProvider();

//    ::::::::::  L O G I N ::::::::::
    @When("a valid user enters his username and password")
    public void validUserLogins(){

        validUser = theTestDataProvider.getValidUser();
        theLoginPage.enterUserName(validUser.getUserName());
        theLoginPage.enterPwd(validUser.getPwd());
    }
    @When("a invalid user enters his username and password")
    public void inValidUserLogins(){

        inValidUser = theTestDataProvider.getInValidUser();
        theLoginPage.enterUserName(inValidUser.getUserName());
        theLoginPage.enterPwd(inValidUser.getPwd());
    }

    @Given("Go to Autotools login page")
    public void goToLogin(){
        theLoginPage = new LoginPage();
        theCurrentPage = theLoginPage;
    }
//    @And ("close the browser")
//    public void

    @And("user enters {string} as username")
    public void enterUserName(String username){
       theLoginPage.enterUserName(username);
    }
    @And("user enters {string} as password")
    public void enterPwd(String pwd){
        theLoginPage.enterPwd(pwd);
    }
    @And("user clicks Sign In button")
    public void clickSignIn(){
        theLoginPage.clickSignIn();
    }
    @Then("a welcome page with {string} message should display")
    public void welcomeMsg(String welcomeMsg){
        theWelcomePage = new WelcomePage(theLoginPage);
        theWelcomePage.takeScreenShot("welcomePage");
        Assert.assertEquals(theWelcomePage.getWelcomeMsg(), welcomeMsg);
        theWelcomePage.closePage();
    }
    @Then("an error message {string} should display")
    public void checkError(String errorMsg){
        theLoginPage.takeScreenShot("loginPage");
        Assert.assertEquals(theLoginPage.getErrorMsg(),errorMsg);
        theLoginPage.closePage();
    }
    @Then("a welcome page with the footer text {string} should display")
    public void welcomePgFooter(String footerMsg){
        theWelcomePage = new WelcomePage(theLoginPage);
        theWelcomePage.takeScreenShot("welcomePage");
        Assert.assertTrue(theWelcomePage.getFooterMsg().contains("kubecloudsinc"));
        theWelcomePage.closePage();
    }

////    :::::::::::::::: U S E R    F O R M  :::::::::::::::::

    @And("user clicks on second menuitem dropdown")
    public void clickSecondMenuItemdropdown(){
        theWelcomePage = new WelcomePage(theLoginPage);
        theWelcomePage.clickSecondMenuItem();
        theCurrentPage = theWelcomePage;
    }
    @And("user clicks on MyProfile dropdown option")
    public void clickMyProfile(){

        theWelcomePage.clickMyProfile();
        theCurrentPage = theWelcomePage;
    }
    @And("user changes the firstname as {string}")
    public void changeFirstName(String changedFirstName){
        theUserFormPage = new UserFormPage(theWelcomePage);
        theUserFormPage.changeFirstName(changedFirstName);
        theCurrentPage=theUserFormPage;
    }
    @And("user clears the lastname")
    public void clearLastName(){
        theUserFormPage = new UserFormPage(theWelcomePage);
        theUserFormPage.clearLastName();
    }

    @And("user clicks on save button")
    public void clickSaveButton() {
        theUserFormPage.clickSaveButton();
    }
    @Then("a success message {string} should display")
     public void checkSuccessMsg(String successMsg){
        Assert.assertTrue(theUserFormPage.getSuccessMsg().contains("Success! Saved user."));
        theUserFormPage.closePage();
    }
    @Then("a formerror message {string} should display")
    public void checkFormErrorMessage(String formErrorMsg){
        Assert.assertEquals(theUserFormPage.getFormErrorMsg(),formErrorMsg);
    }
    @And("an error message {string} should be displayed next to LastName InputBox")
    public void checkInputBoxErrorMsg(String errorMsg){
        Assert.assertEquals(theUserFormPage.getInputBoxErrorMsg(),errorMsg);
        theUserFormPage.closePage();
    }
    @And("user clicks on LogOut dropdown option")
    public void clickLogout(){
        theLogOutPage = new LogOutPage(theWelcomePage);
        theLogOutPage.clickLogOut();
        theLogOutPage.closePage();
    }
//    :::::::::::::: E M P L O Y E E   I N F O :::::::::::::::::::::

    @And("user clicks on third menuitem dropdown")
    public void clickThirdMenuItemdropdown(){
        theWelcomePage = new WelcomePage(theLoginPage);
        theWelcomePage.clickThirdMenuItem();
    }
    @And("user clicks on All Employees Details dropdown option")
    public void clickEmpDetails(){
       theWelcomePage.clickAllEmployeeDetails();
    }

    @Then("a table with {int} employees should display")
    public void checkEmpTotal(int totalEmployees){
        theEmployeesPage = new EmployeesPage(theWelcomePage);
        Assert.assertEquals(theEmployeesPage.checkEmpTotal(),totalEmployees);
        theEmployeesPage.closePage();
    }
    @Then("checking the phone number of employee Id number 121 is {string}")
    public void chkAdamPhoneNumber(String phoneNumber){
        theEmployeesPage = new EmployeesPage(theWelcomePage);
        Assert.assertEquals(phoneNumber,theEmployeesPage.checkAdamPhoneNumber());
        theEmployeesPage.closePage();
    }

    @And("user clicks on Employee Search dropdown option")
    public void clickEmployeeSearch(){
        theWelcomePage.clickEmployeeSearch();
    }
    @And("user enters {string} in the firstName field")
    public void enterFirstName(String firstName){
        theEmployeeSearchPage = new EmployeeSearchPage(theWelcomePage);
        theEmployeeSearchPage.enterFirstName(firstName);
    }
    @And("user enters {string} in the lastName field")
    public void enterLastName(String lastName){
        theEmployeeSearchPage = new EmployeeSearchPage(theWelcomePage);
        theEmployeeSearchPage.enterLastName(lastName);
    }
    @Then("user clicks on the Search button")
    public void clickSearch(){
            theEmployeeSearchPage.clickSearch();
         theCurrentPage = theEmployeeSearchPage;
//         {**bcoz of this FirstName required error msg step failed**}
    }
    @And("user closes the page")
    public void closePage(){
        theCurrentPage.closePage();
    }
    @Then("{string} message should display")
    public void chkSrchErrorMsg(String errorMessage){
       Assert.assertEquals(theEmployeeSearchPage.checkSearchErrorMsg(),errorMessage);
       theCurrentPage=theEmployeeSearchPage;

    }

//    :::::::::::::::::: R E G I O N S :::::::::::::::::::
    @And("user clicks on fourth menuitem RegionDetails")
    public void clickRegionDetails(){
            theWelcomePage = new WelcomePage(theLoginPage);
            theWelcomePage.clickFourthMenuItem();
    }
    @Then("a table with {int} regions should display")
    public void checkRegionsTotal(int totalregions){
        theRegionsPage = new RegionsPage(theWelcomePage);
        Assert.assertEquals(totalregions, theRegionsPage.checkRegionsTotal());
        theRegionsPage.closePage();
    }
    @And("user clicks on the region name Europe")
    public void clickOnEuropeRegion(){
        theCountriesPage = new CountriesPage(theWelcomePage);
        theCountriesPage.clickOnEuropeRegion();
    }
    @Then("a table with {int} countries should display")
    public void countriesTotal(int countriesTotal){
        theCountriesPage = new CountriesPage(theWelcomePage);
        Assert.assertEquals(theCountriesPage.countriesTotal() ,countriesTotal);
        theCountriesPage.closePage();
    }
    @And("user clicks on the region name Americas")
    public void clickOnAmericasRegion(){
        theLocationsPage = new LocationsPage(theWelcomePage);
        theLocationsPage.clickOnAmericasRegion();
    }
    @And("user clicks on the country name United States of America")
    public void clickOnUSACountry(){
        theDepartmentsPage = new DepartmentsPage(theWelcomePage);
        theDepartmentsPage.clickOnUSACountry();
    }
    @And("user clicks on the Seattle location ID")
    public void clickOnSeattleID(){
        theDepartmentsPage = new DepartmentsPage(theWelcomePage);
        theDepartmentsPage.clickOnSeattleID();
    }
    @Then("a table with {int} Departments should display")
    public void seattleDepartmentsTotal(int departmentTotal){
        theDepartmentsPage = new DepartmentsPage(theWelcomePage);
        Assert.assertEquals(theDepartmentsPage.seattleDepartmentsTotal(),departmentTotal);
        theDepartmentsPage.closePage();
    }
    @And("user clicks on the country name Denmark")
    public void clickOnCountryDenmark(){
        theLocationsPage = new LocationsPage(theWelcomePage);
        theLocationsPage.clickOnCountryDenmark();
    }
    @Then("the locations page with {string} message should display")
    public void noLocationsMsg(String locationMsg){
        theLocationsPage = new LocationsPage(theWelcomePage);
        Assert.assertEquals(theLocationsPage.noLocationsMsg(),locationMsg);
        theLocationsPage.closePage();

    }
    @And("user clicks on the country name Germany")
    public void clickOnCountryGermany(){
        theLocationsPage = new LocationsPage(theWelcomePage);
        theLocationsPage.clickOnCountryGermany();
    }
    @Then("checking the postal code {string} for the Germany location ID 2700")
    public void chkPostalCode(String postalCode){
        theLocationsPage = new LocationsPage(theWelcomePage);
        Assert.assertEquals(theLocationsPage.chkPostalCode(),postalCode);
        theLocationsPage.closePage();
    }
}


