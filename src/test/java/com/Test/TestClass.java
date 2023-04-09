package com.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.POM.LogInPage;
import com.Utility.Utility;



public class TestClass extends BaseClass {
     // Here we have done the WebDriver driver as globle so we can use it any where within the class
	 private WebDriver driver;
	// Here we have done the LogInPage login as globle so we can use it any where within the class
	private LogInPage login;
	private LogInPage logout;

	@BeforeTest
	@Parameters("Browser")
	public void openbrowser(String Browser) {
		if(Browser.equals("Chrome")) {
			driver = BaseClass.openchromebrowser();
		}else if(Browser.equals("Edge")) {
			driver = BaseClass.openedgebrowser();
		}else if(Browser.equals("FireFox")) {
			driver = BaseClass.openfirefoxbrowser();
		}


	}

	@BeforeClass
	public void hitURL() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void HitLogInPage() throws InterruptedException, EncryptedDocumentException, IOException {
	    login = new LogInPage(driver);
	    String UserID = Utility.GetDataFromExcel(3,2);
	    login.SendUserName(UserID);
		Thread.sleep(1000);
		
	    String UserPass = Utility.GetDataFromExcel(5,3);
        login.SendPassword(UserPass);
		Thread.sleep(1000);
		
		login.VerifyloginTab();
		Thread.sleep(1000);
	}
	@Test(priority = 1)
	public void clickOnBackPack() throws InterruptedException {
		LogInPage backpack = new LogInPage(driver);
		backpack.ClickOnBackPack();
		Thread.sleep(2000);
		String str = driver.getCurrentUrl();
		System.out.println(str);
	}
	@Test(priority = 2)
	public void ClickOnLabBolt() throws InterruptedException {
		LogInPage labbolt = new LogInPage(driver);
		labbolt.ClickOnLabBolt();
		Thread.sleep(1000);
		String str1 = driver.getCurrentUrl();
		System.out.println(str1);
		
	}
	@Test(priority = 3)
	public void ClickOnOneSie() throws InterruptedException {
		LogInPage OneSie = new LogInPage(driver);
		OneSie.ClickOnOneSie();
		Thread.sleep(1000);
		String str2 = driver.getCurrentUrl();
		System.out.println(str2);
	
	}
	@AfterMethod
	public void verifyloginpage(ITestResult result) throws IOException, InterruptedException {
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.TakesScreenShot(driver);
			}
	    logout = new LogInPage(driver);
		logout.ClickOnBackButton();
		Thread.sleep(1000);
		logout.ClickOnMenu();
		Thread.sleep(1000);
		logout.ClickOnlogout();
		Thread.sleep(1000);
		
	}

/*	@AfterClass
	public void logout() throws InterruptedException, IOException {
		LogInPage logout = new LogInPage(driver);
		logout.ClickOnBackButton();
		Thread.sleep(1000);
		logout.ClickOnMenu();
		Thread.sleep(1000);
		logout.ClickOnlogout();
		Thread.sleep(1000);*/
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
	

}
