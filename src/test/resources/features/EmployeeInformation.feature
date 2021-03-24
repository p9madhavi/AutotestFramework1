@EmployeeDetails
 Feature: Employee Details TestCases

  Scenario: To Verify that the total number of rows in employees table
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    And user clicks on third menuitem dropdown
    And user clicks on All Employees Details dropdown option
    Then a table with 107 employees should display


   Scenario: To Verify that the phone number of emp ID number 121
     Given Go to Autotools login page
     When a valid user enters his username and password
     And user clicks Sign In button
     And user clicks on third menuitem dropdown
     And user clicks on All Employees Details dropdown option
     Then checking the phone number of employee Id number 121 is "650.123.2234"





