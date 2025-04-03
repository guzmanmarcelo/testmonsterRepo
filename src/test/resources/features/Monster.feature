@UI
Feature: Tests for 'Create your monster'

  Background:
    Given I open the Create your monster page

  Scenario: Verify an error message is displayed when not all fields are filled
    Given The Create your monster page is opened
    When I click the Create Monster button
    Then I verify that the "All fields are required" is displayed

  Scenario: Verify an error message is displayed if incorrect values are entered
    Given The Create your monster page is opened
    When I select a monster with the following values
      | Number  | 1           |
      | Name    | monsterTest |
      | HP      | 1           |
      | Attack  | 1           |
      | Defense | 1           |
      | Speed   | 111         |
    Then I verify that the "Please enter a valid number" is displayed

    Scenario: Verify a monster is created
      Given The Create your monster page is opened
      When I select a monster with the following values
        | Number  | 1           |
        | Name    | monsterTest |
        | HP      | 1           |
        | Attack  | 1           |
        | Defense | 1           |
        | Speed   | 1           |
      When I click the Create Monster button
      Then I verify the monster is created
