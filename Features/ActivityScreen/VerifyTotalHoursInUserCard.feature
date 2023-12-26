Feature: Verifying activity page

  @ActivityScreen
  Scenario Outline: Verifying user card total hours and after click on view screenshot total hours
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And click on "<user>" screenshot
    Then Verify the total hours in the user card
    And close the application

    Examples: 
      | login success message   | title    | organization | user                    |
      | Successfully logged in. | Activity | SoftSuave    | Shashidhar. Amarannavar |
