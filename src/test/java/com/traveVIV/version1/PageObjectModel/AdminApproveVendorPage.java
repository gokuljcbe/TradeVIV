package com.traveVIV.version1.PageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminApproveVendorPage {

	WebDriver driver;

	public AdminApproveVendorPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//nav[@id='sidebar']//ul//li[3]//a[@href='#vendor']")
	public static WebElement vendors;

	@FindBy(xpath = "//span[contains(text(),'VENDOR SELF REGISTRATION')]")
	public static WebElement vendorSelfRegistration;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	public static WebElement search;

	@FindBy(xpath = "//*[@id='geniustable']/tbody/tr[1]/td[2]")
	public static WebElement vendorName;

	@FindBy(xpath = "//span[@class='current'][contains(text(),'Deactivated')]")
	public static WebElement status;
	
	@FindBy(xpath="//li[@class='option'][contains(text(),'Activated')]")
	public static WebElement activatedButton;

	@FindBy(xpath = "//a[@class='btn btn-success btn-ok']")
	public static WebElement updateButton;

	@FindBy(xpath = "//p[@class='text-left']")
	public static WebElement updateSuccess;
	
	
	public void approveVendor() throws IOException {
		
		
		List<String> vendorDetails = VendorBaseClass.readExcel("Vendor SignUp Details");
		
		String name = vendorDetails.get(0);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		Actions action = new Actions(driver);
		action.moveToElement(vendors).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'VENDOR SELF REGISTRATION')]")));
	
		action.moveToElement(vendorSelfRegistration).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']")));
		
		search.sendKeys(name + Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='geniustable']/tbody/tr[1]/td[2]")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		action.moveToElement(vendorName).build().perform();
		
		if(vendorName.getText().equals(name)) {
			
			
			action.moveToElement(status).click().build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='option'][contains(text(),'Activated')]")));
			
			activatedButton.click();
		}
		
		updateButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-left']")));
	}
	
	public boolean approvalSuccess() {
		
		boolean successUpdate = updateSuccess.isDisplayed();
		return successUpdate;
	
	}
}
