package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	
	WebDriver driver ;
	public MyAccountPage (WebDriver driver)
	{
		super (driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading ;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement lnkLogout;
	
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed()) ;
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
