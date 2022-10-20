package scripta.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import scripta.common.BaseTestSuite;
import scripta.common.CommonMethods;

public class LoginTestClass extends BaseTestSuite {
	@BeforeSuite
	@Parameters("browser")
	public void beforeSuite(String browser) {
		Reporter.log(("LoginTestClass: before suite " + browser), CommonMethods.enableLog);
	}

	private static final String LOGIN_SUBMIT = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[5]/div/div/button/span[1]";
	public static final String LOGOUT = "/html/body/div[5]/div[3]/nav/ul/ul/div[5]/li/a/div[2]/span";
	public static final String SAVINGS_REPORT = "//*[@id=\"root\"]/div/header/div/p";
	public static final String HAM = "//*[@id=\"root\"]/div/header/div/button/span[1]";

	// Login with valid credentials
	@Test(groups = { "smokeTest",
			"regressionTest" }, priority = 1, description = "Login with valid credentials on member portal")
	@Parameters({ "url", "userName", "password" })
	public static void login(String url, String userName, String password) throws InterruptedException {
		Thread.sleep(2000);
		browser.findElement(By.id("userLoginName")).sendKeys(userName);
		Thread.sleep(2000);
		browser.findElement(By.id("userName")).sendKeys(password);
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGIN_SUBMIT)).click();
		Thread.sleep(3000);
		Reporter.log("The user is logged in successfully", CommonMethods.enableLog);
		Assert.assertTrue(browser.findElement(By.xpath(SAVINGS_REPORT)).isDisplayed());
		Thread.sleep(2000);
		Reporter.log("User is able to land on the Savings report page", CommonMethods.enableLog);
		browser.findElement(By.xpath(HAM)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGOUT)).click();
		Thread.sleep(5000);

	}

	@AfterSuite(alwaysRun = true, description = "Tear down web driver")
	public void tearDown() throws InterruptedException {
		browser.quit();
	}
}