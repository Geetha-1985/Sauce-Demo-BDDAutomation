Feature: User Logout 


@Priority_High @Logout @Positive
Scenario Outline: TC23_Logout from Products page after successful login - user : "<username>"
    Given User is on the login page
    When User enters "<username>" and "<password>" in username and password fields
    And User clicks the login button
    Then Inventory page should be displayed
    When User clicks the side menu
    And Click the logout link
    Then User should be redirected back to the login page
   
    Examples:
      | username                 | password       |
      | standard_user            | secret_sauce   |
      | problem_user             | secret_sauce   |
      | performance_glitch_user  | secret_sauce   |
 	  | error_user               | secret_sauce   |	
      | visual_user              | secret_sauce   |
    