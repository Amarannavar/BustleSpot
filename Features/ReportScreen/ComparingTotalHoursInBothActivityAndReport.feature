Feature: Verifying Report page

  @ReportScreen
  Scenario Outline: Comparing both activity and report page total hours
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And click on "<user>" screenshot
    When select the "<title2>" in the leftside menubar
    Then select the "<user>" and compare both page total hours
    And close the application

    Examples: 
      | login success message   | title    | title2 | organization | user                   |
      | Successfully logged in. | Activity | Report | SoftSuave    | Shashidhar Amarannavar |
