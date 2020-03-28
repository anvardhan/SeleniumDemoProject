package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.DealsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.pages.TaskPage;
import com.project.base.TestBase;
import com.project.utilities.TestUtil;


public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TaskPage taskPage;
	TestUtil testUtil;
	
	
	public HomePageTest() {
		super(); //This will call constructor of superclass -TestBase to initialize properties and read properties file
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		openBrowser();
		navigateToApp();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test (priority=1,enabled=true)
	public void loginPageTitleTest()
	{
		try {
		String actualTitle = homePage.homePageTitle();
		Assert.assertEquals(actualTitle, "CRMPRO","Home Page Title is not as expected");
		System.out.println("homePageTitle is validated and its as expected ");
		} catch (Error e)
		{
			e.printStackTrace();
			System.out.println("Error in loginPageTitleTest: "+e.getMessage());
		}
	}
	
	@Test (priority=2,enabled=false)
	public void verifyCorrectUserName()
	{
		testUtil.switchToFrame();
		//Thread.sleep(5000);
		Boolean flag  = homePage.validateUserNameLabel();
		try {
		Assert.assertTrue(flag);
		System.out.println("UserName Label is validated and its as expected ");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("UserName Label is notasexpected: "+e.getMessage());
		}
	}
	
	@Test (priority=3, enabled=false)
	public void clickOnContactsLink()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
		//Write validation code below
		
	}
	
	@Test (priority=4, enabled=false)
	public void clickOnDealsLink()
	{
		testUtil.switchToFrame();
		dealsPage = homePage.clickDealsLink();
		//Write validation code below
		
	}
	
	@Test (priority=5, enabled=false)
	public void clickOnTaskLink()
	{
		testUtil.switchToFrame();
		taskPage = homePage.clickTaskLink();
		//Write validation code below
		
	}
	
	

	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	
}
