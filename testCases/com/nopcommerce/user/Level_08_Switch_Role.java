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
import demo.nopcommerce.com.pageObjects.admin.AdminDashBoardPageObject;
import demo.nopcommerce.com.pageObjects.admin.AdminLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;
import demo.nopcommerce.com.pageObjects.user.UserRewardPointsPageObject;

public class Level_08_Switch_Role extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String userValidEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashBoardPageObject;
	String firstName = "Automation", lastName = "FC", userPassword = "123456";
	String adminEmail = "admin@yourstore.com", adminPassword = "admin";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getWebDriver(browserName);

		userValidEmail = "automation" + randomEmailByNumber() + "@gmail.com";
		notFoundEmail = "automation" + randomEmailByNumber() + "@abc.com";
		invalidEmail = "abc@123#456";

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_User_To_Admin() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.registerSuccessfull(firstName, lastName, userValidEmail, userPassword);
		Assert.assertEquals(userRegisterPage.getSuccessMessageRegister(), "Your registration completed");

		userHomePage = userRegisterPage.clickToLogOutUserLink(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		userHomePage = userLoginPage.loginAsUser(userValidEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		userCustomerInfoPage = userHomePage.clickToMyAccountLink();

		userHomePage = userCustomerInfoPage.clickToLogOutUserLink(driver);

		adminLoginPage = userHomePage.getAdminLoginPage(driver);

		adminDashBoardPageObject = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashBoardPageObject.isAdminDashBoardTitleDisplayed());

		adminLoginPage = adminDashBoardPageObject.clickToLogOutAdminLink(driver);
		Assert.assertTrue(adminLoginPage.isAdminTitlePageDisplayed());

	}

	
	public void TC_02_Admin_To_User() {

		adminDashBoardPageObject = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashBoardPageObject.isAdminDashBoardTitleDisplayed());

		adminLoginPage = adminDashBoardPageObject.clickToLogOutAdminLink(driver);
		Assert.assertTrue(adminLoginPage.isAdminTitlePageDisplayed());

		userHomePage = adminLoginPage.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		userHomePage = userLoginPage.loginAsUser(userValidEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
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
