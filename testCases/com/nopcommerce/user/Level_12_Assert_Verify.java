package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
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

public class Level_12_Assert_Verify extends BaseTest {
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

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getWebDriver(browserName, url);

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
		verifyEquals(registerPage.getSuccessMessageRegister(), "Your registrtion completed");
		verifyEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");
		verifyEquals(registerPage.getSuccessMessageRegister(), "Your registrtion completed");


		homePage = registerPage.clickToLogOutUserLink(driver);
	}

	
	public void TC_User_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isMyAccountLinkDisplayed());

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
