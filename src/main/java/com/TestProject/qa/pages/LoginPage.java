package com.TestProject.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.util.TestUtil;

import org.openqa.selenium.interactions.Actions;
public class LoginPage extends TestBase 
{

	
	TestUtil t1 = new TestUtil();
	//Page Factory-or
	@FindBy(id="login")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;

	
	@FindBy(id="submit")
	WebElement SignInbutton;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginButton;
	


	
	//initializing page object
	public LoginPage() throws IOException //to initialize above elements with the page factory
	{
		
		PageFactory.initElements(driver, this);//pointing to current class //object all the  variable(username,password,submitbutton) are initialize with its driver
		
		// TODO Auto-generated constructor stub
	}

	 public String validateLoginPageTitle()
	 {
		
		return driver.getTitle();
	
	 }
	 
	 
	 public void  test(String attributetype, String attributename, String attributevalue ) throws InterruptedException
	 {
		 t1.setMultipleAttributeValues(attributetype, attributename, attributevalue);
	 }
	 

	 public HomePage login(String un, String pwd ) throws InterruptedException, IOException
	 {
		 
		
		 
		  Thread.sleep(1000);
		 username.sendKeys(un);
		 System.out.println(un);
		 Thread.sleep(1000);
		 password.sendKeys(pwd);
		 System.out.println("pass -" +pwd);
		 Thread.sleep(1000);
		 SignInbutton.click();
		 Thread.sleep(2000);
		 LoginButton.click();
		 
		 Thread.sleep(6000);
		
		 return new HomePage();
	 }
	 
}
