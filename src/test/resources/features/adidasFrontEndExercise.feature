@challenge
Feature: Adidas Tech Challenge QA
  As a QA Automation engineer
  I want to complete the tech challenge
  So I can be hired

  Scenario Outline: Adidas Tech Challenge Front End QA
    Given the user is in the "<page>"
    When the user goes to the "<category>" category
    And the user adds "<item 1>" from the "<category>" category to the cart
    And the user adds "<item 2>" from the "<category>" category to the cart
    And the user removes "<item 2>" from the cart
    And the user places the order
    And the user fills and confirms the purchase form
    Then the total purchase amount should be "<expected total price>"

    Examples:
      | page     | category | item 1       | item 2      | expected total price |
      | homepage | Laptops  | Sony vaio i5 | Dell i7 8gb | 790                  |