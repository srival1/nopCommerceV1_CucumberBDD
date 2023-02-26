package stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass 
{
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	
	public Properties configProp;
	
	public static String randomestring()
	{
		String genRanString = RandomStringUtils.randomAlphabetic(6);
		return genRanString;
	}

}
