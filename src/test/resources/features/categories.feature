Feature: Homepage Categories
  As a user
  I want to go to all the categories
  So I can see the items of each of them

  Scenario Outline: Navigation through product categories
    Given the user is in the "<page>"
    When the user goes to the "<category>" category
    Then the user should see the products belonging to the "<category>" category

    Examples:
      | page     | category |
      | homepage | Laptops  |
      | homepage | Monitors |
      | homepage | Phones   |


