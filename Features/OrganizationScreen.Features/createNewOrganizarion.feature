Feature: Verifying organization module

  @OrganizationScreen @regression
  Scenario Outline: Creating new organization and verify the popup message
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When create new organization "<organization name>","<description>" and "<file location>"
    And click on submit
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                             | organization name | description                       | file location                                                                    |
      | Successfully logged in. | Organsiation has been created successfully. | Softsuave org     | Verify to create new organization | C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\profilePhoto.png |
      | Successfully logged in. | Organization already present                | Softsuave org     | Verify to create new organization | C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\profilePhoto.png |

  @OrganizationScreen @regression
  Scenario Outline: Creating new organization and entering null values
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When create new organization "","" and "<file location>"
    And click on submit
    Then Verify "<organization>" and "<description>" validation message
    And close the application

    Examples: 
      | login success message   | organization                        | description                                   | file location                                                                    |
      | Successfully logged in. | Please enter your organization name | Please enter Description of your organization | C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\profilePhoto.png |

  @OrganizationScreen @regression
  Scenario Outline: Delete the organization
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    And delete organization "<name>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                   | name          |
      | Successfully logged in. | Organisation Deleted Successfully | Softsuave org |
