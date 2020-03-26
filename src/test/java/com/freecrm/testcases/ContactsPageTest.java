package com.freecrm.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.project.base.TestBase;
import com.project.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;	
	TestUtil testUtil;
	
	
	public ContactsPageTest() {
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
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}
	
	
	@Test(priority=1,enabled=false)
	public void validateConatctLabel()
	{
		Boolean flag = contactsPage.validateContactLabel();
		try {
		Assert.assertTrue(flag);
		
		System.out.println("User is now on Contacts Page");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Contact lable is not verified-Made changes to existing code--"+e.getMessage());
		}

		System.out.println("Test Completed- This is new line added through master branch");

	}
	
	@Test(priority=2,enabled=false)
	public void selectSingleContact()
	{
		/*List<WebElement> checkBoxElements = driver.findElements(By.xpath("//*[@type='checkbox' and @name='contact_id']"));
		for (WebElement checkbox : checkBoxElements)
		{
			//checkbox.click();
			//checkbox.get
		}*/
		
		//driver.findElement(By.xpath("//a[text()='abc xyz']//parent::td//preceding-sibling::td//input")).click();
		//driver.findElement(By.xpath("//a[text()='Akash Ahlawat']//parent::td//preceding-sibling::td//input")).click();
		//driver.findElement(By.xpath("(//a[text()='Akash Ahlawat']//parent::td//preceding-sibling::td//input)[3]")).click();
		
		//boolean flag=driver.findElement(By.xpath("(//a[text()='Akash Ahlawat']//parent::td//preceding-sibling::td//input)[3]")).isSelected();

		
		boolean flag = contactsPage.selectContactName("Aaron Frank");
		
		try {
		Assert.assertTrue(flag);
		System.out.println("Checkbox selected as expected");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Checkbox is not selected as expected "+e.getMessage());
		}
		
	}
	
	@Test(priority=3,enabled=false)
	public void selectMultipleContact()
	{
		boolean flag = contactsPage.selectContactName("Aaron Frank");
		boolean flag1 = contactsPage.selectContactName("Aakash Maheshwari");
		
		//boolean flag=driver.findElement(By.xpath("(//a[text()='Akash Ahlawat']//parent::td//preceding-sibling::td//input)[3]")).isSelected();
		try {
		Assert.assertTrue(flag);
		Assert.assertTrue(flag1);
		System.out.println("Multiple Checkbox selected as expected");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Multiple Checkbox is not selected as expected "+e.getMessage());
		}
		
	}
	
		
	@Test(priority=4,enabled=true)
	public void selectContactNameWebTable()
	{
		Boolean flag = contactsPage.selectContactNameWebTable("Aakash Maheshwari");
		try {
			Assert.assertTrue(flag);
			
			System.out.println("contactName selected using webtable concept as expected");
			} catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("contactName not selected using webtable concept as expected "+e.getMessage());
			}
	}
	
	@Test(priority=5,enabled=false)
	public void selectContact() throws InterruptedException
	{
		
		//*[@id='vContactsForm']/table/tbody/tr[10]/td[2]/a
		
		//List<WebElement> contactListRow= driver.findElements(By.xpath("//*[@id='vContactsForm']/table/tbody/tr"));
		//int rowCnt = contactListRow.size();
		//System.out.println(rowCnt);
		
		
		List<WebElement> pagination =driver.findElements(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[2]/td[1]/div//a")); 
		// checkif pagination link exists 

		System.out.println(pagination.size());	
		
		if(pagination.size()>0)
		{ 
		System.out.println("pagination exists"); 

		// click on pagination link 

			for(int i=0; i<pagination.size(); i++)
			{ 
				pagination.get(i).click(); 
				Thread.sleep(5000);
				
				
				/*if (driver.findElements(By.xpath("//a[text()='abc xyz']//parent::td//preceding-sibling::td//input")).size()>0)
				{
				//driver.findElement(By.xpath("//a[text()='Rohit Sharma']//parent::td//preceding-sibling::td//input")).click();
				driver.findElement(By.xpath("//a[text()='kapil Wagh]//parent::td//preceding-sibling::td//input")).click();
				System.out.println("Clicked");
				break;
				}*/
				
				/*System.out.println("loop "+i);
				if(i==6)
				{
					//driver.findElement(By.xpath("//a[text()='jt kk']//parent::td//preceding-sibling::td//input")).click();
					break;
				}
				*/
				
			} 
		} 
		else 
		{ 
			System.out.println("pagination do not exists");  
		} 
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
}
