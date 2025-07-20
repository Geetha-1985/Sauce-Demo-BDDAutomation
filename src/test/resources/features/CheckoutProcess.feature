Feature: Validate Checkout process in Sauce Labs

  Background:
    Given User is on the login page
    

@Priortiy_High @Checkout @Negative
  Scenario: TC21_Cancel checkout from Checkout overview page 
    When User enters "standard_user" and "secret_sauce" in username and password fields
    And User clicks the login button
    When User add the product "Sauce Labs Bike Light" to the cart
    And add the product "Sauce Labs Bolt T-Shirt" to the cart
    And User click the cart icon
    And User proceeds to checkout
    And User enters first name "Geetha", last name "S", and postal code "600100" in Checkout Information
    And User clicks on Continue
    Then User should see the Checkout Overview page
    When User clicks on Cancel
    Then User should be redirected to Inventory page

@Priority_Medium @Checkout @Negative
  Scenario Outline: TC17_TC18_TC19_Checkout process with missing information - first name : "<First name>", last name : "<Last name>", and Postal code : "<Postal Code>" 
    When User enters "standard_user" and "secret_sauce" in username and password fields
    And User clicks the login button
    When User add the product "Sauce Labs Bolt T-Shirt" to the cart
    And User click the cart icon
    And User proceeds to checkout
    And User enters first name "<First name>", last name "<Last name>", and postal code "<Postal Code>" in Checkout Information
    And User clicks on Continue
    Then User should see an error message "<Error Msg>"
    
    Examples:
      | First name               | Last name	  | Postal Code		|  Error Msg                       |
      | 			             | Nehru	      |   23456			| Error: First Name is required   |
      | Jawaharlal               | 	              |   12456         | Error: Last Name is required   |
      | Jawaharlal               | Nehru          |                 | Error: Postal Code is required   |
 	
  
  @Priority_High @Checkout @Positive  
  Scenario Outline: TC22_Successful Checkout process - User : "<username>" 
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    When User add the product "Sauce Labs Bike Light" to the cart
    And add the product "Sauce Labs Bolt T-Shirt" to the cart
    And User click the cart icon
    And User proceeds to checkout
    And User enters first name "Dhanvanth", last name "N", and postal code "600100" in Checkout Information
    And User clicks on Continue
    Then User should see the Checkout Overview page
    When User click on finish button
    Then Checkout Complete page is displayed with Success message "Thank you for your order!"
    
    Examples:
      | username                 | password       |
      | standard_user            | secret_sauce   |
      | error_user               | secret_sauce   |	
    