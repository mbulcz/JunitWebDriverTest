package com.mbul.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mbul.factory.WebDriverFactory;
import com.mbul.service.WebDriverService;
import com.mbul.util.PropertyReader;

public class BaseWebDriverService implements WebDriverService {
	
	private final WebDriver webDriver;
	
	public BaseWebDriverService() {
		webDriver = WebDriverFactory.getWebDriver(PropertyReader.getBrowserType());
	}
	
	@Override
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
	
	@Override
	public String getCurrentUrl() {
		return this.webDriver.getCurrentUrl();
	}
	
	@Override
	public WebElement waitUntilClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, Integer.valueOf(PropertyReader.getElementWaitTimeout()));
		return wait.until(ExpectedConditions.visibilityOf(webElement));
	}

}
