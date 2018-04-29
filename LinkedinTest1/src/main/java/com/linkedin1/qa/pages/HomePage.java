package com.linkedin1.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.linkedin1.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
