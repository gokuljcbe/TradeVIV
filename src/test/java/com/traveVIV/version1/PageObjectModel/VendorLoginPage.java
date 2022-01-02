package com.traveVIV.version1.PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorLoginPage {
	
	WebDriver driver;

	public VendorLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//span[contains(text(),'Accounts & Lists')]")
	public static WebElement accountsAndList;
	
	@FindBy(xpath="//a[@class='sign-in-btn']")
	public static WebElement SignUp;
	
	@FindBy(xpath="//a[@id='nav-reg-tab11']")
	public static WebElement vendorRegistration;
	
	@FindBy(xpath="//a[@id='nav-log-tab11']")
	public static WebElement vendorLogin;
	
	@FindBy(xpath="//a[@id='show-forgot1']//parent::div//parent::div//parent::form//div[1][@class='form-input']//input")
	public static WebElement userId;

	@FindBy(xpath="//a[@id='show-forgot1']//parent::div//parent::div//parent::form//div[2][@class='form-input']//input")
	public static WebElement password;
	
	@FindBy(xpath="//button[@class='submit-btn'][contains(text(),'Login')]")
	public static WebElement loginButton;
	
	@FindBy(xpath="//div[@class='user-img']")
	public static WebElement loginSuccessful;
	
	public void vendorLogin(String username, String passWord) {
		
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Accounts & Lists')]")));
		action.moveToElement(accountsAndList).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='sign-in-btn']")));
		action.moveToElement(SignUp).click().build().perform();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-log-tab11']")));
		
		action.moveToElement(vendorLogin).click().build().perform();
		action.moveToElement(userId).click();
		
		userId.sendKeys(username + Keys.TAB);
		
		password.sendKeys(passWord + Keys.ENTER);
		
	}
	
	public boolean loginSuccessful() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-img']")));
		
		boolean successfulLogin = loginSuccessful.isDisplayed();
		
		return successfulLogin;
	}
}
