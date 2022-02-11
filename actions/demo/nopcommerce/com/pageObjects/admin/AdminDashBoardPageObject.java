package demo.nopcommerce.com.pageObjects.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import demo.nopcommerce.com.pageUIs.admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage{
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	 public boolean isAdminDashBoardTitleDisplayed() {
		 return elementIsDisplayed(driver, AdminDashBoardPageUI.ADMIN_DASHBOARD_TITLE);
	 }
}
