package com.mbul.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.mbul.factory.enums.BrowserType;

public class WebDriverFactory {

	private static final String GECKODRIVER_PATH = "c:/programs/geckodriver.exe";
	private static final String CHROMEDRIVER_PATH = "c:/programs/chromedriver.exe";
	
	public static WebDriver getWebDriver(String browserName) {
		
		WebDriver webDriver; 
		
		BrowserType browserType = BrowserType.valueOf(browserName);
		
		switch(browserType) {
			case FIREFOX:
				webDriver = createFfoxDriver();
				break;
			default:
			case CHROME:
				webDriver = createChromeDriver();
				break;
		}
		return webDriver;
	}
	
	private static WebDriver createFfoxDriver() {
		System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
		WebDriver driver = new FirefoxDriver();
		FirefoxProfile ffoxProf = new FirefoxProfile();
		ffoxProf.setAssumeUntrustedCertificateIssuer(false);
		return new FirefoxDriver(ffoxProf);
	}
	
	private static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
		return new ChromeDriver();
	}
	
}
