@RegionDetails
Feature: Testing RegionDetails

  Scenario: To Verify that the regions count in the Region Details Table.
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    And user clicks on fourth menuitem RegionDetails
    Then a table with 4 regions should display

