package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactsPage;
	
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil =new TestUtil();
		homePage=new HomePage();
		loginPage= new LoginPage();
		contactsPage= new ContactPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchtoframe();
		contactsPage=homePage.clickOnContactLink();
	}
	@Test(priority=1)
	public void VerifyContactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifycontactLabel(),"Contact label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactByNameTest(){
		contactsPage.selectContactByName("test2 test2");
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
		}
	
}
