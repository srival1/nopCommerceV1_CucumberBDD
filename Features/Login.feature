Feature: Login

 Background: Below are Common Steps for this Feature
 	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"

	@Regression
	Scenario: Successful Login with Valid Credentials

	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser
	
	@Sanity
	Scenario Outline: Login Data Driven
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser
	
	Examples:
		|email|password|
		|admin@yourstore.com|admin|
		|admin@yourstore.com|admin|
		#|adminx@yourstore.com|admin|
		#|admin@yourstore.com|adminx|
		