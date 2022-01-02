package com.traveVIV.version1.PageObjectModel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorSignupPageObjects {
	
	WebDriver driver;

	public VendorSignupPageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//span[contains(text(),'Accounts & Lists')]")
	public static WebElement accountsAndList;
	
	@FindBy(xpath="//a[@class='sign-in-btn']")
	public static WebElement SignUp;
	
	@FindBy(xpath="//a[@id='nav-reg-tab11']")
	public static WebElement vendorRegistration;
	
	@FindBy(xpath="//input[@placeholder='Vendor Name']")
	public static WebElement vendorName;
	
	@FindBy(xpath="//input[@placeholder='Company E-mail']")
	public static WebElement vendorEmail;
	
	@FindBy(xpath="//input[@placeholder='Vendor Phone number']")
	public static WebElement vendorPhoneNumber;
	
	@FindBy(xpath="//input[@name='shop_name']")
	public static WebElement vendorCompanyName;
	
	@FindBy(xpath="//input[@placeholder='Vendor Name']//parent::div//parent::div//parent::div//button")
	public static WebElement registrationButton;
	
	@FindBy(xpath="//div[@id='nav-reg11']//div//div/div[2]//p")
	public static WebElement successfulSignUp;
	
	public void vendorSignUp() throws IOException {
		
		
		List<String> signUpDetails = VendorBaseClass.readExcel("Vendor SignUp Details");
		
		String name = signUpDetails.get(0);
		String email = signUpDetails.get(1);
		String phoneNumber = signUpDetails.get(2);
		String companyName = signUpDetails.get(3);
		
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Accounts & Lists')]")));
		
		action.moveToElement(accountsAndList).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='sign-in-btn']")));
		
		action.moveToElement(SignUp).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-reg-tab11']")));
		
		action.moveToElement(vendorRegistration).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Vendor Name']")));
		
		vendorName.sendKeys(name);
		
		vendorEmail.sendKeys(email);
		
		vendorPhoneNumber.sendKeys(phoneNumber);
		
		vendorCompanyName.sendKeys(companyName);
		
		registrationButton.click();
		
	}
	
	public boolean signUpSuccessful() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-reg11']//div//div/div[2]//p")));
		
        boolean signUpVerify = successfulSignUp.isDisplayed();
		
		return signUpVerify;
		
	}
	
}
