Feature: Login 

@smoke
Scenario: Successful Login with Valid Credentials 
	Given User launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce" 
	And Click on Login Button 
	Then Page Title should be "Swag Labs" 
	When User click on Logout button 
	Then Page Title should be "Swag Labs" 
	And close the browser 

@sanity @regression
Scenario Outline: Successful Login with Valid and Invalid Credentials 
	Given User launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "<username>" and Password as "<password>" 
	And Click on Login Button 
	Then Page Title should be "Swag Labs" 
	When User click on Logout button 
	Then Page Title should be "Swag Labs" 
	And close the browser
	
Examples: 
	|username|password|
	|standard_user|secret_sauce|
	|locked_out_user|secret_sauce|


@demo
Scenario: demo login
	Given User launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce"
	Then close the browser
	
	
	