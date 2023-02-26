package stepDefinitions;

import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class Steps extends BaseClass
{
	
	//public WebDriver driver;
	//public LoginPage lp;
	
	@Before
	public void setup() throws IOException
	{
		configProp = new Properties();
		FileInputStream confiPropFile = new FileInputStream("config.properties");
		configProp.load(confiPropFile);
		
		
		
		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		String br = configProp.getProperty("browser");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			
			driver = new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		
		driver.manage().window().maximize();
		logger.info("Launched Browser");
	}
	

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{

	    lp = new LoginPage(driver);
		
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
		logger.info("Opening URL");
		
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) 
	{
		lp.setUserName(email);
		lp.setPassword(pwd);
		logger.info("Credentials Entered");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Click on Login")
	public void click_on_login() {
	    lp.clickLogin();
	    logger.info("Clicked on Login Button");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    	    
	    if (driver.getPageSource().contains("Login was unsuccessful.")) 
	    {
	    driver.close();
	    logger.info("Login Unsuccessful");
    	Assert.assertTrue(false);
    	
    	}
	    else 
	    {
	    Assert.assertEquals(title, driver.getTitle());
	    logger.info("Login Successful");
	    }
	    
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		lp.clickLogout();
		logger.info("Clicked on Logout Button");
	    //throw new io.cucumber.java.PendingException();
	}
	

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	    logger.info("Clicked on Logout Button");
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@When("User click on click on Customers Menu")
	public void user_click_on_click_on_customers_menu() throws InterruptedException {
	    Thread.sleep(3000);
	    addCust.clickCustomerMenu();
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@When("Click on Customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	    addCust.clickCustomerMenuItem();
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@When("Click on Add New Button")
	public void click_on_add_new_button() throws InterruptedException {
	    addCust.clickAddNew();
	    Thread.sleep(3000);
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("User can View Add New Customer Page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@When("User enter Customer Info")
	public void user_enter_customer_info() throws InterruptedException 
	{
	    String emailId = randomestring()+"@gmail.com";
	    
	    addCust.setEmail(emailId);
	    addCust.setPassword("abc123");
	    addCust.setFName("TestFName");
	    addCust.setLName("TestLName");
	    addCust.setGender("Female");
	    addCust.setDob("01/01/1995");
	    addCust.setCompany("MyCompany Pvt Ltd");
	    addCust.setAdminContent("Test Admin Content 1");
	    addCust.setCustomerRoles("Guests");
	    Thread.sleep(3000);
	    addCust.setManagerOfVendor("Vendor 2");
	    
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@When("Click on Save Button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickSave();
	    Thread.sleep(3000);
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("User can view Confirmation Message {string}")
	public void user_can_view_confirmation_message(String msg) 
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Enter Customer Email")
	public void enter_customer_email() throws InterruptedException {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setSearchEmail("admin@yourStore.com");
		Thread.sleep(1000);
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Click on Search Button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("User should Find Email on the Search Table")
	public void user_should_find_email_on_the_search_table() {
		boolean result1 = searchCust.searchCustomerByEmail("admin@yourStore.com");
		
		Assert.assertEquals(true, result1);
		
		
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Enter Customer First Name")
	public void enter_customer_first_name() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setSearchFName("Steve");
		
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("Enter Customer Last Name")
	public void enter_customer_last_name() {
		searchCust.setSearchLName("Gates");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("User should Find Name on the Search Table")
	public void user_should_find_name_on_the_search_table() {
		boolean result2 = searchCust.searchCustomerByName("Steve Gates");
		Assert.assertEquals(true, result2);
	    //throw new io.cucumber.java.PendingException();
	}
	
}
