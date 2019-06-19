package com.TestProject.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.stereotype.Controller;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.TestProject.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.host.worker.Worker;

import net.bytebuddy.description.modifier.SynchronizationState;

public class TestUtil extends TestBase{

	


	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICITWAIT=10;
	public static String TESTDATA_SHEET_PATH = "C:\\AppiumWorkspace1\\POM_TestProject2\\src\\main\\java\\com\\TestProject\\qa\\testdata\\PPMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void switchtoFrame()
	{
		driver.switchTo().frame("contentFrame");
	}
	
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); ///create screenshots folder into current directory
	}
	public static String createxpath(String xpath,Object ...args)
	{
		for (int i=0; i<args.length;i++)
		{
			xpath=xpath.replace("{"+i+"}", (CharSequence) args[i]);
		}
		
		return xpath;
		
	}
	public void setMultipleAttributeValues(String attributetype,String attributename , String attributevalue ) throws InterruptedException
	{
		
		
		
		System.out.println("-------------"+attributetype);
		System.out.println("-------------"+attributename);		
		System.out.println("-------------"+attributevalue);	
		
		
		
		String xpathforinputbox = null;
	try {
		if(attributetype.equalsIgnoreCase("id")){
			xpathforinputbox=createxpath("//input[@id='{0}']",attributename);
			
		}else if(attributetype.equalsIgnoreCase("name"))
		{
			xpathforinputbox= createxpath("//input[@name='{0}']",attributename);
		}
		else if(attributetype.equalsIgnoreCase("value"))
		{
			xpathforinputbox=createxpath("//input[@value='{0}']",attributename);
		}
		else if(attributetype.equalsIgnoreCase("class"))
		{
			xpathforinputbox=createxpath("//input[@class='{0}']",attributename);
		}
		else if(attributetype.equalsIgnoreCase("type"))
		{
			xpathforinputbox=createxpath("//input[@type='{0}']",attributename);
		}
		else {
			System.out.println("Select proper attributetype");
		}
		System.out.println(xpathforinputbox);
		//driver.findElement(By.xpath(xpathforinputbox)).click();
		//MobileElement element = (MobileElement) driver.findElementByXPath(xpathBuilder);
		//element.
		driver.findElement(By.xpath(xpathforinputbox)).sendKeys(attributevalue);
		}
	catch(Exception e) {
		
		System.out.println("Provide proper values");
		e.printStackTrace();
		
		}
	}
	
   }

