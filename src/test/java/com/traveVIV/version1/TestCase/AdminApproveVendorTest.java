package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveVIV.version1.PageObjectModel.AdminApproveVendorPage;
import com.traveVIV.version1.PageObjectModel.AdminBaseClass;
import com.traveVIV.version1.PageObjectModel.AdminLoginPageObjects;

public class AdminApproveVendorTest extends AdminBaseClass {
	
	@Test (priority=1)
	public void loginApp() {
		
		AdminLoginPageObjects adminLoginPageObjects = PageFactory.initElements(driver, AdminLoginPageObjects.class);
		System.out.println("Admin Login Started");
		adminLoginPageObjects.login(adminUsername, adminPassword);
		
		SoftAssert assertion = new SoftAssert();
		AssertJUnit.assertEquals(adminLoginPageObjects.loginSuccessful(), true);
		System.out.println("Admin Login Successful");
		assertion.assertAll();
		
	}
	
	@Test (priority=2)
	public void approveVendorApp() throws IOException {
		
		AdminApproveVendorPage adminApproveVendorPage = PageFactory.initElements(driver, AdminApproveVendorPage.class);
		System.out.println("Vendor Approval Process started");
		adminApproveVendorPage.approveVendor();
		
		SoftAssert assertion = new SoftAssert();
		AssertJUnit.assertEquals(adminApproveVendorPage.approvalSuccess(),true);
		System.out.println("Vendor Approval Process successful");
		assertion.assertAll();
		
	}			

}
