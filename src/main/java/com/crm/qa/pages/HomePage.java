package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Gulshan')]")
	WebElement usernamelabel1;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactlink;
	
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement taskslink;
	
	//initializing the Page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	 
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyusername(){
		return usernamelabel1.isDisplayed();
	}
	
	public ContactPage clickOnContactLink(){
		contactlink.click();
		return new ContactPage();
	}
	
	public DealPage clickOnDealsLink(){
		dealslink.click();
		return new DealPage();
	}
	
	public TaskPage clickOnTaskLink(){
		taskslink.click();
		return new TaskPage();
	}
}
