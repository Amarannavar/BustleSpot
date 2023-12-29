Feature: Verify invite member page

  @InviteMembersScreen
  Scenario Outline: Sent invitation to members and verify toast message
    Sent invitation to existing mailId and verify toast message

    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And invite user with "<emailId>" and "<role>"
    Then Verify "<invite success message>"
    And close the application

    Examples: 
      | login success message   | invite success message                                            | title          | organization | emailId       | role |
      | Successfully logged in. | Invitation Sent Successfully                                      | Invite Members | Real Testing | abc@gmail.com | User |
      | Successfully logged in. | Invitation is already sent to the User or user is already present | Invite Members | Real Testing | abc@gmail.com | User |

  @InviteMembersScreen
  Scenario Outline: Resend the invitation
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And resend the invitation "<emailId>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message              | title          | organization | emailId       |
      | Successfully logged in. | Invitation Sent Successfully | Invite Members | Real Testing | abc@gmail.com |

  @InviteMembersScreen
  Scenario Outline: Delete the invitation
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And Delete the invited "<emailId>"
    Then Verify "<delete message>"
    And close the application

    Examples: 
      | login success message   | delete message                  | title          | organization | emailId       |
      | Successfully logged in. | Invitation Deleted Successfully | Invite Members | Real Testing | abc@gmail.com |

  @InviteMembersScreen
  Scenario Outline: Sent invitation without mailId and verify toast message
    Sent invitation without mailId and role and verify toast message

    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And invite user with "<emailId>" and "<role>"
    Then Verify "<toast message>"
    And close the application

    Examples: 
      | login success message   | toast message             | title          | organization | role | emailId |
      | Successfully logged in. | Please enter a valid mail | Invite Members | Real Testing | User |         |
      | Successfully logged in. | Please enter a valid mail | Invite Members | Real Testing |      |         |

  @InviteMembersScreen
  Scenario Outline: Sent invitation without selecting the role
    Sent invitation with invalid emailId and verify toast message

    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And invite user with "<emailId>"
    Then Verify "<toast message>"
    And close the application

    Examples: 
      | login success message   | toast message                           | title          | organization | emailId         |
      | Successfully logged in. | Please select a role                    | Invite Members | Real Testing | abc@gmail.com   |
      | Successfully logged in. | Please enter all email address as valid | Invite Members | Real Testing | abc@gmail.com s |
