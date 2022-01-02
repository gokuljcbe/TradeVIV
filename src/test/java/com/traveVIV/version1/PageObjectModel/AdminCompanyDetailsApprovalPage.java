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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCompanyDetailsApprovalPage {

	WebDriver driver;

	public AdminCompanyDetailsApprovalPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//nav[@id='sidebar']//ul//li[3]//a[@href='#vendor']")
	public static WebElement vendors;

	@FindBy(xpath = "//span[contains(text(),'Approve VENDOR')]")
	public static WebElement approveVendor;

	@FindBy(xpath = "//input[@type='search']")
	public static WebElement search;

	@FindBy(xpath = "//*[@id='geniustable']/tbody/tr[1]/td[3]")
	public static WebElement vendorName;

	@FindBy(xpath = "//div[@class='godropdown']//button//i")
	public static WebElement status;

	@FindBy(xpath = "//*[@id='geniustable']/tbody/tr/td[5]/div/div/a[3]")
	public static WebElement companyEdit;

	@FindBy(xpath = "//select[@name='vendor_status']")
	public static WebElement approvalStatus;

	@FindBy(xpath = "//button[@class='addProductSubmit-btn']")
	public static WebElement submitButton;
	
	@FindBy(xpath = "//span[contains(text(),'Vendor Details were Updated Successfully')]")
	public static WebElement approveSuccessful;

	public boolean companyDetailsApproval() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);

		action.moveToElement(vendors).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approve VENDOR')]")));
		action.moveToElement(approveVendor).click().build().perform();

		List<String> approveVendor = VendorBaseClass.readExcel("Vendor SignUp Details");

		String name = approveVendor.get(0);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		action.moveToElement(search).click().sendKeys(name + Keys.ENTER).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='godropdown']//button//i")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		action.moveToElement(status).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='geniustable']/tbody/tr/td[5]/div/div/a[3]")));
		action.moveToElement(companyEdit).click().build().perform();
		
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.PAGE_DOWN);

		Select select = new Select(approvalStatus);
		select.selectByVisibleText("Approved");
		
		boolean submit = submitButton.isDisplayed();
		
		action.moveToElement(submitButton).click().build().perform();
		return submit;

	}	

}
