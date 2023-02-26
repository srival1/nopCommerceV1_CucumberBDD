package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]");
	By btnAddNew = By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.id("Email");
	By txtPwd = By.xpath("//input[@id='Password']");
	By txtFName = By.id("FirstName");
	By txtLName = By.id("LastName");
	By rdMale = By.id("Gender_Male");
	By rdFemale = By.id("Gender_Female");
	By txtDOB = By.id("DateOfBirth");
	By txtCompany = By.id("Company");
	By chkTaxExempt = By.id("IsTaxExempt");

	
	By drpdwnitem1 = By.xpath("//span[contains(text(),'Your Store Name')]");
	By drpdwnitem2 = By.xpath("//span[contains(text(),'Test store 2')]");
		
	
		By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	    By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	    By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	    By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	    By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");


	    By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");

/*By rdMaleGender=By.id("Gender_Male");
	    By rdFeMaleGender=By.id("Gender_Female");

	    By txtFirstName=By.xpath("//input[@id='FirstName']");
	    By txtLastName=By.xpath("//input[@id='LastName']");

	    By txtDob=By.xpath("//input[@id='DateOfBirth']");

	    By txtCompanyName=By.xpath("//input[@id='Company']");
*/

	    By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");

	    By btnSave=By.xpath("//button[@name='save']");

	    //Actions Methods
	    
	    public String getPageTitle() 
	    {
	    	return ldriver.getTitle();
	    }
	    
	    public void clickCustomerMenu()
		{
	    	ldriver.findElement(lnkCustomers_menu).click();
		}
	    
	    public void clickCustomerMenuItem()
		{
	    	ldriver.findElement(lnkCustomers_menuitem).click();
		}
	    
	    public void clickAddNew()
		{
	    	ldriver.findElement(btnAddNew).click();
		}
	
	
		public void setEmail(String email)
		{
			ldriver.findElement(txtEmail).clear();
			ldriver.findElement(txtEmail).sendKeys(email);
		}
		
		public void setPassword(String pwd)
		{
			//ldriver.findElement(txtPwd).clear();
			ldriver.findElement(txtPwd).sendKeys(pwd);
		}
		
		public void setFName(String fname)
		{

			ldriver.findElement(txtFName).sendKeys(fname);
		}
		
		public void setLName(String lname)
		{

			ldriver.findElement(txtLName).sendKeys(lname);
		}
		

	    
		public void setCompany(String company)
		{

			ldriver.findElement(txtCompany).sendKeys(company);
		}

		public void setDob(String dob)
	    {
	        ldriver.findElement(txtDOB).sendKeys(dob);
	    }

	    public void setAdminContent(String content)
	    {
	        ldriver.findElement(txtAdminContent).sendKeys(content);
	    }

	    public void clickSave()
	    {
	        ldriver.findElement(btnSave).click();
	    }
		
	    public void setCustomerRoles(String role) throws InterruptedException
	    {
	        if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
	        {
	            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	        }

	        ldriver.findElement(txtcustomerRoles).click();

	        WebElement listitem;

	        Thread.sleep(3000);

	        if(role.equals("Administrators"))
	        {
	            listitem=ldriver.findElement(lstitemAdministrators);
	        }
	        else if(role.equals("Guests"))
	        {
	            listitem=ldriver.findElement(lstitemGuests);
	        }
	        else if(role.equals("Registered"))
	        {
	            listitem=ldriver.findElement(lstitemRegistered);
	        }
	        else if(role.equals("Vendors"))
	        {
	            listitem=ldriver.findElement(lstitemVendors);
	        }
	        else
	        {
	            listitem=ldriver.findElement(lstitemGuests);
	        }

	        //listitem.click();
	        //Thread.sleep(3000);

	        JavascriptExecutor js = (JavascriptExecutor)ldriver;
	        js.executeScript("arguments[0].click();", listitem);

	    }

	    public void setManagerOfVendor(String value)
	    {
	        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
	        drp.selectByVisibleText(value);
	    }

	    public void setGender(String gender)
	    {
	        if(gender.equals("Male"))
	        {
	            ldriver.findElement(rdMale).click();
	        }
	        else if(gender.equals("Female"))
	        {
	            ldriver.findElement(rdFemale).click();
	        }
	        else
	        {
	            ldriver.findElement(rdMale).click();//Default
	        }

	    }
	

}
