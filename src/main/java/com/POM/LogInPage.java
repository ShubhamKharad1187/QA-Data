package com.POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	WebDriver driver;

	@FindBy(name = "user-name")
	private  WebElement user;

	@FindBy(name = "password")
	private  WebElement pass;

	@FindBy(id = "login-button")
	private  WebElement log;
	
	@FindBy(id="back-to-products")
	private  WebElement BackButton;

	@FindBy(id = "react-burger-menu-btn")
	private  WebElement menu;

	@FindBy(linkText = "Logout")
	private  WebElement logout;
	
	@FindBy(linkText = "Sauce Labs Backpack")
	private  WebElement Backpack;
	
	@FindBy(linkText="Sauce Labs Bolt T-Shirt")
	private  WebElement labbolt;
	
	@FindBy(linkText="Sauce Labs Onesie")
	private  WebElement LabOneSie;

	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void SendUserName() {
		user.sendKeys("standard_user");
	}

	public void SendPassword() {
		pass.sendKeys("secret_sauce");
	}

	public void VerifyloginTab() {
		log.click();
	}
	public  void ClickOnBackButton() {
		BackButton.click();
	}

	public  void ClickOnMenu() {
		menu.click();

	}

	public void ClickOnlogout() {
		logout.click();

	}
	public void ClickOnBackPack() {
		Backpack.click();
	}
	public void ClickOnLabBolt() {
		labbolt.click();
	}
	public  void ClickOnOneSie() {
		LabOneSie.click();
	}
	
}
