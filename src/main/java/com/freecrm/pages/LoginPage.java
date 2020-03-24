package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.TestBase;

public class LoginPage extends TestBase{

	//constructor- Initializing page objects
	public LoginPage()
	{
		//this.driver=driver;  ----This is not needed here because we are extending TestBase class and using driver from there
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory -OR
	
	@FindBy(name="username") WebElement userName;
	
	@FindBy(name="password") WebElement userPass;
	
	@FindBy(xpath="//input[@type='submit']") WebElement loginBtn;
	
	@FindBy(linkText="Sign Up") WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]") WebElement crmLogo;
	
	
	//Actions/Methods
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage loginToApp(String fuserName, String fuserPass) throws InterruptedException
	{
		userName.sendKeys(fuserName);
		userPass.sendKeys(fuserPass);
		Thread.sleep(5000);
		loginBtn.click();	
		
		//after clicking on login button, next page is HomePage so here HomePage is called as landing page.
		return new HomePage();  
	}
}
