@UserForm
#  @wip
Feature: testing UserForm Options FirstName And LastName

  Scenario: To Verify that the FirstName Change in the UserForm
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    And user clicks on second menuitem dropdown
    And user clicks on MyProfile dropdown option
    And user changes the firstname as "Madhavi123"
    And user clicks on save button
    Then a success message "Success! Saved user." should display

  Scenario: To Verify that the LastName Change in the UserForm
    Given Go to Autotools login page
    When a valid user enters his username and password
    And user clicks Sign In button
    And user clicks on second menuitem dropdown
    And user clicks on MyProfile dropdown option
    And user clears the lastname
    And user clicks on save button
    Then a formerror message "Form Errors" should display
    And an error message "Last Name is required" should be displayed next to LastName InputBox

