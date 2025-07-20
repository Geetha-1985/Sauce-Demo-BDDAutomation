Feature: Check Products List and Cart Operations

  Background:
    Given User is on the login page


@Priority_Medium @ProductsPage @Positive
  Scenario: TC07_Check all products are displayed correctly
    When User enters "standard_user" and "secret_sauce" in username and password fields
    And User clicks the login button
    Then all products should have name, image, and price displayed

@Priority_High @ProductsPage @Positive
  Scenario Outline: TC09_TC10_Check Cart quantity by adding a single product to cart and then remove it from the cart for the User : "<username>"
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    When User add the product "Sauce Labs Bolt T-Shirt" to the cart
    Then the cart icon should show quantity as "1"
    When User remove the product "Sauce Labs Bolt T-Shirt" from the cart
    Then the cart icon should not show the quantity
    
    Examples:
      | username                 | password       |
      | standard_user            | secret_sauce   |
      | problem_user             | secret_sauce   |
      

@Priority_High @ProductsPage @Positive
  Scenario Outline: TC11_Add multiple products and verify cart overview for the User :"<username>" 
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    When User add the product "Sauce Labs Bike Light" to the cart
    And add the product "Sauce Labs Bolt T-Shirt" to the cart
    And User click the cart icon
    Then User should see "Sauce Labs Bike Light" and "Sauce Labs Bolt T-Shirt" in the cart
    
    Examples:
      | username                 | password       |
      | standard_user            | secret_sauce   |
      | problem_user             | secret_sauce   |
      