package scripta.signup;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import scripta.common.BaseTestSuite;
import scripta.common.CommonMethods;

public class SignupTestClass extends BaseTestSuite {
	@BeforeSuite
	@Parameters("browser")
	public void beforeSuite(String browser) {
		System.out.println("LoginTestClass: before suite " + browser);
	}

	public static final String SIGNUP_LINK = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[7]/div[1]/button";
	public static final String COMPANY_NAME = "//*[@id=\"companyName\"]";
	public static final String NEXT = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[4]/div/div/div/button/span[1]";
	public static final String FIRST_NAME = "//*[@id=\"firstName\"]";
	public static final String LAST_NAME = "//*[@id=\"lastName\"]";
	public static final String SIGNUP_BUTTON = "//button[text()='SIGN UP']";
	public static final String PROFILE_TAB = "//a[@href='/profile']";
	public static final String DELETE_BUTTON = "//button[text()[contains(., \"DELETE\n"
			+ "                        ACCOUNT\")]]";
	public static final String MEMBER_RADIO = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[4]/fieldset/div/label/span[1]/span[1]/input";
	public static final String MEMBER_ID = "//*[@id=\"matchValue\"]";
	public static final String YEAR = "//*[@id=\"year\"]";
	public static final String MONTH = "//*[@id=\"month\"]";
	public static final String DAY = "//*[@id=\"day\"]";
	public static final String DATE = "/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[5]/button/span[1]";
	public static final String OK = "/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]";
	public static final String NEXT_BUTTON = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[7]/div/div/button/span[1]";
	public static final String ANSWER_SECURITY_QUESTION = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[4]/button/span[1]";
	public static final String ADDRESS = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/fieldset/div/label[2]/span[2]/p";
	public static final String MEDICATION = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[3]/div/fieldset/div/label[1]/span[2]/p";
	public static final String PRESCRIBED = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[4]/div/fieldset/div/label[1]/span[2]/p";
	public static final String VERIFY_INFORMATION = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[5]/div/div/button/span[1]";
	public static final String EMAIL_CONTACT = "//*[@id=\"emailContact\"]";
	public static final String TOU = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div[3]/div/div[1]/label/span[1]/span[1]/input";
	public static final String PRIVACY_POLICY = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div[4]/div[1]/label/span[1]/span[1]/input";
	public static final String NEXT_NOTIFICATION = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div/button/span[1]";
	public static final String NO_THANKS_RADIO = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/fieldset/div/label[2]/span[1]/span[1]/input";
	public static final String NEXT_MESSAGING = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/button/span[1]";
	public static final String USER_NAME = "//*[@id=\"userName\"]";
	public static final String PASSWORD = "//*[@id=\"password\"]";
	public static final String CONFIRM_PASSWORD = "//*[@id=\"passwordConfirm\"]";
	public static final String COMPLETE_REGISTRATION = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[6]/div/div/button/span[1]";
	public static final String CONTINUE_TO_LOGIN = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div/button/span[1]";
	public static final String SAVINGS_REPORT = "//*[@id=\"root\"]/div/header/div/p";
	public static final String HAM = "//*[@id=\"root\"]/div/header/div/button/span[1]";
	public static final String LOGOUT = "/html/body/div[5]/div[3]/nav/ul/ul/div[5]/li/a/div[2]/span";

	// Sign Up new user from database
	@Parameters({ "companyName", "firstName", "lastName", "memberId", "userName", "password", "year", "month", "day",
			"emailContact", "setPassword", "confirmPassword" })
	@Test(groups = { "smokeTest", "regressionTest" }, priority = 1, description = "Signup new user")
	public static void signUp(String companyName, String firstName, String lastName, String memberId, String userName,
			String password, String year, String month, String day, String emailContact, String setPassword,
			String confirmPassword) throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(1000);
		Reporter.log("The user is able to proceed for registration", CommonMethods.enableLog);
		browser.findElement(By.xpath(SIGNUP_LINK)).click();
		Thread.sleep(3000);
		browser.findElement(By.xpath(COMPANY_NAME)).sendKeys(companyName);
		Thread.sleep(2000);
		browser.findElement(By.xpath(NEXT)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(FIRST_NAME)).sendKeys(firstName);
		Thread.sleep(1000);
		browser.findElement(By.xpath(LAST_NAME)).sendKeys(lastName);
		Thread.sleep(1000);
		browser.findElement(By.xpath(MEMBER_RADIO)).click();
		Thread.sleep(1000);
		browser.findElement(By.xpath(MEMBER_ID)).sendKeys(memberId);
		Thread.sleep(1000);
		browser.findElement(By.xpath(YEAR)).sendKeys(year);
		Thread.sleep(1000);
		browser.findElement(By.xpath(MONTH)).sendKeys(month);
		Thread.sleep(2000);
		browser.findElement(By.xpath(DAY)).sendKeys(day);
		Thread.sleep(2000);
		browser.findElement(By.xpath(NEXT_BUTTON)).click();
		Thread.sleep(5000);
		Reporter.log("The user is able to proceed to next page to answer security question", CommonMethods.enableLog);
		// Now Verify information
		browser.findElement(By.xpath(ANSWER_SECURITY_QUESTION)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(ADDRESS)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(MEDICATION)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(PRESCRIBED)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(VERIFY_INFORMATION)).click();
		Thread.sleep(4000);
		Reporter.log("The user is able to verify his identity", CommonMethods.enableLog);
		// Now enter details on next page to receive notifications via email.
		browser.findElement(By.xpath(EMAIL_CONTACT)).sendKeys(emailContact);
		Thread.sleep(2000);
		browser.findElement(By.xpath(TOU)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(PRIVACY_POLICY)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(NEXT_NOTIFICATION)).click();
		Thread.sleep(2000);
		Reporter.log("The user configures his email for notifications", CommonMethods.enableLog);
		// Now opt selection for messaging
		browser.findElement(By.xpath(NO_THANKS_RADIO)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(NEXT_MESSAGING)).click();
		Thread.sleep(3000);
		Reporter.log("The user opts selection for messaging", CommonMethods.enableLog);
		// Now set the user name and password for the user
		browser.findElement(By.xpath(USER_NAME)).sendKeys(userName);
		Thread.sleep(2000);
		browser.findElement(By.xpath(PASSWORD)).sendKeys(setPassword);
		Thread.sleep(2000);
		browser.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(confirmPassword);
		Thread.sleep(2000);
		browser.findElement(By.xpath(COMPLETE_REGISTRATION)).click();
		Thread.sleep(8000);
		Assert.assertTrue(
				browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/p")).isDisplayed());
		Thread.sleep(2000);
		browser.findElement(By.xpath(CONTINUE_TO_LOGIN)).click();
		Thread.sleep(3000);
		Reporter.log("The user sets the user credentials", CommonMethods.enableLog);
		// Now login with the new user
		Thread.sleep(2000);
		browser.findElement(By.id("userLoginName")).sendKeys(userName);
		Thread.sleep(2000);
		browser.findElement(By.id("userName")).sendKeys(password);
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGIN_SUBMIT)).click();
		Thread.sleep(3000);
		Reporter.log("The user is logged in successfully", CommonMethods.enableLog);
		Assert.assertTrue(browser.findElement(By.xpath(SAVINGS_REPORT)).isDisplayed());
		Thread.sleep(4000);
		Reporter.log("User is able to land on the Savings report page", CommonMethods.enableLog);
		browser.findElement(By.xpath(HAM)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGOUT)).click();
		Thread.sleep(3000);
	}

	@AfterSuite(alwaysRun = true, description = "Tear down web driver")
	public void tearDown() throws InterruptedException {
		browser.quit();
	}
}
