package com.PPM.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;
import com.TestProject.qa.pages.ProjectPage;
import com.TestProject.qa.util.TestUtil;

public class ProjectPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	String projecthomepage1;
	String sheetname="HomePage"; 
	ProjectPage projecthomepage; 
	TestUtil testUtil;
	 int tdnumber;
		
	
	public ProjectPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initilization();
		loginPage= new LoginPage();
		homepage= new HomePage();
		projecthomepage = new ProjectPage();
		testUtil = new TestUtil();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login method returning home page object so use homepage
		
		
		
		//String String2=homepage.captureprojectnumber1();
		//projecthomepage1=String2;
		//homepage.clickOnOptionAgainstProjrctNumber(3);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		TestUtil.getTestData(sheetname);
		Object data [][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	
//	@Test(priority=1)
//	public void createProgramTest() throws InterruptedException, IOException
//	{
//		projecthomepage.createProgram();
//	}
	
//   @Test(priority=1,dataProvider="getTestData")
//   public void createProgramTest(String id,String value) throws InterruptedException, IOException
//	{
//			   	   
//	   projecthomepage.createProgram1(id, value);
//	  
//		//String projectpagetitle=driver.getTitle();
//		//System.out.println(projectpagetitle);
//	}
	
	
	 @Test(priority=1,dataProvider="getTestData")
	   public void createProgramTest3(String id,String value) throws InterruptedException, IOException
		{
				   	   
		   projecthomepage.createProgram1(id, value);
		  
			//String projectpagetitle=driver.getTitle();
			//System.out.println(projectpagetitle);
		}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
