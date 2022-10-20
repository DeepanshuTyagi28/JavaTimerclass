package scripta.pdfdownload;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import scripta.common.BaseTestSuite;
import scripta.common.CommonMethods;

public class PdfSavingsDownload extends BaseTestSuite {
	@BeforeSuite
	@Parameters("browser")
	public void beforeSuite(String browser) {
		Reporter.log(("PdfSavingsDownloadClass: before suite " + browser), CommonMethods.enableLog);
	}

	private static final String LOGIN_SUBMIT = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[5]/div/div/button/span[1]";
	public static final String LOGOUT = "/html/body/div[5]/div[3]/nav/ul/ul/div[5]/li/a/div[2]/span";
	public static final String SAVINGS_REPORT = "//*[@id=\"root\"]/header/div/p";
	public static final String HAM = "//*[@id=\"root\"]/header/div/button/span[1]";
	public static final String DOWNLOAD_PDF_SAVINGS_REPORT = "//*[@id=\"main\"]/div[1]/div/div[2]/div/div/div/div/button/span[1]";
	private static String fileDownloadpath = "C:\\Users\\Akash Gupta\\Downloads";

	// Login with valid credentials
	@Test(groups = { "smokeTest",
			"regressionTest" }, priority = 1, description = "Download the pdf savings report from member portal")
	@Parameters({ "url", "userNameForPdfDownload", "password" })
	public static void downloadPdfReport(String url, String userNameForPdfDownload, String password)
			throws InterruptedException {
		Thread.sleep(2000);
		browser.findElement(By.id("userLoginName")).sendKeys(userNameForPdfDownload);
		Thread.sleep(2000);
		browser.findElement(By.id("userName")).sendKeys(password);
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGIN_SUBMIT)).click();
		Thread.sleep(5000);
		Reporter.log("The user is logged in successfully", CommonMethods.enableLog);
		Assert.assertTrue(browser.findElement(By.xpath(DOWNLOAD_PDF_SAVINGS_REPORT)).isDisplayed());
		Thread.sleep(2000);
		browser.findElement(By.xpath(DOWNLOAD_PDF_SAVINGS_REPORT)).click();
		Thread.sleep(15000);
		Reporter.log("Download pdf savings report", CommonMethods.enableLog);
		// Date formatter to fetch the current date for verification
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuuMMdd");
		LocalDate localDate = LocalDate.now();
		Reporter.log((dtf.format(localDate)), CommonMethods.enableLog); // E.g. 20210322 
		// Verify if the file is downloaded
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "SavingsReport_MARIA_BOEDING_" + dtf.format(localDate) + ".pdf"),
				"Failed to download Expected document");
		Reporter.log("The pdf savings report is downloaded successfully", CommonMethods.enableLog);
		// Logout the user post verification
		browser.findElement(By.xpath(HAM)).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath(LOGOUT)).click();
		Thread.sleep(5000);
	}

	// Method used to verify whether the pdf file downloads
	@Test
	public static boolean isFileDownloaded(String fileDownloadpath, String fileName) {
		boolean flag = false;
		java.io.File directory = new java.io.File(fileDownloadpath);
		java.io.File[] content = directory.listFiles();
		for (int i = 0; i < content.length; i++) {
			if (content[i].getName().equals(fileName))
				return flag = true;
		}
		return flag;
	}

	@AfterSuite(alwaysRun = true, description = "Tear down web driver")
	public void tearDown() throws InterruptedException {
		browser.quit();
	}
}