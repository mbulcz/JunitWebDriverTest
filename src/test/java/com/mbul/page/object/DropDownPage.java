package com.mbul.page.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mbul.service.WebDriverService;

public class DropDownPage extends AbstractPage {

	@FindBy(css = "select#dropdown")
	private WebElement dropDownList;
//	@FindBy(css = "select#dropdown > option[value='1']")
//	private WebElement dropDownFirstOption;
	
	private By dropDownFirstOption = new By.ByCssSelector("*[value='1']");
	
	public DropDownPage(WebDriverService wdService) {
		super(wdService);
		PAGE_URL = MAIN_URL + "dropdown";
	}
	
	public void visitPage() {
		webDriver.get(PAGE_URL);
	}
	
	public void waitForDropDownPresent() {
		new WebDriverWait(wdService.getWebDriver(), 10) {
		}.until(ExpectedConditions.visibilityOf(dropDownList));
	}
	
	public List<WebElement> getDropDownListItems() {
		Select selection = new Select(dropDownList);
		return new ArrayList<WebElement>(selection.getOptions());
	}
	
	public boolean isFirstOptionSelected() {
		return dropDownList.findElement(dropDownFirstOption).isSelected();
	}
	
	public void selectDdFirstOption() {
		dropDownList.findElement(dropDownFirstOption).click();
	}
	
	public String getDropDownDisplayedText() {
		return new Select(dropDownList).getFirstSelectedOption().getText();
	}
}
