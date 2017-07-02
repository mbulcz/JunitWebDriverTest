package com.mbul.somepagetest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mbul.page.object.DropDownPage;
import com.mbul.page.object.HomePage;

import com.mbul.service.impl.BaseWebDriverService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ElementalTest {

	private static BaseWebDriverService wdService;
	
	@BeforeClass
	public static void setUp() {
		wdService = new BaseWebDriverService();
	}
	
	@Test
	public void dropDownTest() {
		HomePage homePage = new HomePage(wdService);
		homePage.visitPage();
		DropDownPage dropDownPage = homePage.goToDropDownPage();
		dropDownPage.waitForDropDownPresent();
		assertThat(dropDownPage.getDropDownListItems(), hasSize(3));
		
		if (!dropDownPage.isFirstOptionSelected()) {
			dropDownPage.selectDdFirstOption();
		}
		assertThat(dropDownPage.isFirstOptionSelected(), is(equalTo(true)));
		assertThat(dropDownPage.getDropDownDisplayedText(), is("Option 1"));
	}
	
	@AfterClass
	public static void tearDown() {
		wdService.getWebDriver().quit();
	}
}
