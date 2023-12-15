Feature: Login to the application

  @ValidateLoginMessage
  Scenario Outline: Verify the login page popup messages.
    Given user is in login page and enter the "<email>" and "<password>"
    Then Verify "<login success message>"
    And close the application

    Examples: 
      | email                                 | password    | login success message          |
      | shashidhar.amarannavar@softsuave.org  | Shashi#123  | Successfully logged in.        |
      | shashidhar.amarannavar@softsuave.org  | Shashi#1231 | Wrong password entered.        |
      | shashidhar.amarannavar1@softsuave.org | Shashi#123  | No user found. Please sign up. |
      | shashidhar.amarannavar1@softsuave.org | Shashi#1231 | No user found. Please sign up. |

  @validationEmailAndPassword
  Scenario Outline: Verify the email and password validation message.
    Given user enter the "<email>" and "<password>"
    Then Verify the email and password "<validation message>"
    And close the applications

    Examples: 
      | email                  | password  | validation message                 |
      | shashidhar.amarannavar |           | Please enter a valid email address |
      |                        | Shashi#12 | Please enter your password         |

  @LoginPage
  Scenario Outline: Verify the login page.
    Given user is in login page and enter the email and password
    Then Verify "<login success message>"

    Examples: 
      | login success message   |
      | Successfully logged in. |
