package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.traveVIV.version1.PageObjectModel.SearchingAddedProductPage;
import com.traveVIV.version1.PageObjectModel.VendorBaseClass;

public class SearchingAddedProductTest extends VendorBaseClass {

	@Test
	public void searchProductApp() throws IOException {
		
		SearchingAddedProductPage searchingAddedProductPage = PageFactory.initElements(driver, SearchingAddedProductPage.class);
		System.out.println("Searching for the Product");
		searchingAddedProductPage.searchForProduct();
		System.out.println("Product displayed Successfully");
		
	}
	
}
