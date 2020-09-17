@employeeSearch
  Feature: Employee Search Testcases FirstName LastName and FirstName Should not be null

    Scenario: To Verify that the Jennifer Whalen is there
      Given Go to Autotools login page
      When user enters "madhavi@kubecloudsinc.com" as username
      And user enters "sairam123" as password
      And user clicks Sign In button
      And user clicks on third menuitem dropdown
      And user clicks on Employee Search dropdown option
      And user enters "Jennifer" in the firstName field
      And user enters "Whalen" in the lastName field
      Then user clicks on the Search button


    Scenario: To Verify that the FirstName Should not be null
      Given Go to Autotools login page
      When user enters "madhavi@kubecloudsinc.com" as username
      And user enters "sairam123" as password
      And user clicks Sign In button
      And user clicks on third menuitem dropdown
      And user clicks on Employee Search dropdown option
      And user enters "Whalen" in the lastName field
      And user clicks on the Search button
      Then "First Name is required" message should display



