package com.project.stepdefs;

import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.saf.framework.AutomationConstants;
import com.saf.framework.DriverUtilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class stepdef
{
	public static WebDriver webDriver;
	LoginPage loginPage;
	HomePage homePage;

	@Before
	public void beforeAction(){
		webDriver = DriverUtilities.getDriver();
		webDriver.get(AutomationConstants.uRl);
		loginPage = new LoginPage(webDriver);
		homePage = new HomePage(webDriver);
	}

	@After
	public void afterAction(){
		webDriver.quit();
	}

	@Given("^Verify Login Page$")
	public void verifyLoginPage() {
		Assert.assertTrue(loginPage.isLogoVisible(),"page is not loaded successfully");
	}

	@And("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterAnd(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@And("^Click login button$")
	public void clickLoginButton() {
		loginPage.clickLoginButton();
	}

	@Then("^Verify home page$")
	public void verifyHomePage() {
		Assert.assertTrue(homePage.isMenuVisible());
		Assert.assertTrue(homePage.isBasketVisible());
		Assert.assertTrue(homePage.isProductsVisible());
		Assert.assertTrue(homePage.isSortContainerVisible());
	}

	@Then("^Verify error message \"([^\"]*)\"$")
	public void verifyErrorMessage(String errorMessage){
		String text  = loginPage.getErrorMessageText();
		Assert.assertEquals(text,errorMessage);
	}

}
