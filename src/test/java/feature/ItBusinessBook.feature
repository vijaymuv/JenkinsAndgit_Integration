Feature: Verify and validate It Business Book Functionality

  Scenario Outline:: Register Functionality
    Given user navigates to the website
    When User clicks on Sign up and it switches to Sign up Options
    And user enters firstname "<Firstname>"
    And user enters lastname "<Lastname>"
    And user types Email into "<email>" text box
    And user types password "<Password>"
    And user clicks on Terms/Conditions checkbox.
    Then user clicks on getstarted button to register.

      Examples:
        |Firstname|Lastname|email|Password|
        |steve|rogers|steve@gmail.com|rogers@123|

  Scenario: Login Functionality
    Given user clicks on SignIn option
    When User enters email into Text Field
    And Then user enters password
    Then login must be successful.

  Scenario: Jobs Functionality
    When User click Jobs and moves to Find a job and click it
    And user enters job title into textbox.
    And user clicks on search button.

  Scenario: Logout Functionality
    When User clicks on profile
    And user moves the cursor to logout and clicks logout button
    Then user clicks ok to logout


