package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email , String password , String exp)
	{
		logger.info("***Starting TC_003_LoginDDT ***");
		try
		{
		//HomePage
		HomePage hp = new HomePage (driver);
	//	hp.clickMyAccount();
		hp.clickLogoMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp = new LoginPage (driver);
		lp.setEmail(email);
		lp.setPassword(password);
        lp.clickLogin();
        
        //MyAccountPage
        MyAccountPage map = new MyAccountPage(driver);
        boolean targetPage = map.isMyAccountPageExists();
        
        
        if(exp.equalsIgnoreCase("Valid"))
        {
        	if(targetPage == true)
        	{
        		hp.clickLogoMyAccount();
        		map.clickLogout();
        		Assert.assertTrue(true);
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        }
        
        if(exp.equalsIgnoreCase("Invalid"))
        {
        	if(targetPage == true)
        	{
        		hp.clickLogoMyAccount();
        		map.clickLogout();
        		Assert.assertTrue(false);
        	}
        	else
        	{
        		Assert.assertTrue(true);
        	}
        }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
        logger.info("*** Finished TC_003_LoginDDT ***");
        
		
	}
	
}
