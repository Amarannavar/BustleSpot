Feature: Verify Tasks screen

  @TasksScreen
  Scenario Outline: Create new tasks if currect organization should have projects.
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And create new "<task>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                    | title | organization | task     |
      | Successfully logged in. | Task has been created sucessfully. | Tasks | SoftSuave    | New task |

  @TasksScreen
  Scenario Outline: Edit the task and validate task name textbox.
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And edit the "<task>" and verify "<validation>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message                    | title | organization | task     | validation            |
      | Successfully logged in. | This task was successfully edited. | Tasks | SoftSuave    | New task | Task Name is required |

  @TasksScreen
  Scenario Outline: Delete the task.
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And delete the "<task>"
    Then Verify "<success message>"
    And close the application

    Examples: 
      | login success message   | success message               | title | organization | task     |
      | Successfully logged in. | Task was successfully deleted | Tasks | SoftSuave    | New task |
