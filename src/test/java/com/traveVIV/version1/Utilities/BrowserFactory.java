package com.traveVIV.version1.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	{
		
		if(browserName.equals("Chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver = new ChromeDriver();
		
		}
		
		else if(browserName.equals("Firefox")) {
		
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			driver = new FirefoxDriver();
		
		}
		
		else {
			System.out.println("We do support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static WebDriver waitForElementToLoad(WebDriver driver, String element)
	{
			WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	        return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
