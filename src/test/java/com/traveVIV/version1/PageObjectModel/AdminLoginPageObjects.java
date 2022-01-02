package com.traveVIV.version1.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPageObjects {
	
	WebDriver driver;
	
	public AdminLoginPageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath="//input[@class='User Name']")
	public static WebElement adminUsername;
	
	@FindBy(xpath="//input[@class='Password']")
	public static WebElement adminPassword;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	public static WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='user-img']")
	public static WebElement successLogin;
	
	String successLoginLocator = "\"//div[@class='user-img']\"";
	
	public void login(String username, String password) {
		adminUsername.sendKeys(username);
		adminPassword.sendKeys(password + Keys.ENTER);
	}
	
	public boolean loginSuccessful() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-img']")));
		
		boolean loginVerification = successLogin.isDisplayed();
		return loginVerification;
		
	}
	
}
