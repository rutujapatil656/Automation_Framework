package com.TestProject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.TestProject.qa.util.TestUtil;
import com.TestProject.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() throws IOException
	{
		try{
			prop= new Properties();
		
		FileInputStream fs= new FileInputStream("C:\\AppiumWorkspace1\\POM_TestProject2\\src\\main\\java\\com\\TestProject\\qa\\config\\config.properties");
		prop.load(fs);
	}
	catch(FileNotFoundException e)
		{
		e.printStackTrace();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	
	public static void initilization() throws IOException
	{
		String browsername=prop.getProperty("browser");
       
		
		if(browsername.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\patilr8\\AppData\\Local\\QualitiaWDClient\\app-5.5.0\\WebDriver\\Selenium\\geckodriver.exe");
			 driver =	new FirefoxDriver();
			
		}
		
		else if(browsername.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\patilr8\\AppData\\Local\\QualitiaWDClient\\app-5.5.0\\WebDriver\\Selenium\\chromedriver.exe");
			    driver =	new ChromeDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		   driver.get(prop.getProperty("url"));
		
		
		
	}
}
