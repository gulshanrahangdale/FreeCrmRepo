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

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	//Tset cases should be independent
	//before every test case -- launch the browser and login
	//@test-- execute test case
	//@After each test case close the browser
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Homepage title not matched");
	}
	
	@Test(priority=2)
	public void verifUsernameTest(){
		testUtil.switchtoframe();
		boolean usernm=homepage.verifyusername();
		Assert.assertTrue(usernm);	
	}
	
	@Test(priority=3)
	public void verifyCotactLinkTest(){
		testUtil.switchtoframe();
		contactsPage=homepage.clickOnContactLink();
	}
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
		}
	

}
