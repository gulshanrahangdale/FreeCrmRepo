package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		loginPage=new LoginPage();
		}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String loginpgtitle=loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(loginpgtitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImgTest(){
		boolean flag=loginPage.ValidateCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest(){
		homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
		}
	
	
	
	
	

}
