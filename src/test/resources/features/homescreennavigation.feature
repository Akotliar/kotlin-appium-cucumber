Feature: HomeScreen functionality / navigation

  Background:
    Given I am on the RideYR Homescreen

  Scenario Outline: Homescreen search by stop code
    When I search for the "<stop_code>" stop code in the search input field
    Then I should see the stop time screen for the stop at the stop number "<stop_code>"
    Examples:
      | stop_code |
      | 1234      |
      | 2700      |
      | 5678      |

  Scenario: Homescreen view Service Alerts
    When I select an active service alert
    Then I should see the selected service alert details