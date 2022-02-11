Feature: Orders and form
  As a user
  I want to be able to complete an order
  So I can buy an item

  Scenario Outline: Placing an order
    Given the user is in the "<page>"
    When the user goes to the "<category>" category
    And the user adds "<item 1>" from the "<category>" category to the cart
    And the user places the order
    Then a form should be displayed

    Examples:
      | page     | category | item 1            |
      | homepage | Phones   | Samsung galaxy s7 |

  Scenario Outline: Fill Purchase Form
    Given the user is in the "<page>"
    When the user goes to the "<category>" category
    And the user adds "<item 1>" from the "<category>" category to the cart
    And the user places the order
    And the user fills and confirms the purchase form
    Then a confirmation with the information of the purchase should appear

    Examples:
      | page     | category | item 1           |
      | homepage | Monitors | Apple monitor 24 |