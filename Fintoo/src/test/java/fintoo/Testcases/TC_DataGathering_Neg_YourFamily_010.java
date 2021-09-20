package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_DataGathering_Neg_YourFamily_010 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB = new DashBoard(driver);
	Billing bill = new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);

	@Test
	public void dataGatheringNegative01() throws IOException, InterruptedException, AWTException {
		Robot robot = new Robot();
		logger = extent.createTest("Datagathering_Neg_YourFamily");
		extentTest.set(logger);

		String excelPath = readconfig.getExcelPath();
		int rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
		ArrayList<String> datagatheringList = new ArrayList<>();
		// HashMap<String, String> dGMap=new HashMap<String, String>();
		int rowsize = XLUtils.getRowCount(excelPath, "Datagathering");
		int colsize = XLUtils.getCellCount(excelPath, "Datagathering", rowsize);

		for (int i = 5; i <= rowsize; i++) {
			for (int j = 0; j <= colsize; j++) {
				// String key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);

				String abc = XLUtils.getCellData(excelPath, "Datagathering", i, j);
				datagatheringList.add(abc);
				// dGMap.put(key, value)
			}
		}
		logger.pass("Login Started");
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Loggin Link");
		// lp.setEmailMob(username);
		lp.genericSendKeys(driver, lp.emailMobTextBox, username);
		logger.pass("Entered email Id or mobile number " + username);
		lp.genericSendKeys(driver, lp.passwordTextBox, pass);
		logger.pass("Entered password " + pass);
		// lp.loginButton();
		lp.genericClick(driver, lp.loginButton);
		logger.pass("Clicked on LoginButton ");
		Assert.assertEquals(driver.getTitle(), "Fintoo");
		logger.pass("Login sucessful");
		Thread.sleep(6000);
		if (driver.findElement(dG.scoreCard).isDisplayed()) {
			dG.genericClick(driver, dG.myPlan);
			logger.pass("Clicked on My Plan");
		}
		Thread.sleep(3000);
		dG.genericClick(driver, dG.continueButton01);
		logger.pass("Clicked on Continue Button");
		Thread.sleep(5000);
		if (driver.findElement(dG.signOffButton).isDisplayed()) {
			dG.genericClick(driver, dG.dataGatheringButton);
			logger.pass("Clicked on DataGathering link");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.addDataButton);
		logger.pass("Clicked on Add Data Button");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.yourFamilyLink);
		logger.pass("Clicked on Your Family info");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.earningStatus);
		logger.pass("Clicked on Earning radio Button");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");
		Thread.sleep(3000);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.sonLabel);
		logger.pass("Clicked on Son Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.daughterLabel);
		logger.pass("Clicked on Daughter Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.fatherLabel);
		logger.pass("Clicked on Father Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.motherLabel);
		logger.pass("Clicked on Mother Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.othersLabel);
		logger.pass("Clicked on Others Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		if (driver.findElement(dG.familyRetirementAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyRetirementAgeErrorMsg).getText(),
					"Please enter retirement age");
			logger.pass("Error Message displayed is" + driver.findElement(dG.familyRetirementAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Retirement Age");
		}

		if (driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText(),
					"Please enter life expectancy age");
			logger.pass(
					"Error Message displayed is" + driver.findElement(dG.familyLifeExpectancyAgeErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Life Expectancy Age");
		}

		dG.genericClick(driver, dG.hufLabel);
		logger.pass("Clicked on HUF Label");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save and Add More Button");

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Please enter first name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Please enter last name");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		if (driver.findElement(dG.dobErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.dobErrorMsg).getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is" + driver.findElement(dG.dobErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for DOB");
		}

		if (driver.findElement(dG.occupationErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.occupationErrorMsg).getText(), "Please select occupation");
			logger.pass("Error Message displayed is" + driver.findElement(dG.occupationErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Occupation");
		}

		dG.genericClick(driver, dG.spouseLabel);
		logger.pass("Clicked on Spouse Label");
		Thread.sleep(2000);
		
		String familyFirstNameText = datagatheringList.get(27);
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		String familyLastNameText = datagatheringList.get(28);
		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.sonLabel);
		logger.pass("Clicked on Son Label");
		Thread.sleep(3000);
		
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.daughterLabel);
		logger.pass("Clicked on Daughter Label");
		Thread.sleep(3000);
		
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.fatherLabel);
		logger.pass("Clicked on Father Label");
		Thread.sleep(3000);
		

		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.motherLabel);
		logger.pass("Clicked on Mother Label");
		Thread.sleep(3000);
		
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.othersLabel);
		logger.pass("Clicked on Others Label");
		Thread.sleep(3000);
		
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}

		dG.genericClick(driver, dG.hufLabel);
		logger.pass("Clicked on HUF Label");
		Thread.sleep(3000);
		
		dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
		logger.pass("Enter Family First Name" + familyFirstNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
		logger.pass("Enter Family Last Name" + familyLastNameText);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		if (driver.findElement(dG.firstNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.firstNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.firstNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for First Name");
		}

		if (driver.findElement(dG.lastNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.lastNameErrorMsg).getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is" + driver.findElement(dG.lastNameErrorMsg).getText());
		} else {
			logger.fail("Error Message not displayed for Last Name");
		}
	}
}
