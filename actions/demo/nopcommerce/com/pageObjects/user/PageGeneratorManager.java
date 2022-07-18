package demo.nopcommerce.com.pageObjects.user;

import org.openqa.selenium.WebDriver;

import demo.nopcommerce.com.pageObjects.admin.AdminDashBoardPageObject;
import demo.nopcommerce.com.pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	
	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	
	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	
	public static AdminDashBoardPageObject getAdminDashBoradPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}


}
