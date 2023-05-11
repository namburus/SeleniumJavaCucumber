Feature: feature to test login functionality

  Scenario: Validate the login functionality
    Given user in on the web site
    When the user enters the details
    And click login
    Then the user is logged in
