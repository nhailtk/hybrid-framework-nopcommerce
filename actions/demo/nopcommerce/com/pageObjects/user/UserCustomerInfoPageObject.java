package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import demo.nopcommerce.com.pageUIs.user.UserCustomerInfoUI;
import demo.nopcommerce.com.pageUIs.user.UserRegisterPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoHeaderDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
		return elementIsDisplayed(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
	}

}
