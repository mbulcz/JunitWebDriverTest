package com.mbul.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mbul.service.WebDriverService;

public class HomePage extends AbstractPage {

	@FindBy(xpath = "//a[text()='Dropdown']")
	private WebElement dropdownLink;
	
	public HomePage(WebDriverService wdService) {
		super(wdService);
		PAGE_URL = MAIN_URL;
	}
	
	public DropDownPage goToDropDownPage() {
		wdService.waitUntilClickable(dropdownLink).click();
		return new DropDownPage(wdService);
	}
	
	public void visitPage() {
		webDriver.get(PAGE_URL);
	}
	
	
}
