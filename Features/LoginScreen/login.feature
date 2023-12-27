Feature: Login to the application

  @loginScreen @ValidateLoginSuccessMessage
  Scenario Outline: Verify the login page toast message
    Given I launch the browser and hit the URL
    When user is in login page and enter the "<email>" and "<password>"
    Then Verify "<login success message>"
    And close the application

    Examples: 
      | email                                 | password    | login success message          |
      | shashidhar.amarannavar@softsuave.org  | Shashi#123  | Successfully logged in.        |
      | shashidhar.amarannavar@softsuave.org  | Shashi#1231 | Wrong password entered.        |
      | shashidhar.amarannavar1@softsuave.org | Shashi#123  | No user found. Please sign up. |
      | shashidhar.amarannavar1@softsuave.org | Shashi#1231 | No user found. Please sign up. |

  @loginScreen @validationEmailAndPassword
  Scenario Outline: Verify the email and password textbox validation message.
    Given I launch the browser and hit the URL
    When user enter the "<email>" and "<password>"
    Then Verify the email and password "<validation message>"
    And close the application

    Examples: 
      | email                  | password  | validation message                 |
      | shashidhar.amarannavar |           | Please enter a valid email address |
      |                        | Shashi#12 | Please enter your password         |
      |                        |           | Please enter your email            |

  @RegressionTest
  Scenario Outline: Login to the home page.
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"

    Examples: 
      | login success message   |
      | Successfully logged in. |
