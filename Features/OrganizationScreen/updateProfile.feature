Feature: Verify update profile page

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Update user profile Information
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When update "<firstname>"
    Then Verify "<with update>"
    When click on update button without changing values
    Then Verify "<without update>"
    And close the application

    Examples: 
      | login success message   | firstname | with update                        | without update            |
      | Successfully logged in. | .         | User details updated successfully. | No changes has been made! |

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Enter the null values and verify the validation message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    And Verify "<firstname>" and "<lastname>" error message
    And close the application

    Examples: 
      | login success message   | firstname                    | lastname                    |
      | Successfully logged in. | Please enter your first name | Please enter your last name |

  @OrganizationScreen13 @ProfileScreen
  Scenario Outline: Delete profile photo
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When delete profile photo
    Then Verify "<delete message>"
    And close the application

    Examples: 
      | login success message   | delete message                       |
      | Successfully logged in. | Profile Picture deleted successfully |

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Upload profile picture and verify toast message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When upload profile ""
    Then Verify "<select file>"
    When upload profile "<picture>"
    Then Verify "<file uploaded>"
    And close the application

    Examples: 
      | login success message   | select file          | file uploaded                      | picture                                                                                  |
      | Successfully logged in. | Please select a File | Profile Picture added successfully | C:\\Users\\Soft Suave\\BustlespotAutomation2024\\Bustlespot\\resources\\profilePhoto.png |
