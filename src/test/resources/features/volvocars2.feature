@wip
Feature: Volvocars2

  Background:
    Given user should be able on the volvo-million-more page


  Scenario: Control videos on the page
    When user clicks video 1 run button
    Then user should watch video 1
    When user clicks video 2 run button
    Then user should watch video 2
    When user clicks video 3 run button
    Then user should watch video 3
    When user clicks video 4 run button
    Then user should watch video 4


  Scenario Outline: Control "<buttonName>" button
    When user clicks "<buttonName>" button
    Then user should see the "<buttonName>" page
    And user returns volvo-million-more page

    Examples:
      | buttonName       |
      | Cookies          |
      | Legal            |
      | Privacy          |
      | Social Media     |