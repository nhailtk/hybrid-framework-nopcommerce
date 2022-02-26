package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import demo.nopcommerce.com.pageObjects.user.UserAddressesPageObject;
import demo.nopcommerce.com.pageObjects.user.UserCustomerInfoPageObject;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.UserOrdersPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;
import demo.nopcommerce.com.pageObjects.user.UserRewardPointsPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressesPageObject addressesPage;
	private UserOrdersPageObject ordersPage;
	private UserRewardPointsPageObject rewardPointsPage;

	String firstName = "Automation", lastName = "FC", password = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getWebDriver(browserName);

		validEmail = "automation" + randomEmailByNumber() + "@gmail.com";
		notFoundEmail = "automation" + randomEmailByNumber() + "@abc.com";
		invalidEmail = "abc@123#456";

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_User_01_Register() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");

		homePage = registerPage.clickToLogOutUserLink(driver);
	}

	@Test
	public void TC_User_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void TC_User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoHeaderDisplayed());
	}

	@Test
	public void TC_User_04_Switch_Page() {
		addressesPage = customerInfoPage.openAddressesPage(driver);

		ordersPage = addressesPage.openOrdersPage(driver);

		rewardPointsPage = ordersPage.openRewardPointsPage(driver);

		addressesPage = rewardPointsPage.openAddressesPage(driver);
	}

	@Test
	public void TC_User_05_Dynamic_Page_01() {

		ordersPage = (UserOrdersPageObject) addressesPage.openDynamicPage(driver, "customer-orders inactive");

		rewardPointsPage = (UserRewardPointsPageObject) ordersPage.openDynamicPage(driver, "reward-points inactive");

		addressesPage = (UserAddressesPageObject) rewardPointsPage.openDynamicPage(driver, "customer-addresses inactive");

		customerInfoPage = (UserCustomerInfoPageObject) addressesPage.openDynamicPage(driver, "customer-info inactive");
	}
	
	@Test
	public void TC_User_05_Dynamic_Page_02() {

		customerInfoPage.openDynamicMorePage(driver, "customer-addresses inactive");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		addressesPage.openDynamicMorePage(driver, "customer-orders inactive");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		ordersPage.openDynamicMorePage(driver, "reward-points inactive");
		rewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);
		
		rewardPointsPage.openDynamicMorePage(driver, "customer-info inactive");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
	}

	public int randomEmailByNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
