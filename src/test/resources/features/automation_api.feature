@test
Feature: Create order

  Background:
    Given Customer is a user of test

  Scenario Outline: Create order from Neoris
    When create user with <name> and <position>
    Then it get successful creation in test
    Examples:
      | name     | position |
      | morpheus | leader   |

  Scenario Outline: Create order from Neoris Bad Request is expected
    When create user with <name> and <position>
    Then it get bad Request in test
    Examples:
      | name     | position |
      | morpheus | leader   |