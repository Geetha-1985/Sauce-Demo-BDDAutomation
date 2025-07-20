Feature: User Login check with valid and invalid credentials 

Background:
	Given User is on the login page

@Priority_High @Login @Positive
Scenario Outline: TC01_Login with valid user credentials - User : "<username>"
    
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    Then Inventory page should be displayed
   
    Examples:
      | username                 | password       |
      | standard_user            | secret_sauce   |
      | problem_user             | secret_sauce   |
      | performance_glitch_user  | secret_sauce   |
 	  | error_user               | secret_sauce   |	
      | visual_user              | secret_sauce   |
    

@Priority_Medium @Login @Negative 
Scenario: TC06_Login with Locked out user credentials 
    
    When User enters "locked_out_user" and "secret_sauce" in username and password fields
    And User clicks the login button
    Then Error message "Epic sadface: Sorry, this user has been locked out." should be displayed
    
@Priority_Low @Login @Negative  
Scenario Outline: TC02_TC03_TC04_TC05_Login with invalid user credentials - User : "<username>"
    
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    Then Error message "<errorMessage>" should be displayed
    
    Examples:
      | username        | password       | errorMessage                                                  |
      | invalid_user    | secret_sauce   | Epic sadface: Username and password do not match any user in this service     |
      | standard_user   | wrong_password | Epic sadface: Username and password do not match any user in this service    |
      |                 | secret_sauce   | Epic sadface: Username is required                            |
      | standard_user   |                | Epic sadface: Password is required                            |
   