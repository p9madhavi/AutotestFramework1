@DepartmentDetails
Feature: Testing DepartmentDetails

  Scenario: To Verify that the Departments count in Seattle Location
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    And user clicks on fourth menuitem RegionDetails
    And user clicks on the region name Americas
    And user clicks on the country name United States of America
    And user clicks on the Seattle location ID
    Then a table with 21 Departments should display
