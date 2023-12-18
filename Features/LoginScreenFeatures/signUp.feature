Feature: Verify the signUp page.

  @loginScreen @SignUp
  Scenario Outline: Create account and verify the popup
    Given I launch the browser and hit the URL
    When user in lagin page and click on signUp
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>",
    Then Verify "<popup message>" contains
    And close the application

    Examples: 
      | emailId       | firstName | lastName | password   | confirmPassword | popup message                                               |
      | abc@gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User has been created successfully.Please verify the email. |
      | abc@gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User already exists please sign in.                         |
