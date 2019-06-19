package com.TestProject.qa.pages;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;

public class ProjectPage extends TestBase {

	
	  int tdnumber;
		
	//Page Factory
	  @FindBy(xpath="//img[@alt='save-menu-grey']/following-sibling::img[1]")
	 	WebElement HomeListIcon;
	  
	  @FindBy(xpath="//div[text()='Programs']")
	 	WebElement ProgramsTab;
	  
	  
	  
	  @FindBy(xpath="//span[text()='New']")
	 	WebElement NewOption;
	  
	  @FindBy(xpath="//div[@class='menu']/descendant::*[text()='Program']")
	 	WebElement ProgramOption;

	public ProjectPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public String validateProjectPageTitle()
	 {
		
		String ProjectPageTitle= driver.getTitle();
		 Assert.assertEquals(ProjectPageTitle, "PPTA - Project Part Tracking Application", "Home Page Title not matched");
		 return driver.getTitle();
	
	 }
	
	
//	public ProjectPage createProgram() throws InterruptedException, IOException
//	{
//			Actions action = new Actions(driver);
//			action.doubleClick(HomeListIcon).perform();
//			action.doubleClick(ProgramsTab).perform();
//			action.doubleClick(HomeListIcon).perform();
//			//HomeListIcon.click();
//			
//			NewOption.click();
//			ProgramOption.click();
//			Thread.sleep(5000);
//				
//				driver.findElement(By.xpath("//input[@aria-label='TEMPLATE']")).sendKeys("Product Development Program Template");
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//input[@aria-label='COMMENT']")).sendKeys("Test");
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//input[@aria-label='0BS']")).sendKeys("WRP_CF_XBS:Cost Improvement");
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//input[@aria-label='1BS']")).sendKeys("PRG-100852:CT");
//				WebElement elementLocator  =driver.findElement(By.xpath("//button[text()=\"Apply\"]"));
//				elementLocator.click();
//				action.doubleClick(elementLocator).perform();
//				Thread.sleep(15000);
//				WebElement elementLocator1=driver.findElement(By.xpath("//button[text()=\"OK\"]"));
//		
//				action.doubleClick(elementLocator1).perform();
//				Thread.sleep(2000);
//				
//				Thread.sleep(5000);
//			
//				return new ProjectPage();
//				
//			}	
//			
//	
	
	
	
	public ProjectPage createProgram1(String id, String value ) throws InterruptedException, IOException
{
		Actions action = new Actions(driver);
		action.doubleClick(ProgramsTab).perform();
		action.doubleClick(HomeListIcon).perform();
		//HomeListIcon.click();
		
		NewOption.click();
		ProgramOption.click();
		Thread.sleep(5000);
			System.out.println("id="+id);
			System.out.println(value);
			driver.findElement(By.xpath("//input[@aria-label=\'"+id+"']")).sendKeys(value);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@aria-label=\'"+id+"']")).sendKeys(value);
			Thread.sleep(5000);
		//	String selectedvalue=driver.findElement(By.xpath("//select[@id=\'"+id+"']")).getText();
			//Assert.assertEquals(selectedvalue, dropdonvalue);
			
			return new ProjectPage();
			
		}
	
	
	

}
