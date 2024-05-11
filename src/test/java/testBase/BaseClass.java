package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;    //log4j
//import org.apache.logging.log4j.Logger; //Log4j


public class BaseClass 
{
	
	static public WebDriver driver ;
	public Logger logger ;
	public Properties p;
	
	@BeforeClass (groups= {"sanity" , "regression" , "master"})
	@Parameters ({"os" , "browser"})
	public void setup(String os , String br) throws IOException
	{
		//loading Properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		//Loading log4j2 file 
		logger = LogManager.getLogger(this.getClass());
		
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//decide: OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS...");
				return ;
			}
			
			//decide: Browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge"   : capabilities.setBrowserName("MiscrosoftEdge"); break;
			default       : System.out.println("No Matching Browser...");
			return ;
			}
			
			WebDriver driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), capabilities);
			                                                //http://localhost:4444/wd/hub
		}
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//1aunching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); break ;
			case "edge"   : driver = new EdgeDriver();   break ;
			default : System.out.println("No Matching Browser...");
	           		return ;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
	}

	@AfterClass (groups= {"sanity" , "regression" , "master"})
	public void tearDown() throws InterruptedException
	{
	//	driver.close();
		Thread.sleep(1000);
		driver.quit();
	}

	
	public String randomAlphabetic()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString ;
	}
    public String randomNumber()
    {
        String generatedString=RandomStringUtils.randomNumeric(10);
        return generatedString ;
    }
    public String randomAlphaNumeric()
    {
    	String str= RandomStringUtils.randomAlphabetic(3);
    	String num= RandomStringUtils.randomNumeric(3) ;
    	
    	return (str+ "@" +num) ;
    }
	
	
    
    
    //ExtentReportManager -----
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
