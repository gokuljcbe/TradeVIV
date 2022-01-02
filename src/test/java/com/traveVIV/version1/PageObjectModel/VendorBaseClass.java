package com.traveVIV.version1.PageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.traveVIV.version1.Utilities.BrowserFactory;
import com.traveVIV.version1.Utilities.ReadConfig;

public class VendorBaseClass {
	
	static ReadConfig readConfig = new ReadConfig();
	
	public WebDriver driver;
	public static String adminURL = readConfig.getAdminURL();
	public static String vendorURL = readConfig.getVendorURL();
	
	public static String adminUsername = readConfig.getAdminUsername();
	public static String adminPassword = readConfig.getAdminPassword();
	
	public static String vendorUsername = readConfig.getVendorUsername();
	public static String vendorPassword = readConfig.getVendorPassword();
	
	
	public static List<String> readExcel(String industry) throws IOException {
		
		FileInputStream file = new FileInputStream("./Configuration/DataSheet.xlsx");
		
		List<String> data = new ArrayList<String>();
		XSSFWorkbook alaigalWorkbook = null;
		XSSFSheet alaigalSheet = null;
		
		try {
			alaigalWorkbook = new XSSFWorkbook(file);
			alaigalSheet = alaigalWorkbook.getSheet(industry);

			int totalRows = alaigalSheet.getLastRowNum();
			
			for(int init=1;init<=totalRows;init++) {
				Row alaigalRow = alaigalSheet.getRow(init);
				data.add(alaigalRow.getCell(0).getStringCellValue());
			}
		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		file.close();
		return data;
	}
	
	@BeforeClass
	public void VendorSetUp() {
		driver = BrowserFactory.startApplication(driver, "Chrome", vendorURL);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
}
