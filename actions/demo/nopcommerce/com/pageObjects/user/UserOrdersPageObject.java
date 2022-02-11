package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserOrdersPageObject extends BasePage{
	private WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
