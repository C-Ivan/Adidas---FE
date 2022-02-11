Feature: Interacting with the cart
  As a user
  I want to add or remove items from the cart
  So I can make an order

  Scenario Outline: Add products to the cart
    Given the user is in the "<page>"
    When the user goes to the "<category>" category
    And the user adds "<item 1>" from the "<category>" category to the cart
    And the user adds "<item 2>" from the "<category>" category to the cart
    Then the user should see "<expected items>" items in the cart

    Examples:
      | page     | category | item 1       | item 2      | expected items |
      | homepage | Laptops  | Sony vaio i5 | Dell i7 8gb | 2              |

  Scenario Outline: Remove products from the cart
    Given the user is in the "<page>"
    And the user adds "<item 1>" from the "<category>" category to the cart
    And the user adds "<item 2>" from the "<category>" category to the cart
    When the user removes "<item 1>" from the cart
    Then the user should see "<expected items>" items in the cart

    Examples:
      | page     | item 1       | item 2      | category | expected items |
      | homepage | Sony vaio i5 | Dell i7 8gb | Laptops  | 1              |