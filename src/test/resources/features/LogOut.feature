@logout
Feature: testing the LogOut functionality

  Scenario: To Verify that the login page is displayed when logs out the application
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    And user clicks on second menuitem dropdown
    And user clicks on LogOut dropdown option
