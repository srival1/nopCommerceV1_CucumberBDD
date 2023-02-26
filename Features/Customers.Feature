Feature: Customers

 Background: Below are Common Steps for Every Scenario
 	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on click on Customers Menu
	And Click on Customers Menu Item

@Sanity
Scenario: Add New Customer
	And Click on Add New Button
	Then User can View Add New Customer Page
	When User enter Customer Info
	And Click on Save Button
	Then User can view Confirmation Message "The new customer has been added successfully."
	And close browser
	
@Sanity
Scenario: Search Customer by EmailID
	And Enter Customer Email
	And Click on Search Button
	Then User should Find Email on the Search Table
	And close browser
	
@Sanity
Scenario: Search Customer by First and Last Name
	And Enter Customer First Name
	And Enter Customer Last Name
	And Click on Search Button
	Then User should Find Name on the Search Table
	And close browser