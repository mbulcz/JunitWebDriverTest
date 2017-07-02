package com.mbul.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebDriverService {

	public WebDriver getWebDriver();

	public String getCurrentUrl();
	
	public WebElement waitUntilClickable(WebElement webElement);
	
	
}

