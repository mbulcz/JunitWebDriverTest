package com.mbul.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mbul.service.WebDriverService;
import com.mbul.util.PropertyReader;

public abstract class AbstractPage {

	protected WebDriverService wdService;
	protected WebDriver webDriver;
	protected final String MAIN_URL;
	protected String PAGE_URL;
	
	public AbstractPage(WebDriverService wdService) {
		MAIN_URL = PropertyReader.getSiteURL();
		this.wdService = wdService;
		this.webDriver = wdService.getWebDriver();
		PageFactory.initElements(webDriver, this);
	}
	
	public abstract void visitPage();

	public String getPageTitle() {
		return wdService.getWebDriver().getTitle();
	}

}
