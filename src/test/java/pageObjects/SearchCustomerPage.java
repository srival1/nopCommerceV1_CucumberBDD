package pageObjects;

import java.time.Duration;
import java.util.List;

import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new WaitHelper(ldriver);
	}

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;
	

	By txtEmailId = By.xpath("//input[@id='SearchEmail']");
	By btnSearch = By.xpath("//*[@id='search-customers']");
	
	    //Actions Methods
	    
   
	    public void setSearchEmail(String email)
		{
			//ldriver.findElement(txtPwd).clear();
			ldriver.findElement(txtEmailId).sendKeys(email);
		}
	    
	    public void setSearchFName(String fname)
		{
			//ldriver.findElement(txtPwd).clear();
	    	waitHelper.WaitForElement(txtFirstName,Duration.ofSeconds(10));
			txtFirstName.sendKeys(fname);
		}
	    
	    public void setSearchLName(String lname)
		{
			//ldriver.findElement(txtPwd).clear();
	    	waitHelper.WaitForElement(txtLastName,Duration.ofSeconds(10));
			txtLastName.sendKeys(lname);
		}
	    
	    public void clickSearch()
	    {
	    	waitHelper.WaitForElement(txtLastName,Duration.ofSeconds(10));
	        ldriver.findElement(btnSearch).click();
	    }
	    
	    public int getNoOfRows() {
	        return (tableRows.size());
	    }

	    public int getNoOfColumns() {
	        return (tableColumns.size());
	    }

	    public boolean searchCustomerByEmail(String email) {
	        boolean flag = false;

	        for (int i = 1; i <= getNoOfRows(); i++) {
	            String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
	                    .getText();



	            System.out.println(emailid);

	            if (emailid.equals(email)) {
	                flag = true;
	                break;
	            }
	        }

	        return flag;

	    }

	    public boolean searchCustomerByName(String Name) {
	        boolean flag = false;

	        for (int i = 1; i <= getNoOfRows(); i++) {
	            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
	                    .getText();


	            if (Name.equals(name)) {
	                flag = true;
	                break;
	            }
	        }

	        return flag;

	    }
	    

}
