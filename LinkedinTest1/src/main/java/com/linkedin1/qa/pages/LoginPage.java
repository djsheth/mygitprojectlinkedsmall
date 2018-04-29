package com.linkedin1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin1.qa.base.TestBase;

public class LoginPage extends TestBase {
	
@FindBy(id="login-email")
WebElement useremail;

@FindBy(id="login-password")
WebElement password;

@FindBy(id="login-submit")
WebElement loginbtn;

@FindBy(xpath="//img[@class='lazy-loaded']")
WebElement linkedinlogo;

public LoginPage() {
	PageFactory.initElements(driver, this);
}
public String getLoginPageTitle() {
	return driver.getTitle();
}

public boolean verifyLinkedInLogo() {
	return linkedinlogo.isDisplayed();
}
public HomePage login(String uname, String pword) {
	useremail.sendKeys(uname);
	password.sendKeys(pword);
	loginbtn.click();
	return new HomePage();
}

}
