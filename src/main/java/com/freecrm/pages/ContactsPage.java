package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.TestBase;

public class ContactsPage extends TestBase {
	
	//constructor- Initializing page objects
	public ContactsPage()
	{
		//this.driver=driver;  ----This is not needed here because we are extending TestBase class and using driver from there
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory -OR
	
	@FindBy(xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]") WebElement contactsLabel;
	
	
	
	
	//Actions
	public boolean validateContactLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public boolean selectContactName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input")).click();
		boolean flag = driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input")).isSelected();
		return flag;
	}
	
	public boolean selectContactNameWebTable(String contactName)
	{
		//*[@id='vContactsForm']/table/tbody/tr[15]/td[2]/a
		
				String  beforeXpath = "//*[@id='vContactsForm']/table/tbody/tr[";
				String afterXpath = "]/td[2]/a";
				Boolean flag = false;
				
				//Checking value between row 4 and 24 only. We can get the row size and col size and use
				for (int row = 4;row<=24; row++)
				{
					String name = driver.findElement(By.xpath(beforeXpath+row+afterXpath)).getText();
					//System.out.println(name);
					if (name.equalsIgnoreCase(contactName))
					{
						driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+row+"]/td[1]/input")).click();

						flag = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+row+"]/td[1]/input")).isSelected();
						return flag;
					}
					
					
				}
				return flag;
	}
	
}
