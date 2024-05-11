package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
    WebDriver driver ;
    public AccountRegistrationPage (WebDriver driver)
    {
    	super (driver) ;
    }
	
 //  @FindByXpath("//input[@id='input-firstname']") WebElement txtFirstName ;

 
    @FindBy(xpath="//input[@id='input-firstname']") private WebElement txtFirstName;
    @FindBy(xpath="//input[@id='input-lastname']")  private WebElement txtLastName;
    @FindBy(xpath="//input[@id='input-email']") private WebElement txtEmailId;
    @FindBy(xpath="//input[@id='input-telephone']")  private WebElement txtTelephone;
    @FindBy(xpath="//input[@id='input-password']")  private WebElement txtPassword;
    @FindBy(xpath="//input[@id='input-confirm']")  private WebElement txtConfirmPassword;
    @FindBy(xpath="//input[@name='agree']")  private WebElement chkbPolicy;
    @FindBy(xpath="//input[@value='Continue']")  private WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") private WebElement msgConfirmation;
    
    
 //Actions 
    public void setFirstName (String fname){
    	txtFirstName.sendKeys(fname);
    }
    
    public void setLastName (String lname) {
    	txtLastName.sendKeys(lname);
    }
    
    public void setEmailId (String email) {
    	txtEmailId.sendKeys(email);
    }
    
    public void setTelephone (String tel) {
    	txtTelephone.sendKeys(tel);
    }
    
    public void setPassword(String pass) {
    	txtPassword.sendKeys(pass);
    }
    
    public void setConfirmPassword(String pass) {
    	txtConfirmPassword.sendKeys(pass);
    }
    
    public void clickPravicyPolicy()
    {
    	chkbPolicy.click();
    }
    
    public void clickContinue()
    {
    //Sol 1	
    	btnContinue.click();
    
    //Sol 2	
    //	btnContinue.submit();
    
    //Sol 3	
    //	Actions act = new Actions(driver) ;
    //	act.moveToElement(btnContinue).click().perform();
    
    //Sol 4	
    //	JavascriptExecutor js = (JavascriptExecutor) driver ;
    //	js.executeScript("arguments[0].click();" , btnContinue) ;
    	
    //Sol 5	
    //	btnContinue.sendKeys(Keys.RETURN);
    
    //Sol 6	
    //	WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(10)) ;
    //	mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    	
    }
    
    public String getConfirmationMsg()
    {	
    	try 
    	{
    		return (msgConfirmation).getText();
    	}
    	catch(Exception  e)
    	{
    		return (e.getMessage()) ;
    	}
    }
    
    
}
