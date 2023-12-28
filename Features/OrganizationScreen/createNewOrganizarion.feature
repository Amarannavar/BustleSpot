Feature: Verifying organization module

  @OrganizationScreen @regression
  Scenario Outline: Creating new organization and verify toast message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When create new organization "<organization name>","<description>" and "<file location>"
    And click on submit
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                             | organization name | description                       | file location                                                                       |
      | Successfully logged in. | Organsiation has been created successfully. | Softsuave org     | Verify to create new organization | C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\soft_suave_logo.jpg |
      | Successfully logged in. | Organization already present                | Softsuave org     | Verify to create new organization | C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\soft_suave_logo.jpg |
      | Successfully logged in. | Please Upload Your Organization Logo!       | Softsuave org     | Verify to create new organization |                                                                                     |

  @OrganizationScreen @regression
  Scenario Outline: Entering null values and verify validation message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When create new organization "","" and ""
    And click on submit
    Then Verify "<organization>" and "<description>" validation message
    And close the application

    Examples: 
      | login success message   | organization                        | description                                   |
      | Successfully logged in. | Please enter your organization name | Please enter Description of your organization |

  @OrganizationScreen
  Scenario Outline: Edit the existing organization name
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    And edit the organization "<old name>","<new name>" and "<description>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                   | old name      | new name          | description          |
      | Successfully logged in. | Organisation updated successfully | Softsuave org | Softsuave new org | Changing description |

  @OrganizationScreen @regression
  Scenario Outline: Switching one organization to other
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to second organization
    And close the application

    Examples: 
      | login success message   |
      | Successfully logged in. |

  @OrganizationScreen @regression
  Scenario Outline: Delete the organization and verify toast message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    And delete organization "<name>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                   | name              |
      | Successfully logged in. | Organisation Deleted Successfully | Softsuave new org |
