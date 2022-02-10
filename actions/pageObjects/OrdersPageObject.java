package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class OrdersPageObject extends BasePage{
	private WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
