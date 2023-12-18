Feature: Verifying forgot password in login screen

  @loginScreen
  Scenario Outline: verify the forgot password
    Given I launch the browser and hit the URL
    When user in login page and click forgot password and enter "<incorrect email>"
    Then Verify the email "<validation message>"
    And close the application

    Examples: 
      | incorrect email        | validation message                 |
      | shashidhar.amarannavar | Please enter a valid email address |

  @loginScreen
  Scenario Outline: verify the reset password error message
    Given I launch the browser and hit the URL
    When user in login page and click forgot password and enter "<unknown email>"
    When click on reset password
    Then Verify popup "<validation message>"
    And close the application

    Examples: 
      | unknown email           | validation message |
      | unknown.email@gmail.com | No User was found  |
