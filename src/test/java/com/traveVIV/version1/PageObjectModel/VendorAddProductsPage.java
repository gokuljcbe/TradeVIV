package com.traveVIV.version1.PageObjectModel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traveVIV.version1.Utilities.UploadFile;

public class VendorAddProductsPage {

	WebDriver driver;

	public VendorAddProductsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//nav[@id='sidebar']//ul//li//a[@href='#menu2']")
	public static WebElement products;
	
	@FindBy(xpath = "//a[@href='http://www.tradeviv.com/vendor/products/create']")
	public static WebElement addProducts;
	
	@FindBy(xpath = "//input[@placeholder='Product Name']")
	public static WebElement productName;

	@FindBy(xpath = "//select[@name='category_id']")
	public static WebElement catergory;

	@FindBy(xpath = "//select[@name='subcategory_id']")
	public static WebElement subCategory;

	@FindBy(xpath = "//select[@name='childcategory_id']")
	public static WebElement childCategory;

	@FindBy(xpath = "//select[@name='location']")
	public static WebElement location;

	@FindBy(xpath = "//input[@name='p_f_num[]']")
	public static WebElement productFeatureSno;

	@FindBy(xpath = "//input[@name='p_f_spec[]']")
	public static WebElement productFeatureSpecification;

	@FindBy(xpath = "//input[@name='p_f_value[]']")
	public static WebElement productFeatureValue;

	@FindBy(xpath = "//input[@placeholder='Product Name']//parent::div//parent::div//parent::div//div[10]//div[2]//div//div[2]")
	public static WebElement productDescription;

	@FindBy(xpath = "//input[@name='price']")
	public static WebElement pricePerProduct;

	@FindBy(xpath = "//select[@name='measurement_system']")
	public static WebElement measurementSystem;

	@FindBy(xpath = "//input[@name='p_v_qty[]']")
	public static WebElement priceVarientQty;

	@FindBy(xpath = "//input[@name='p_v_price[]']")
	public static WebElement priceVarientPrice;

	@FindBy(xpath = "//input[@name='p_v_measurement[]']")
	public static WebElement priceVarientMeasurement;

	@FindBy(xpath = "//input[@name='availablity']")
	public static WebElement productAvailability;

	@FindBy(xpath = "//input[@id='shipping_desc_byroad']")
	public static WebElement shippingDescriptionByRoad;

	@FindBy(xpath = "//input[@id='shipping_desc_bytrain']")
	public static WebElement shippingDescriptionByTrain;

	@FindBy(xpath = "//input[@id='shipping_desc_air']")
	public static WebElement shippingDescriptionByAir;

	@FindBy(xpath = "//input[@name='d_t_qty[]']")
	public static WebElement abilityAndEstimateDeliveryTimeQty;

	@FindBy(xpath = "//input[@name='d_t_estimate_days[]']")
	public static WebElement abilityAndEstimateDeliveryTimeEstimateDays;

	@FindBy(xpath = "//input[@placeholder='Product Name']//parent::div//parent::div//parent::div//div[16]//div//div//a")
	public static WebElement abilityAndEstimateDeliveryAddMoreFields;

	@FindBy(xpath = "//label[contains(text(),'Yes')]//parent::div//input[1]")
	public static WebElement virtualShopVisitRadioButtonYes;

	@FindBy(xpath = "//input[@id='p_video']")
	public static WebElement productVideo;

	@FindBy(xpath = "//input[@id='p_certificate']")
	public static WebElement productCertification;

	@FindBy(xpath = "//input[@id='image-upload']")
	public static WebElement productImage;

	@FindBy(xpath = "//input[@class='set-gallery']")
	public static WebElement productSetGallery;

	@FindBy(xpath = "//label[@id='prod_gallery']")
	public static WebElement productGallery;
	
	@FindBy(xpath = "//a[@class='upload-done']")
	public static WebElement productGalleryDone;
	
	@FindBy(xpath = "//input[@id='image-upload-p_p_photo']")
	public static WebElement productPackageImages;

	@FindBy(xpath = "//input[@id='image-upload-p_t_photo']")
	public static WebElement productTransportationImages;

	@FindBy(xpath = "//ul[@id='tags']//li//input[@class='ui-widget-content ui-autocomplete-input']")
	public static WebElement productTags;

	@FindBy(xpath = "//button[@class='addProductSubmit-btn']")
	public static WebElement createProductButton;
	
	@FindBy(xpath = "//p[contains(text(),'New Product Added Successfully.')]")
	public static WebElement productAddedSuccessfully;
	
	public void addProducts() throws InterruptedException, IOException {
		
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		List<String> productDetails = VendorBaseClass.readExcel("Vendor Add Product Details");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='sidebar']//ul//li//a[@href='#menu2']")));
		action.moveToElement(products).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://www.tradeviv.com/vendor/products/create']")));
		action.moveToElement(addProducts).click().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Product Name']")));
		action.moveToElement(productName).click().sendKeys(productDetails.get(0)).build().perform();
		
		Select select1 = new Select(catergory);
		select1.selectByVisibleText(productDetails.get(1));
		
		Select select2 = new Select(subCategory);
		select2.selectByVisibleText(productDetails.get(2));
		
		Select select3 = new Select(childCategory);
		select3.selectByVisibleText(productDetails.get(3));
		
		Select select4 = new Select(location);
		select4.selectByVisibleText(productDetails.get(4));
		
		productFeatureSno.sendKeys(productDetails.get(5));
		
		productFeatureSpecification.sendKeys(productDetails.get(6));
		
		productFeatureValue.sendKeys(productDetails.get(7));
		
		pricePerProduct.sendKeys(productDetails.get(8));
		
		Select select5 = new Select(measurementSystem);
		select5.selectByVisibleText(productDetails.get(9));
		
		priceVarientQty.sendKeys(productDetails.get(10));
		
		priceVarientPrice.sendKeys(productDetails.get(11));
		
		priceVarientMeasurement.sendKeys(productDetails.get(12));
		
		productAvailability.sendKeys(productDetails.get(13));
		
		shippingDescriptionByRoad.click();
		
		shippingDescriptionByTrain.click();
		
		shippingDescriptionByAir.click();
		
		abilityAndEstimateDeliveryTimeQty.sendKeys(productDetails.get(14));
		
		abilityAndEstimateDeliveryTimeEstimateDays.sendKeys(productDetails.get(15));
		
		virtualShopVisitRadioButtonYes.click();
		
		upload(productDetails.get(16), productVideo);
		
		upload(productDetails.get(17), productCertification);
		
		upload(productDetails.get(18), productImage);
		
		upload(productDetails.get(19), productPackageImages);
		
		upload(productDetails.get(20), productTransportationImages);
		
		productTags.sendKeys(productDetails.get(21));
		
		action.moveToElement(createProductButton).click().build().perform();
	}
	
	
	public boolean addProductSuccessful() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'New Product Added Successfully.')]")));
		
		boolean addProductSuccessful = productAddedSuccessfully.isDisplayed();
		return addProductSuccessful;
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
