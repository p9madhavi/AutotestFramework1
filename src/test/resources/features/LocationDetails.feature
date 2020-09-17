@LocationDetails
Feature: Testing LocationDetails

  Scenario: To Verify that the denmark has "No Locations"
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    And user clicks on fourth menuitem RegionDetails
    And user clicks on the region name Europe
    And user clicks on the country name Denmark
    Then the locations page with "No Locations" message should display

  Scenario: To Verify that the postal code of germany country's Location ID 2700
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    And user clicks on fourth menuitem RegionDetails
    And user clicks on the region name Europe
    And user clicks on the country name Germany
    Then checking the postal code "80925" for the Germany location ID 2700
