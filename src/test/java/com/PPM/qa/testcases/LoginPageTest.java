package com.PPM.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;
import com.TestProject.qa.util.TestUtil;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	public LoginPageTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initilization();
		loginPage= new LoginPage();
		testUtil = new TestUtil();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException
	{
		String tritle= loginPage.validateLoginPageTitle();
		System.out.println(tritle);
		Thread.sleep(3000);
		loginPage.test("class", "input", "lrus0021");
		Thread.sleep(6000);
		
	}
//	
//	@Test(priority=2)
//	public void loginTest() throws InterruptedException, IOException
//	{
//		 int size = driver.findElements(By.tagName("frame")).size();
//		  System.out.println("Total Frames " + size);
//		
//		
//		System.out.println(prop.getProperty("username"));
//		
//		//loginPage.login(String un, String pwd)
//		
//		System.out.println(prop.getProperty("password"));
//		homepage=
//				loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //this is Login method
//	//here we are calling Login() from LoginPage.java class and it has two parameters (username and passwod). but we will get this values from properties file and to get this values 
//		//use prop.getProperty
//	}
//
//	
//	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
