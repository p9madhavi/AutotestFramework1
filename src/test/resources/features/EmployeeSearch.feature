@employeeSearch
  Feature: Employee Search Testcases FirstName LastName and FirstName Should not be null

    Scenario: To Verify that the Jennifer Whalen is there
      Given Go to Autotools login page
      When a valid user enters his username and password
      And user clicks Sign In button
      And user clicks on third menuitem dropdown
      And user clicks on Employee Search dropdown option
      And user enters "Jennifer" in the firstName field
      And user enters "Whalen" in the lastName field
      Then user clicks on the Search button
      And user closes the page


    Scenario: To Verify that the FirstName Should not be null
      Given Go to Autotools login page
      When a valid user enters his username and password
      And user clicks Sign In button
      And user clicks on third menuitem dropdown
      And user clicks on Employee Search dropdown option
      And user enters "Whalen" in the lastName field
      And user clicks on the Search button
      Then "First Name is required" message should display
      And user closes the page



