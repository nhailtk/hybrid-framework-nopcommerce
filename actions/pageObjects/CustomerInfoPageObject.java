package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.CustomerInfoUI;
import pageUIs.RegisterPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoHeaderDisplayed() {
		waitForElementVisible(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
		return elementIsDisplayed(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
	}

}
