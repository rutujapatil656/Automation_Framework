package com.TestProject.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.TestProject.qa.base.TestBase;

public class HomePage extends TestBase{
 static int tdnumber;
 public String projectNumber ;

//Page Factory
 @FindBy(xpath="//div[text()='Planisware']")
	WebElement PlaniswareIcon;
 @FindBy(xpath="//td[text()='Prj#']/ancestor::tr[2]/following-sibling::tr//table[1]//td[@class=' CQClassReadOnly CQCellBase CQType CQInt CQCell HideCol0A']/div")
 WebElement captureprojectnumber;
 
 
 
 
 
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle()
 {
		
		String HomePageTitle= driver.getTitle();
		 Assert.assertEquals(HomePageTitle, "Planisware 6 - Home", "Home Page Title not matched");
		return HomePageTitle;
	
	 } 
	public String verifyPPMLoginUser() throws InterruptedException
	 {
		 Actions action = new Actions(driver);
		 action.doubleClick(PlaniswareIcon).perform();
		 Thread.sleep(1000);
		 
		String str2=driver.findElement(By.xpath("//table[@class='rte'][1]/following-sibling::table[1]//td/div[contains(text(),'Nikhil  Dighe')]")).getText(); 
			 Assert.assertEquals(str2, "Nikhil Dighe");
			return str2;
		 
	 }
	

  

	
	
	
	
	
	
	}
	

