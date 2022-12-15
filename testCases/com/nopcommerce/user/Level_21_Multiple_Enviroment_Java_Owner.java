package com.nopcommerce.user;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import common.BaseTest;
import common.Enviroment;
import demo.nopcommerce.com.pageObjects.user.PageGeneratorManager;
import demo.nopcommerce.com.pageObjects.user.UserHomePageObject;
import demo.nopcommerce.com.pageObjects.user.UserLoginPageObject;
import demo.nopcommerce.com.pageObjects.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_21_Multiple_Enviroment_Java_Owner extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	UserDataMapper userData;
	Enviroment env;

	@Parameters({ "browser", "enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviroment) {
		ConfigFactory.setProperty("env", enviroment);
		env = ConfigFactory.create(Enviroment.class);
		driver = getWebDriver(browserName,env.url());
		
		userData = UserDataMapper.getUserData();
		validEmail = userData.getFirstName() + randomEmailByNumber() + "@faker.com";

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_User_01_Register() {
		log.info("Register - step 1 - click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - step 2 - input value into ' First name' textbox: " + userData.getFirstName());
		registerPage.inputToFirstNameTextbox(userData.getFirstName());

		log.info("Register - step 3 - input value into 'Last name' textbox: " + userData.getLastName());
		registerPage.inputToLastNameTextbox(userData.getLastName());

		log.info("Register - step 4 - input value into 'Email' textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);

		log.info("Register - step 5 - input value into 'Password' textbox: " + userData.getPassword());
		registerPage.inputToPasswordTextbox(userData.getPassword());

		log.info("Register - step 6 - input value into 'Confirm password' textbox: " + userData.getPassword());
		registerPage.inputToConfirmPasswordTextbox(userData.getPassword());

		log.info("Register - step 7 - click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Register - step 8 - verify customer info");
		Assert.assertEquals(registerPage.getSuccessMessageRegister(), "Your registration completed");

		log.info("Register - step 9 - check undisplayed");
		Assert.assertTrue(homePage.verifyElementIsDisplayed());

	}

	@Test
	public void TC_User_02_Login() {
		homePage = registerPage.clickToLogOutUserLink(driver);
		
		log.info("Login - step 1 - click to 'Login' link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - step 2 - input value into 'Email' textbox: " + validEmail);
		loginPage.inputToEmailTextbox(validEmail);
		
		log.info("Login - step 3 - input value into 'Password' textbox: " + userData.getPassword());
		loginPage.inputToPasswordTextbox(userData.getPassword());

		log.info("Login - step 4 - click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - step 5 - verify My Account Link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
