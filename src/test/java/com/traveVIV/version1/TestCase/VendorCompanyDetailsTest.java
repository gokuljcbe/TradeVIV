package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveVIV.version1.PageObjectModel.VendorBaseClass;
import com.traveVIV.version1.PageObjectModel.VendorCompanyDetailsPage;
import com.traveVIV.version1.PageObjectModel.VendorLoginPage;

public class VendorCompanyDetailsTest extends VendorBaseClass {

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
	public void vendorCompanyDetailsApp() throws IOException {
		
		VendorCompanyDetailsPage vendorCompanyDetailsPage = PageFactory.initElements(driver, VendorCompanyDetailsPage.class);
		System.out.println("Vendor Started entering company details");
		vendorCompanyDetailsPage.enteringCompanyDetails();
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(vendorCompanyDetailsPage.entrySuccessful(), true);
		assertion.assertAll();
		System.out.println("Vendor entered company details succesfully");
		
	}
}
