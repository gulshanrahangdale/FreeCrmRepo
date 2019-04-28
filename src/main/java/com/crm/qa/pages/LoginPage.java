package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository
	
	


	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[@type='button' and @class='btn']")
	WebElement SignupBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement CrmLogo;
	
	
	//Initialzing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions	
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean ValidateCrmLogo(){
		return CrmLogo.isDisplayed();
	}
	public HomePage login(String un, String pw){
		username.sendKeys(un);
		password.sendKeys(pw);
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", LoginBtn);
		//LoginBtn.click();
		
		return new HomePage();
	}

}
 