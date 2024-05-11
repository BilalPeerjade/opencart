package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass; 

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	@Test (groups= {"regression" , "master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**** Starting TC_001_AccountRegistrationTest **** ");
	try
	   {
		HomePage hp = new HomePage (driver) ;
       
		hp.clickLogoMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Registration Link");
		AccountRegistrationPage regPage = new AccountRegistrationPage (driver);
		
		logger.info("Entering Customer Details");
		regPage.setFirstName(randomAlphabetic());
		Thread.sleep(1000);
		regPage.setLastName(randomAlphabetic());
		Thread.sleep(1000);
		regPage.setEmailId(randomAlphabetic()+"@gmail.com");
		Thread.sleep(1000);
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric() ;
		regPage.setPassword(password);
		Thread.sleep(1000);
		regPage.setConfirmPassword(password);
		
		regPage.clickPravicyPolicy();
		regPage.clickContinue();
		logger.info("Clicked on Continue");
		
		String conmsg = regPage.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(conmsg , "Your Account Has Been Created!");
    	}
		catch(Exception e)
	    {
			logger.error("test failed");
			Assert.fail();
     	}
	    logger.info("**** Finished TC_001_AccountRegistrationTest ****");
	    
	
	
	}
	
      
	
	
}	