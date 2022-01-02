package com.traveVIV.version1.TestCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveVIV.version1.PageObjectModel.VendorBaseClass;
import com.traveVIV.version1.PageObjectModel.VendorSignupPageObjects;

public class VendorSignUpTest extends VendorBaseClass {
	
	@Test
	public void VendorSignUpApp() throws IOException {
		
		VendorSignupPageObjects vendorSignUpPageObjects = PageFactory.initElements(driver, VendorSignupPageObjects.class);
		System.out.println("Vendor SignUp Started");
		vendorSignUpPageObjects.vendorSignUp();
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(vendorSignUpPageObjects.signUpSuccessful(), true);
		System.out.println("Vendor SignUp Successful");
		assertion.assertAll();
	}

}
