package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveVIV.version1.PageObjectModel.VendorAddProductsPage;
import com.traveVIV.version1.PageObjectModel.VendorBaseClass;
import com.traveVIV.version1.PageObjectModel.VendorLoginPage;

public class VendorAddProductsTest extends VendorBaseClass {

	@Test (priority=1)
	public void vendorLoginApp() {
		
		VendorLoginPage vendorLoginPage = PageFactory.initElements(driver, VendorLoginPage.class);
		System.out.println("Vendor Login started");
		vendorLoginPage.vendorLogin(vendorUsername, vendorPassword);
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(vendorLoginPage.loginSuccessful(), true);
		assertion.assertAll();
		System.out.println("Vendor Logged in successfully");
	}

	@Test (priority=2)
	public void vendorAddProductsApp() throws InterruptedException, IOException {
		
		VendorAddProductsPage vendorAddProductsPage = PageFactory.initElements(driver, VendorAddProductsPage.class);
		System.out.println("Vendor started adding products");
		vendorAddProductsPage.addProducts();
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(vendorAddProductsPage.addProductSuccessful(), true);
		assertion.assertAll();
		System.out.println("Vendor added product successfully");
	}
}
