package facebook.com.pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import facebook.com.pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean elementIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return elementIsDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, HomePageUI.REGISTER_BUTTON);
		clickToElement(driver, HomePageUI.REGISTER_BUTTON);

	}

	public boolean elementIsUndisplayed() {
		waitForElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return elementIsUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);

	}

}
