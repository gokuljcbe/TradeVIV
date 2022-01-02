package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveVIV.version1.PageObjectModel.AdminBaseClass;
import com.traveVIV.version1.PageObjectModel.AdminCompanyDetailsApprovalPage;
import com.traveVIV.version1.PageObjectModel.AdminLoginPageObjects;

public class AdminCompanyDetailsApprovalTest  extends AdminBaseClass {

	@Test (priority=1)
	public void loginApp() {
		
		AdminLoginPageObjects adminLoginPageObjects = PageFactory.initElements(driver, AdminLoginPageObjects.class);
		System.out.println("Admin Login Started");
		adminLoginPageObjects.login(adminUsername, adminPassword);
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(adminLoginPageObjects.loginSuccessful(), true);
		System.out.println("Admin Login Successful");
		assertion.assertAll();
		
	}
	
	@Test (priority=2)
	public void companyDetailsApprovalApp() throws IOException, InterruptedException {
		
		AdminCompanyDetailsApprovalPage adminCompanyDetailsApprovalPage = PageFactory.initElements(driver, AdminCompanyDetailsApprovalPage.class);
		System.out.println("Company details approval status updating inprogress");
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(adminCompanyDetailsApprovalPage.companyDetailsApproval());
		System.out.println("Company details Approved Successsfully");
		assertion.assertAll();
		
	}
	
}
