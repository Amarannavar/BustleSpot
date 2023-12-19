Feature: Verify the signUp page.

  @loginScreen @SignUp
  Scenario Outline: Create account and verify the popup
    Given I launch the browser and hit the URL
    When user in lagin page and click on signUp
<<<<<<< Updated upstream
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>",
    Then Verify "<popup message>" contains
    And close the application

    Examples: 
      | emailId       | firstName | lastName | password   | confirmPassword | popup message                                               |
      | abc@gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User has been created successfully.Please verify the email. |
      | abc@gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User already exists please sign in.                         |
=======
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    And click on signUp button
    Then Verify popup "<created>"
    When navigate to login page
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    And click on signUp button
    Then Verify popup "<exists>"
    And close the application

    Examples: 
      | emailId    | firstName | lastName | password   | confirmPassword | created                                                     | exists                              |
      | @gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User has been created successfully.Please verify the email. | User already exists please sign in. |

  @loginScreen @SignUp
  Scenario Outline: Entering blank values to the textbox and verify error message
    Given I launch the browser and hit the URL
    When user in lagin page and click on signUp
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    Then enter blank values in all textbox and verify the error message
    And close the application

    Examples: 
      | emailId    | firstName         | lastName          | password   | confirmPassword |
      | abc@gmail. | sixteenCharrector | MaximumCharrector | Shashi#123 | Shashi#12       |

  @loginScreen @SignUp
  Scenario Outline: Entering invalid values to the textbox and verify error message
    Given I launch the browser and hit the URL
    When user in lagin page and click on signUp
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    Then enter invalid values in all textbox and verify the error message
    And close the application

    Examples: 
      | emailId    | firstName         | lastName          | password | confirmPassword |
      | abc@gmail. | sixteenCharrector | MaximumCharrector | Shashi   | Shashi#1234     |
>>>>>>> Stashed changes
