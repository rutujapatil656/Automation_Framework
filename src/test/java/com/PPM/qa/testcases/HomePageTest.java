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

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ProjectPage projecthomepage;
	String sheetname="HomePage"; //name in excel file
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initilization();
		loginPage= new LoginPage();
		testUtil = new TestUtil();
		
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login method returning home page object so use homepage
	}
	
	
	   @Test(priority=1)
	   public void validateHomePageTitleTest() 
	
	   {
		homepage.validateHomePageTitle();
	    }
	
	  @Test(priority=2)
		public void verifyusernameTest() throws InterruptedException
		{
			homepage. verifyPPMLoginUser();
		}
//		
//		@Test(priority=3)
//		public void captureprojectnumberTest()
//		{
//			homepage.captureprojectnumber1();
//		}
//		
//		@DataProvider
//		public Object[][] getTestData()
//		{
//			TestUtil.getTestData(sheetname);
//			Object data [][]=TestUtil.getTestData(sheetname);
//			return data;
//		}
//		
//		@Test(priority=4,dataProvider="getTestData") //data provider of this method is above method getTestData()
//		 public void selectDropDownValuesTest( String id,String value) throws InterruptedException, IOException
//		 {
//		
//			System.out.println("------------------------");
//
//			System.out.println(id);
//			System.out.println(value);
//			
//			Thread.sleep(9000);
//			//homepage.selectDropDownValues("HomeActRegCD_displayViewId", "Home Action Item - All");
//			homepage.selectDropDownValues(id,value); 
//			Thread.sleep(3000);
//		 }
//		
		
//		@Test(priority=4)
//		 public void selectDropDownValuesTest() throws InterruptedException, IOException
//		 {
//		
//			Thread.sleep(9000);
//			homepage.selectDropDownValues("HomeActRegCD_displayViewId", "Home Action Item - All"); 
//			Thread.sleep(3000);
//		 }
//		
		
		
		
//		@Test(priority=6)
//		 public void navigatetoprojectPageTest() throws InterruptedException, IOException
//		 {
//			projecthomepage= homepage.clickOnOptionAgainstProjrctNumber(3);
//			 
//			 System.out.println("this is ...");
//			 
//			 
//			 
//		 }
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	

}
