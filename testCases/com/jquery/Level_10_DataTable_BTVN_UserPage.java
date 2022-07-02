package com.jquery;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jquery.pageObjects.AdminPageObject;
import com.jquery.pageObjects.HomePageObject;
import com.jquery.pageObjects.PageGeneratorManager;
import com.jquery.pageObjects.UserPageObject;

import common.BaseTest;

public class Level_10_DataTable_BTVN_UserPage extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private UserPageObject userPage;
	private AdminPageObject adminPage;
	String firstName = "Anh", lastName = "Mai", password = "123456", fullName = "Anh Mai";
	String email = "maianh" + randomEmailByNumber() + "@gmail.com";
	String userNameInAdminPage = "user01", passwordInAminPage = "guru99com";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		userPage = PageGeneratorManager.getUserPage(driver);
	}

	@Test
	public void Register_User() {
		userPage.registerUser(firstName, lastName, email, password);
		Assert.assertTrue(userPage.isDisplayRegisterSuccessLabel());

		adminPage = userPage.getAdminPage(driver);

		adminPage.loginAdminPage(userNameInAdminPage, passwordInAminPage);
		adminPage.searchUser(fullName, email);
		Assert.assertTrue(adminPage.isDisplayNameAndEmailOfUser(fullName, email));

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
