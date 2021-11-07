@wip
Feature: Volvocars

  Background:
    Given user should be able on the volvo-million-more page


  Scenario: Control the explanation text
    Then user should see the explanations on top of the volvo-million-more page


  Scenario: Control Watch The Story Button
    When user clicks the Watch The Story Button
    Then user should be able to watch the story


  Scenario: Control Volvo button
    When user clicks the volvo button
    Then user should be able on the home page
    And user returns volvo-million-more page

  @wip2
  Scenario: Control Our Cars module
    When user clicks the Our Cars button
    Then user should see the "Electric", "Hybrids" and "Mild hybrids" options


  Scenario: Control Menu Button
    When user clicks Menu button
    Then user should see the "Buy", "Own", "About Volvo", "Explore", "More" options on the menu