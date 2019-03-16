package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	//Initializing the page objects
	public ContactPage(){
		PageFactory.initElements(driver, this);		
	}
	 
	public boolean verifycontactLabel(){
		return contactsLabel.isDisplayed();
	}
	
	//dynamic xpath for selecting contact
	public void selectContactByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	

}
