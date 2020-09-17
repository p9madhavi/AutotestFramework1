@login
Feature: testing login functionality with Valid and Invalid Credentials and Footer Text

  Scenario:  To verify that the user logs in to autotools with valid credentials
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    Then a welcome page with "Welcome to Auto Tools" message should display

  Scenario:  To verify that the user not logs in to autotools with invalid credentials
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam" as password
    And user clicks Sign In button
    Then an error message "Your login attempt was not successful, please try again." should display

  Scenario: To verify that the footer text contains kubecloudsinc
    Given Go to Autotools login page
    When user enters "madhavi@kubecloudsinc.com" as username
    And user enters "sairam123" as password
    And user clicks Sign In button
    Then a welcome page with the footer text "© 2020 kubecloudsinc.com" should display