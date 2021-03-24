@CountryDetails
Feature: Testing CountryDetails

  Scenario: To Verify that the countries count in the Country Details Table.
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    And user clicks on fourth menuitem RegionDetails
    And user clicks on the region name Europe
    Then a table with 8 countries should display