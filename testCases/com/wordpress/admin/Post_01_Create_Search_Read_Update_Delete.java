package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wordpress.pageObjects.AdminDashBoardPageObject;
import com.wordpress.pageObjects.AdminLoginPageObject;
import com.wordpress.pageObjects.AdminPostAddNewPageObject;
import com.wordpress.pageObjects.AdminPostSearchPageObject;
import com.wordpress.pageObjects.PageGeneratorManager;
import com.wordpress.pageObjects.UserHomePageObject;
import com.wordpress.pageObjects.UserPostDetailPageObject;

import common.BaseTest;

public class Post_01_Create_Search_Read_Update_Delete extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	AdminLoginPageObject loginPage;
	AdminDashBoardPageObject dashboardPage;
	AdminPostSearchPageObject postSearchPage;
	AdminPostAddNewPageObject postAddNewPage;
	UserHomePageObject userHomePage;
	UserPostDetailPageObject userPostDetailPage;

	String username = "automationfc", password = "automationfc";
	int randomNumber = randomByNumber();
	String postTitle = " Post Title " + randomNumber;
	String postBody = " Post body " + randomNumber;
	String postSearchPageURL = "";
	String authorName = "automationfc";
	String authorNameInEndUser = "Automationfc";
	String urlAdmin = "", urlUser = "";
	String currentDay = getToday();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		log.info("Precondition 1: get browser and url");
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getWebDriver(browserName, this.urlAdmin);

		log.info("Precondition 2: open Login page");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Precondition 3:  input to Username textbox with value: " + username);
		loginPage.inputToUsernameTextbox(username);

		log.info("Precondition 4: input to Username textbox with value: " + username);
		loginPage.inputToPasswordTextbox(password);

		log.info("Precondition 5: click to Login button");
		dashboardPage = loginPage.clickToLoginButton();

		log.info("Precondition 6: click to Post menu link");
		postSearchPage = dashboardPage.clickToPostMenuLink();

	}

	@Test
	public void Post_01_Create() {
		log.info("Post_01_Create 1: get Post Search Page URL");
		postSearchPageURL = postSearchPage.getPageUrl(driver);

		log.info("Post_01_Create 2: click to Add New button");
		postAddNewPage = postSearchPage.clickToAddNewButton();

		log.info("Post_01_Create 3: input to Post Title with value: " + postTitle);
		postAddNewPage.inputToPostTitleTextbox(postTitle);

		log.info("Post_01_Create 4: input to Post body with value: " + postBody);
		postAddNewPage.inputToPostBodyTextbox(postBody);

		log.info("Post_01_Create 5: click to Publish button");
		postAddNewPage.clickToPublishButton();

		log.info("Post_01_Create 6: click to Pre-Publish button");
		postAddNewPage.clickToPrePublishButton();

		log.info("Post_01_Create 7: verify post published message");
		Assert.assertTrue(postAddNewPage.isDisplayedPostPublishMessage());

	}

	@Test
	public void Post_02_Search_And_Read() {
		log.info("Post_02_Search_And_Read 1: Open 'Search Post' Page");
		postSearchPage = postAddNewPage.openSearchPostPage(driver, postSearchPageURL);

		log.info("Post_02_Search_And_Read 2: input to Search post textbox with value: " + postTitle);
		postSearchPage.inputToSearchPostTextbox(postTitle);

		log.info("Post_02_Search_And_Read 3: click to Search post button");
		postSearchPage.clickToSearchButton();

		log.info("Post_02_Search_And_Read 4: verify Search table contain: " + postTitle);
		Assert.assertTrue(postSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Post_02_Search_And_Read 5: verify Search table contain: " + authorName);
		Assert.assertTrue(postSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Post_02_Search_And_Read 6: Open User Home Page");
		userHomePage = postSearchPage.openUserHomePage(driver, this.urlUser);

		log.info("Post_02_Search_And_Read 7: Verify informations displayed in User Home Page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostBody(postBody));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTime(postTitle, currentDay));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorNameInEndUser));

		log.info("Post_02_Search_And_Read 8: Click to Title Post");
		userPostDetailPage = userHomePage.clickToTitlePost();

		log.info("Post_02_Search_And_Read 9: Verify informations displayed in Post Detail Page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTime(postTitle, currentDay));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postBody));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorNameInEndUser));
	}

	@Test
	public void Post_03_Update() {

	}

	@Test
	public void Post_04_Delete() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
