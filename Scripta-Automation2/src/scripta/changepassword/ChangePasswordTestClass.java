package scripta.changepassword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import scripta.common.BaseTestSuite;
import scripta.common.CommonMethods;

public class ChangePasswordTestClass extends BaseTestSuite {
		@BeforeSuite
		@Parameters("browser")
		public void beforeSuite(String browser) {
			Reporter.log(("LoginTestClass: before suite " + browser), CommonMethods.enableLog);
		}

		private static final String LOGIN_SUBMIT = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[5]/div/div/button/span[1]";
		public static final String LOGOUT = "/html/body/div[5]/div[3]/nav/ul/ul/div[5]/li/a/div[2]/span";
		public static final String SAVINGS_REPORT = "//*[@id=\"root\"]/div/header/div/p";
		public static final String HAM = "//*[@id=\"root\"]/div/header/div/button/span[1]";
		public static final String SETTINGS = "/html/body/div[5]/div[3]/nav/ul/ul/div[2]/li/a/div[2]";
		public static final String CURRENT_PASSWORD = "//*[@id=\"currentPassword\"]";
		public static final String NEW_PASSWORD = "//*[@id=\"newPassword\"]";
		public static final String CONFIRM_PASSWORD = "//*[@id=\"passwordConfirm\"]";
		public static final String CHANGE_PASSWORD = "/html/body/div[1]/div/main/div[1]/div/div[1]/div/div/div[2]/div/div/div/div[5]/button/span[1]";

		// Login with valid credentials and then change password
		@Test(groups = { "smokeTest",
				"regressionTest" }, priority = 1, description = "Login with valid credentials on member portal")
		@Parameters({ "url", "userName", "password", "newPassword", "confirmPasswordReset" })
		public static void changePassword(String url, String userName, String password, String newPassword, String confirmPasswordReset) throws InterruptedException {
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
			browser.findElement(By.xpath(SETTINGS)).click();
			Thread.sleep(2000);
			browser.findElement(By.xpath(CURRENT_PASSWORD)).sendKeys(password);
			Thread.sleep(2000);
			browser.findElement(By.xpath(NEW_PASSWORD)).sendKeys(newPassword);
			Thread.sleep(2000);
			browser.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(confirmPasswordReset);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) browser;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000);
			browser.findElement(By.xpath(CHANGE_PASSWORD)).click();
			Thread.sleep(4000);
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
