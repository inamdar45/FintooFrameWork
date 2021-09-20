package fintoo.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.LoginPage;
import fintoo.PageObject.RegistrationPage;
import fintoo.Utilities.XLUtils;

public class TC_Negative_Registration_006 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	RegistrationPage rp = new RegistrationPage(driver);
	String excelPath = readconfig.getExcelPath();
	int rownum;
	int colnum;
	String mobileNo, email, pass, confirmPass;

	@Test
	public void emptyFieldTest() {
		logger = extent.createTest("Empty Field Test");
		extentTest.set(logger);

		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Login Link");
		lp.genericClick(driver, lp.registerNow);
		logger.pass("Clicked on Register Now");
		rp.genericClick(driver, rp.checkBox);
		logger.pass("Clicked on  I Accept T&C CheckBox");
		rp.genericClick(driver, rp.registerButton);
		logger.pass("Clicked on Register Button");
		logger.pass("Provide following for Registration " + " " + driver.findElement(rp.mobileNumberErrorMsg).getText()
				+ " " + driver.findElement(rp.emailErrorMsg).getText() + " "
				+ driver.findElement(rp.passwordErrorMsg).getText() + " "
				+ driver.findElement(rp.confirmPasswordErrorMsg).getText());
	}

	@Test
	public void invalidData() throws IOException, InterruptedException {

		// String excelPath = readconfig.getExcelPath();
		rownum = XLUtils.getRowCount(excelPath, "Registration");
		colnum = XLUtils.getCellCount(excelPath, "Registration", rownum);
		for (int i = 1; i <= rownum; i++) {
			mobileNo = XLUtils.getCellData(excelPath, "Registration", i, 0);
			email = XLUtils.getCellData(excelPath, "Registration", i, 1);
			pass = XLUtils.getCellData(excelPath, "Registration", i, 2);
			confirmPass = XLUtils.getCellData(excelPath, "Registration", i, 3);
			logger = extent.createTest("Invalid  Test0" + i);
			extentTest.set(logger);
			rp.genericSendKeys(driver, rp.mobileNumberTxtField, mobileNo);
			logger.pass("Entered Mobile number is :-" + mobileNo);
			rp.genericSendKeys(driver, rp.emailTxtField, email);
			logger.pass("Entered Email Address is :-" + email);
			rp.genericSendKeys(driver, rp.passwordTxtField, pass);
			logger.pass("Entered Password is :-" + pass);

			rp.genericSendKeys(driver, rp.confirmPasswordTxtField, confirmPass);
			logger.pass("Entered Confirm Password is :-" + confirmPass);

			if (i == rownum) {
				rp.genericClick(driver, rp.checkBox);
				logger.pass("Unchecked on  I Accept T&C CheckBox");
			}
			rp.genericClick(driver, rp.registerButton);
			logger.pass("Clicked on Registration Button");

			Thread.sleep(3000);
			if (driver.findElement(rp.mobileNumberErrorMsg).isDisplayed()) {
				String mobileErrorText = driver.findElement(rp.mobileNumberErrorMsg).getText();
				if (mobileErrorText.contains("enter at least 10 characters")) {
					Assert.assertEquals(mobileErrorText, "Please enter at least 10 characters.");
					logger.pass(mobileErrorText + "Mobile Number");
				}
				if (mobileErrorText.contains("Mobile is already")) {
					Assert.assertEquals(mobileErrorText, "Mobile is already registered");
					logger.pass(mobileErrorText);

				}

			}

			if (driver.findElement(rp.emailErrorMsg).isDisplayed()) {
				String emailErrorText = driver.findElement(rp.emailErrorMsg).getText();
				Assert.assertEquals(emailErrorText, "Please enter a valid email address.");
				logger.pass(emailErrorText);
			}

			if (driver.findElement(rp.passwordErrorMsg).isDisplayed()) {
				String passErrorText = driver.findElement(rp.passwordErrorMsg).getText();
				Assert.assertEquals(passErrorText, "Please enter at least 8 characters.");
				logger.pass(passErrorText + "Length Password");
			}

			/*
			 * try { if(driver.findElement(rp.passwordErrorMsg16).isDisplayed()) { String
			 * passErrorText = driver.findElement(rp.passwordErrorMsg16).getText();
			 * Assert.assertEquals(passErrorText,
			 * "Please enter no more than 16 characters."); logger.pass(passErrorText +
			 * "Length Password"); }} catch(Exception e) {}
			 */

			if (!driver.findElement(rp.passwordErrorMsg).isDisplayed()
					&& driver.findElement(rp.confirmPasswordErrorMsg).isDisplayed()) {
				String confirmPassErrorText = driver.findElement(rp.confirmPasswordErrorMsg).getText();
				Assert.assertEquals(confirmPassErrorText, "Password Mismatch. Please enter correct password");
				logger.pass(confirmPassErrorText);
			}
			Thread.sleep(3000);
			if (driver.findElement(rp.tcErrorMsg).isDisplayed()) {
				String tcErrorText = driver.findElement(rp.tcErrorMsg).getText();
				Assert.assertEquals(tcErrorText, "Please accept Terms & Conditions.");
				logger.pass(tcErrorText + "before registeration");
			}
		}

	}
}
