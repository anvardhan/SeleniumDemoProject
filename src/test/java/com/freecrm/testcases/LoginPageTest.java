package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.project.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super(); //This will call constructor of superclass -TestBase to initialize properties and read properties file
	}
	
	@BeforeMethod
	public void setUp()
	{
		openBrowser();
		navigateToApp();
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest()
	{
		try {
		String actualTitle = loginPage.loginPageTitle();
		Assert.assertEquals(actualTitle, "Free CRM software in the cloud powers sales and customer service");
		System.out.println("loginPageTitle is validated and its as expected ");
		} catch (Error e)
		{
			e.printStackTrace();
			System.out.println("Error in loginPageTitleTest: "+e.getMessage());
		}
	}
	
	@Test (priority=2)
	public void crmLogoImageTest()
	{
		try {
		Boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		System.out.println("crmLogoImageTest is validated and its as expected ");
		} catch (Error e)
		{
			e.printStackTrace();
			System.out.println("Error in crmLogoImageTest: "+e.getMessage());
		}
	}
	
	@Test (priority=3)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
		//Write validation code below
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}


}
