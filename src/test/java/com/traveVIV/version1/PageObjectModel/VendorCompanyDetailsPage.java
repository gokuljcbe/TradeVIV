package com.traveVIV.version1.PageObjectModel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traveVIV.version1.Utilities.UploadFile;

public class VendorCompanyDetailsPage {

	WebDriver driver;

	public VendorCompanyDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//nav//ul//li[3]//a[@href='http://www.tradeviv.com/vendor/companydetails']")
	public static WebElement companyDetails;
	
	@FindBy(css="div.page:nth-child(1) div.page-main div.wrapper div.content-area div.add-product-content1 div.row div.col-lg-12 div.product-description div.body-area form:nth-child(3) div.row:nth-child(2) div.col-lg-7 div:nth-child(2) > div.nicEdit-main")
	public static WebElement shopDetails;
	
	@FindBy(xpath="//input[@placeholder='Company Name']")
	public static WebElement companyName;
	
	@FindBy(xpath="//input[@placeholder='Company Proprietor Name']")
	public static WebElement companyProprietorName;
	
	@FindBy(xpath="//input[@placeholder='Total. No. of Employees']")
	public static WebElement totalNoOfEmployees;
	
	@FindBy(xpath="//select[@name='category']")
	public static WebElement category;
	
	@FindBy(xpath="//input[@placeholder='Year Of Establishment']")
	public static WebElement yearOfEstablishment;
	
	@FindBy(xpath="//input[@placeholder='Legal Status of the Firm']")
	public static WebElement legalStatusOfTheFirm;
	
	@FindBy(xpath="//input[@placeholder='G.S.T Number']")
	public static WebElement gstNumber;
	
	@FindBy(xpath="//input[@placeholder='PAN Number']")
	public static WebElement panNumber;
	
	@FindBy(xpath="//input[@placeholder='CIN Number']")
	public static WebElement cinNumber;
	
	@FindBy(xpath="//input[@placeholder='Total Annual Revenue']")
	public static WebElement totalAnnualRevenue;
	
	@FindBy(xpath="//input[@name='cemail']")
	public static WebElement companyEmail;
	
	@FindBy(xpath="//input[@name='cmobile']")
	public static WebElement companyMobile;
	
	@FindBy(xpath="//input[@name='clandline']")
	public static WebElement companyLandline;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/form/div[15]/div[2]/div[2]/div/table/tbody/tr/td")
	public static WebElement companyAddress;
	
	@FindBy(xpath="//input[@id='file_cc']")
	public static WebElement companyCerification;
	
	@FindBy(xpath="//input[@name='file_pc']")
	public static WebElement productCertification;
	
	@FindBy(xpath="//input[@name='file_cv']")
	public static WebElement companyVideos;
	
	@FindBy(xpath="//input[@name='file_cp']")
	public static WebElement companyPhotos;
	
	@FindBy(xpath=" //input[@class='img-upload-p']")
	public static WebElement logoImageUpload;
	
	@FindBy(xpath="//button[@class='addProductSubmit-btn']")
	public static WebElement submitButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	public static WebElement companyDetailsUpdateSuccessful;
	
	public void enteringCompanyDetails() throws IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//ul//li[3]//a[@href='http://www.tradeviv.com/vendor/companydetails']")));
		
		companyDetails.click();
		
		List<String> companyDetailsList = VendorBaseClass.readExcel("Vendor Company Details");

		Actions action = new Actions(driver);
		
		action.moveToElement(shopDetails).sendKeys(companyDetailsList.get(0));
		
		companyName.clear();
		companyName.sendKeys(companyDetailsList.get(1));
		
		companyProprietorName.clear();
		companyProprietorName.sendKeys(companyDetailsList.get(2));
		
		totalNoOfEmployees.clear();
		totalNoOfEmployees.sendKeys(companyDetailsList.get(3));
		
		Select select = new Select(category);
		select.selectByValue(companyDetailsList.get(4));
		
		yearOfEstablishment.clear();
		yearOfEstablishment.sendKeys(companyDetailsList.get(5));
		
		legalStatusOfTheFirm.clear();
		legalStatusOfTheFirm.sendKeys(companyDetailsList.get(6));
		
		gstNumber.clear();
		gstNumber.sendKeys(companyDetailsList.get(7));
		
		panNumber.clear();
		panNumber.sendKeys(companyDetailsList.get(8));
		
		cinNumber.clear();
		cinNumber.sendKeys(companyDetailsList.get(9));
		
		totalAnnualRevenue.clear();
		totalAnnualRevenue.sendKeys(companyDetailsList.get(10));
		
		companyEmail.clear();
		companyEmail.sendKeys(companyDetailsList.get(11));
		
		companyMobile.clear();
		companyMobile.sendKeys(companyDetailsList.get(12));
		
		companyLandline.sendKeys(companyDetailsList.get(13) + Keys.TAB);
		
	
		upload(companyDetailsList.get(15), companyCerification);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		upload(companyDetailsList.get(16), productCertification);
		
		upload(companyDetailsList.get(17), companyVideos);
		
		upload(companyDetailsList.get(18), companyPhotos);
				
		upload(companyDetailsList.get(19), logoImageUpload);
		
		submitButton.click();
	}
	
	public boolean entrySuccessful() {
		
		boolean entrySuccessful = companyDetailsUpdateSuccessful.isDisplayed();
		return entrySuccessful;
		
	}
	
	public void upload(String path, WebElement upload) {
		UploadFile uploadFile = PageFactory.initElements(driver, UploadFile.class);
		Actions action = new Actions(driver);
		action.moveToElement(upload).click().build().perform();	
		uploadFile.uploadFile(path);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
