package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.TestBase;

public class HomePage extends TestBase{
	
	//constructor- Initializing page objects
		public HomePage()
		{
			//this.driver=driver;  ----This is not needed here because we are extending TestBase class and using driver from there
			PageFactory.initElements(driver, this);
		}
		
		//Page Factory -OR
		
		@FindBy(xpath="//*[contains(text(),'User: Naveen K')]") WebElement userNameLabel;
		
		@FindBy(xpath="//*[contains(text(),'Contacts')]") WebElement contactsLink;
		
		@FindBy(xpath="//*[contains(text(),'Deals')]") WebElement dealsLink;
		
		@FindBy(xpath="//*[contains(text(),'Task')]") WebElement taskLink;


		//Actions or Methods
		
		public String homePageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateUserNameLabel()
		{
			return userNameLabel.isDisplayed();
		}
		
		public ContactsPage clickContactsLink()
		{
			contactsLink.click();
			
			return new ContactsPage();  //Landing page after clicking contacts link
		}
		
		public DealsPage clickDealsLink()
		{
			dealsLink.click();
			
			return new DealsPage();  //Landing page after clicking deals link
		}
		
		public TaskPage clickTaskLink()
		{
			taskLink.click();
			
			return new TaskPage();  //Landing page after clicking task link
		}
		
		


}
