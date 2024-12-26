Feature: Shopping 

Background: Common Steps for all scenarios 
	Given User launch Chrome browser 
	When User opens URL "https://www.saucedemo.com/" 
	And User enters Username as "standard_user" and Password as "secret_sauce" 
	And Click on Login Button 
	Then Page Title should be "Swag Labs" 

@regression	
Scenario: To validate the Jacket has been added to the Cart 
	When User click on Filter Dropdown 
	And User selected Price(high to low) option 
	And User click on Jacket 
	And User click on Cart button to checkout the added items 
	Then User verified the Jacket has been added to Cart. 
	And close the browser 
	
Scenario: Add & Remove some Items to the Cart 
	When User added Backpack to the Cart 
	And User added T-shirt to the Cart 
	And User added Bike Light to the Cart and removed it from Cart 
	And User click on Cart button to checkout the added items 
	Then User verified the items "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" has been added to Cart. 
	And close the browser 
