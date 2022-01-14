Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters "<username>" into username input
    And User enters "<password>" into password input
    And User clicks on login button
    Then User can see Product Page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Login with valid credentials (Enter Button)
    Given User navigates to login page
    When User enters "<username>" into username input
    And User enters "<password>" into password input
    And User hits Enter Button on keyword
    Then User can see Product Page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Login with valid username and empty password
    Given User navigates to login page
    When User enters "<username>" into username input
    And User clicks on login button
    Then User can see warning message "Epic sadface: Password is required"

    Examples:
      | username                |
      | standard_user           |
      | locked_out_user         |
      | problem_user            |
      | performance_glitch_user |

  Scenario Outline: Login with empty username and valid password
    Given User navigates to login page
    When User enters "<password>" into password input
    And User clicks on login button
    Then User can see warning message "Epic sadface: Username is required"

    Examples:
      | password     |
      | secret_sauce |
      | secret_sauce |
      | secret_sauce |
      | secret_sauce |

  Scenario Outline: Login with valid username and invalid password
    Given User navigates to login page
    When User enters "<username>" into username input
    And User enters "<password>" into password input
    And User clicks on login button
    Then User can see warning message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username                | password |
      | standard_user           | 1233     |
      | locked_out_user         | secret   |
      | problem_user            | _sauce   |
      | performance_glitch_user | /*-54sd  |

  Scenario Outline: Login with invalid username and valid password
    Given User navigates to login page
    When User enters "<username>" into username input
    And User enters "<password>" into password input
    And User clicks on login button
    Then User can see warning message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username | password     |
      | standard | secret_sauce |
      | awesome  | secret_sauce |
      | avenger  | secret_sauce |
      | justice  | secret_sauce |

    Scenario: Login with empty username and empty password
      Given User navigates to login page
      When User clicks on login button
      Then User can not login