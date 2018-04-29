package com.linkedin1.qa.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin1.qa.base.TestBase;
import com.linkedin1.qa.pages.HomePage;
import com.linkedin1.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals("LinkedIn: Log In or Sign Up", loginpage.getLoginPageTitle());
	}

	@Test(priority = 2)
	public void verifyLoginPageLogo() {
		Assert.assertEquals(true, loginpage.verifyLinkedInLogo());
	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		wait.until(ExpectedConditions.titleContains("LinkedIn"));
	}
}
