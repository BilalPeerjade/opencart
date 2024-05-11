package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test (groups = {"sanity" , "master"})
	public void verify_login()
	{
		logger.info("*** Starting TC_002_LoginTest ***");
		logger.debug("Capturing application debug logs...");
		
		HomePage hp = new HomePage(driver);
		hp.clickLogoMyAccount();
		logger.info("clicked on MyAccount link...");
		hp.clickLogin();
		logger.info("clicked on login link...");	
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering Valid Email and Password...");	
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button...");
		
		MyAccountPage macc = new MyAccountPage (driver);
		boolean targetPage = macc.isMyAccountPageExists();
		if(targetPage==true)
		{
			logger.error("Login test passed");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Login test failed");
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
		
	}
}
