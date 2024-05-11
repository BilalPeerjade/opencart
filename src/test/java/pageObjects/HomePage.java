package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	
	WebDriver driver ;
	public HomePage(WebDriver driver) 
	{
		super (driver);
		//PageFactory.initElements(driver , this);
	}
	 

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement logoMyAccount ;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister ;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin ;  // addded in step 5
	
	
	
	public void clickMyAccount()
	{
    	lnkMyAccount.click();
	}
	public void clickLogoMyAccount()
	{
		logoMyAccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
}
