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
    When a valid user enters his username and password
    And user clicks Sign In button
    Then a welcome page with the footer text "© 2020 kubecloudsinc.com" should display

  Scenario:  To verify that the user logs in to autotools with valid credentials
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    Then a welcome page with "Welcome to Auto Tools" message should display

  Scenario:  To verify that the user not logs in to autotools with invalid credentials
    Given Go to Autotools login page
    When a invalid user enters his username and password
    And user clicks Sign In button
    Then an error message "Your login attempt was not successful, please try again." should display


  Scenario: To verify that the application doesn't remember the user when remember me check box is unchecked
    Given Go to Autotools login page
    When a invalid user enters his username and password
    And user clicks Sign In button
    And a welcome page with "Welcome to Auto Tools" message should display
    And user clicks on second menuitem dropdown
    And user clicks on MyProfile dropdown option
    And close the browser
    And user enters the UserForm url
    Then a login page with the text "Login to Auto Tools" message should display

