package com.linkedin1.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin1.qa.util.TestUtil;

public class TestBase {
//Hello
	//How are you
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis = null;
	public static WebDriverWait wait;


	public TestBase() {

		try {
			prop = new Properties();
			fis = new FileInputStream("C:\\Users\\sheth\\Mylocalgit\\LinkedinTest1\\src\\main\\java\\com\\linkedin1\\qa\\config\\cofig.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//sheth//Downloads//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\sheth\\Downloads\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver,TestUtil.EXPLICIT_WAIT);

	}
}