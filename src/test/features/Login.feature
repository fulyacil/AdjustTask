@Payment
Feature: Login Scenarios For Web App

  Scenario Outline: LoginWithCorrectCredential
   Given Verify Login Page
   And Enter "<username>" and "<password>"
   And Click login button
   Then Verify home page

   Examples:
   |username               |password    |
   |standard_user          |secret_sauce|

  Scenario Outline: LoginWithInCorrectCredential
    Given Verify Login Page
    And Enter "<username>" and "<password>"
    And Click login button
    Then Verify error message "Epic sadface: Sorry, this user has been locked out."

    Examples:
      |username           |password    |
      |locked_out_user    |secret_sauce|






 
 
 		
    
