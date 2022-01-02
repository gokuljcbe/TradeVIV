package com.traveVIV.version1.PageObjectModel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchingAddedProductPage {
	
	WebDriver driver;

	public SearchingAddedProductPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By searchBox = By.xpath("//input[@id='prod_name']");
	By addedProductdisplayed = By.xpath("//h5[@class='name']");
	
	
	public void searchForProduct() throws IOException {
		
		List<String> searchProduct = VendorBaseClass.readExcel("Search Product");
			
		driver.findElement(searchBox).sendKeys(searchProduct.get(0) +Keys.ENTER);
			
		driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		
		List<WebElement> productDisplayed = driver.findElements(addedProductdisplayed);
		
		for(WebElement displayProduct : productDisplayed) {
			displayProduct.getText().equals(searchProduct.get(1));
			break;
		}
	}
}
