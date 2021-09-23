package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;
import java.util.Base64;

public class TC_DataGathering_008 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB = new DashBoard(driver);
	Billing bill = new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	 functions fun = new functions(driver);
	ArrayList<String> datagatheringList;
	String excelPath = readconfig.getExcelPath();
	int loginSize = 0;
	int rownum, rowsize;
	int equitySize, debtSize, realEstateSize, liquidSize, alternateSize, goldSize,otherSize;
    // @Test(priority=0)
	public void aA() throws InterruptedException {
    	 logger = extent.createTest("Register Yopmail");
 		extentTest.set(logger);
		fun.getAutoRegisterYopmailId(driver, "Sehwaag");
	}
	@Test(priority = 1)
	public void loginAndStartPlan() throws InterruptedException, IOException, AWTException {
		logger = extent.createTest("Login And Start plan");
		extentTest.set(logger);
		rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String className=Thread.currentThread().getStackTrace()[2].getClassName();
		System.out.println(className);
		String username;
		String pass;
		if(!className.contains("ExpertAdvisory")) {
	      username = XLUtils.getCellData(excelPath, "Login", family_try.increment, 0);
		   pass = XLUtils.getCellData(excelPath, "Login", family_try.increment, 1);}
		else {
			 username = XLUtils.getCellData(excelPath, "Login", TC_ExpertAdvisory.p, 0);
			 pass = XLUtils.getCellData(excelPath, "Login", TC_ExpertAdvisory.p, 1);
		}
		datagatheringList = new ArrayList<>();
		rowsize = XLUtils.getRowCount(excelPath, "Datagathering");
		int colsize = XLUtils.getCellCount(excelPath, "Datagathering", rowsize);

		Map<String, String> data01 = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize);
       // Assert.fail();
		String firstName = data01.get("FirstName");
		String lastName = data01.get("LastName");
		String pincode = data01.get("Pincode");
		String pan = data01.get("Pan");
		if (fun.isElementDisplayed(lp.loginLink)) {
		logger.pass("Login Started");
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Loggin Link");
		lp.genericSendKeys(driver, lp.emailMobTextBox, username);
		logger.pass("Entered email Id or mobile number " + username);
		lp.genericSendKeys(driver, lp.passwordTextBox, pass);
		logger.pass("Entered password " + pass);
		Thread.sleep(5000);
		String value1 = driver.findElement(By.id("captcha_code")).getAttribute("value");
		Base64.Decoder decoder = Base64.getDecoder();
		String captchaTxt = new String(decoder.decode(value1));
		lp.genericSendKeys(driver, lp.captchaText, captchaTxt);
		logger.pass("Entered Captcha is" + captchaTxt);
		lp.genericClick(driver, lp.loginButton);
		logger.pass("Clicked on LoginButton ");
		Assert.assertEquals(driver.getTitle(), "Fintoo");
		logger.pass("Login sucessful");}
		Thread.sleep(6000);
		functions fun = new functions(driver);
		if (fun.isElementDisplayed(dG.fintooCard))

		{

			// dB.clickStartPlan();
			// logger.pass("Clicked on Start Plan");
			Thread.sleep(6000);
			// dB.clickFP_AddCart();
			dB.genericClick(driver, dB.addToCart_FPButton);
			logger.pass("Clicked on Financial Planning Add to Cart");
			Thread.sleep(6000);
			// dB.clickApplyFintooOffer();
			dB.genericClick(driver, dB.applyFintoo);
			logger.pass("Clicked on Apply fintoo Offer");
			Thread.sleep(6000);
			dB.genericClick(driver, dB.startPlanButton);
			logger.pass("Clicked on Start My Plan");
			Thread.sleep(9000);

		}
		Thread.sleep(4000);
		if (fun.isElementDisplayed(lp.fillDetails)) {

			dG.genericSendKeys(driver, dG.firstName, firstName);
			logger.pass("First Name Entered in Profile" + " " + firstName);
			dG.genericSendKeys(driver, dG.lastName, lastName);
			logger.pass("Last Name Entered in Profile " + " " + lastName);
			dG.genericSendKeys(driver, dG.panNo, pan);
			logger.pass("Pan Entered in Profile " + " " + pan);
			dG.genericSendKeys(driver, dG.pinCode, pincode);
			logger.pass("Pincode Entered in Profile is " + " " + pincode);
			Thread.sleep(5000);
			dG.genericClick(driver, dG.camsSubmitButton);
			logger.pass("Clicked on Profile Submit Button");
			//Thread.sleep(18000);
			//if(!className.contains("ExpertAdvisory"))
			WebDriverWait wait=new WebDriverWait(driver,30);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(dB.startPlanButton));
              element.click();
			//functions.waitTillElementisDisplayed(dB.startPlanButton, 15);
			//dB.genericClick(driver, dB.startPlanButton);
			logger.pass("Clicked on Start My Plan");
			// functions.waitTillElementisDisplayed(bill.goToDataGathering,15);
			/*
			 * logger.pass(bill.paymentsucess());
			 * logger.pass("Total MRP is"+bill.totalMRP());
			 * logger.pass("Total GST is"+bill.totalGST());
			 * logger.pass("Total Amount Paid is"+bill.totalPaidAmount());
			 */
			//functions.waitTillElementisDisplayed(bill.goToDataGathering, 15);
			Thread.sleep(10000);
			//if(fun.fluentWait(driver, bill.goToDataGathering, 30000, 1000))
				if (fun.isElementDisplayed(bill.goToDataGathering)){
			bill.genericClick(driver, bill.goToDataGathering);
			logger.pass("Clicked on GoToDataGathering Button");}

		}

		if (fun.isElementDisplayed(dG.scoreCard)) {
			dG.genericClick(driver, dG.myPlan);
			logger.pass("Clicked on My Plan");
		}
		if (fun.isElementDisplayed(dG.continueButton01)) {
			dG.genericClick(driver, dG.continueButton01);
			logger.pass("Clicked on Continue Button");
		}
		Thread.sleep(8000);
		if (fun.isElementDisplayed(dG.signOffButton)) {
			dG.genericClick(driver, dG.dataGatheringButton);
			logger.pass("Clicked on DataGathering link");
		}
		Thread.sleep(3000);
		dG.genericClick(driver, dG.addDataButton);
		logger.pass("Clicked on Add Data Button");

	}

	@Test(priority = 2)
	public void dataGathering01() throws IOException, InterruptedException, AWTException {

		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AboutYouRequired");
		if (required.equalsIgnoreCase("Yes")) {
		logger = extent.createTest("Datagathering About You");
		extentTest.set(logger);
		Thread.sleep(3000);

		Map<String, String> data01 = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize);

		String firstName = data01.get("FirstName");
		String lastName = data01.get("LastName");
		String residentialAddress = data01.get("ResidentialAddress");
		String pincode = data01.get("Pincode");
		String emailID = data01.get("EmailAddress");
		String pan = data01.get("Pan");
		String mobileNo = data01.get("MobileNo");
		String alternateNumber = data01.get("AlernateNumber");
		String doB = data01.get("DOB");
		String age = data01.get("Age");	
		String salaryRange = data01.get("SalaryRange");
		String occupationTxt = data01.get("Occupation");
		String gender = data01.get("Gender");
		String retirementAge = data01.get("RetirementAge");
		String lifeExpectancy = data01.get("LifeExpectancy");
		String remarks = data01.get("Remarks");
		String currentStageLife = data01.get("CurrentStageLife");
		String familiarInvestMatter = data01.get("FamiliarInvestmentMatter");
		String howLongInvesting = data01.get("HowLongInvesting");
		String whatTermInvestMajMoney = data01.get("WhatTermInvestMajorityMoney");
		String mattersMoreInvest = data01.get("MattersMoreInvest");
		String assume100000 = data01.get("Assume100000");
		String investFell60000 = data01.get("InvestFell60000");
		String hypotheticalInvest100000 = data01.get("HypotheticalInvest100000");
		String factorsInvestFunds = data01.get("FactorsInvestFunds");
		String financialSecurity = data01.get("FinancialSecurity");

		if (!(lastName == null)) {
			// dG.genericSendKeys(driver, dG.firstName, datagatheringList.get(0));
			dG.genericSendKeys(driver, dG.firstName, firstName);
			logger.pass("First Name entered is" + " " + firstName);
			// dG.genericSendKeys(driver, dG.lastName, datagatheringList.get(1));
			dG.genericSendKeys(driver, dG.lastName, lastName);
			logger.pass("Last Name entered is" + " " + lastName);
			// dG.genericSendKeys(driver, dG.residentialAddress, datagatheringList.get(2));
			dG.genericSendKeys(driver, dG.residentialAddress, residentialAddress);
			logger.pass("Address entered is" + " " + residentialAddress);

			// dG.genericSendKeys(driver, dG.pinCode, datagatheringList.get(3));
			dG.genericSendKeys(driver, dG.pinCode, pincode);
			logger.pass("Pincode entered is" + " " + pincode);
			// dG.genericSendKeys(driver, dG.emailAddress, datagatheringList.get(4));
			dG.genericSendKeys(driver, dG.emailAddress, emailID);
			logger.pass("Email entered is" + " " + emailID);
			// dG.genericSendKeys(driver, dG.panNo, datagatheringList.get(5));
			dG.genericSendKeys(driver, dG.panNo, pan);
			logger.pass("Pan No. entered is" + " " + pan);
			// dG.genericSendKeys(driver, dG.mobileNo, datagatheringList.get(6));
			dG.genericSendKeys(driver, dG.mobileNo, mobileNo);
			logger.pass("Mobile Number entered is" + " " + mobileNo);
			// dG.genericSendKeys(driver, dG.alternateMobileNo, datagatheringList.get(7));
			dG.genericSendKeys(driver, dG.alternateMobileNo, alternateNumber);
			logger.pass("Alternate No. entered is" + " " + alternateNumber);
			dG.genericClick(driver, dG.dOB);
			calender01(doB);

			// String[] dob =datagatheringList.get(8).split("-");
			// String date= dob[0];
			// String month =dob[1];
			// month= month.substring(0, 3);
			// String year =dob[2];
			// calender(date, month, year);
			logger.pass("DOB entered is" + " " + doB);
			// String salary =datagatheringList.get(10);
			By salaryRange01 = By.xpath("//label[contains(text(),'" + salaryRange + "')]");
			// Thread.sleep(3000);
			dG.genericClick(driver, salaryRange01);
			logger.pass("Salary Range Selected is" + " " + salaryRange);
			// Thread.sleep(3000);
			// fun.scrollToElement(driver.findElement(dG.saveAndContinue));
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_TAB);
			ro.keyRelease(KeyEvent.VK_TAB);
			driver.findElement(By.xpath("(//span[@class='ui-selectmenu-text'])[1]")).click();
			// Thread.sleep(1000);
			try {
				driver.findElement(By.xpath("(//div[contains(text(),'" + occupationTxt + "')])[2]")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("(//div[contains(text(),'" + occupationTxt + "')])[1]")).click();
			}
			logger.pass("Occupation entered is" + occupationTxt);
			// Select ss= new
			// Select(driver.findElement(By.xpath("//select[@id='ui-id-1']")));
			// System.out.println(occupationTxt);
			// ss.selectByVisibleText(datagatheringList.get(11));
			// String genText =datagatheringList.get(12);
			By gender01 = By.xpath("(//label[text()='" + gender + "'])[1]");
			dG.genericClick(driver, gender01);
			logger.pass("Gender entered is" + gender);
			// String retrimentAge=datagatheringList.get(13);
			dG.genericSendKeys(driver, dG.retirementAge, retirementAge);
			logger.pass("Retirement Age entered is" + " " + retirementAge);
			// String lifeExpectancy = datagatheringList.get(14);
			dG.genericSendKeys(driver, dG.lifeExpectancy, lifeExpectancy);
			logger.pass("Life Expectancy Age entered is" + " " + lifeExpectancy);
			if (!(remarks == null)) {
				// dG.genericSendKeys(driver, dG.remark, datagatheringList.get(15));
				dG.genericSendKeys(driver, dG.remark, remarks);
				logger.pass("Remark entered is" + " " + remarks);
			}
		}
		dG.genericClick(driver, dG.saveAndContinue);
		logger.pass("Clicked on Save and Continue");
		Thread.sleep(5000);
		// String currentStageText = datagatheringList.get(16);
		if (!(currentStageLife == null)) {
			By currentStageOfLife01 = By.xpath("//label[contains(text(),'" + currentStageLife + "')]");
			Thread.sleep(8000);
			fun.scrollToElementUp(driver.findElement(currentStageOfLife01));
			dG.genericClick(driver, currentStageOfLife01);
			logger.pass("Selected " + " " + currentStageLife);
			Thread.sleep(3000);
			if (fun.isElementDisplayed(dG.nextButton1)) {
				dG.genericClick(driver, dG.nextButton1);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton1);
			logger.pass("Clicked on Save Button ");

			// String familiarInvestText= datagatheringList.get(17);
			By familiarInvest = By.xpath("//label[contains(text(),'" + familiarInvestMatter + "')]");
			// fun.scrollToElement(driver.findElement(familiarInvest));
			fun.scrollToElement(driver.findElement(familiarInvest));
			Thread.sleep(6000);
			dG.genericClick(driver, familiarInvest);
			logger.pass("Selected " + " " + familiarInvestMatter);
			if (fun.isElementDisplayed(dG.nextButton2)) {
				dG.genericClick(driver, dG.nextButton2);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton2);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String howLongInvestText= datagatheringList.get(18);
			By howLongInvest = By.xpath("//label[contains(text(),'" + howLongInvesting + "')]");
			fun.scrollToElement(driver.findElement(howLongInvest));
			// Thread.sleep(3000);

			dG.genericClick(driver, howLongInvest);
			logger.pass("Selected " + " " + howLongInvesting);
			Thread.sleep(3000);
			if (fun.isElementDisplayed(dG.nextButton3)) {
				dG.genericClick(driver, dG.nextButton3);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton3);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String durationMajorityMoneyInvestText= datagatheringList.get(19);
			By durationMajorityMoneyInvest = By
					.xpath("(//label[contains(text(),'" + whatTermInvestMajMoney + "')])[1]");
			By durationMajorityMoneyInvest2 = By
					.xpath("(//label[contains(text(),'" + whatTermInvestMajMoney + "')])[2]");
			fun.scrollToElement(driver.findElement(durationMajorityMoneyInvest));
			try {
				fun.waitTillElementClickable(durationMajorityMoneyInvest);
				dG.genericClick(driver, durationMajorityMoneyInvest);
			} catch (Exception e) {
				fun.waitTillElementClickable(durationMajorityMoneyInvest2);
				dG.genericClick(driver, durationMajorityMoneyInvest2);
			}
			logger.pass("Selected " + " " + whatTermInvestMajMoney);
			if (fun.isElementDisplayed(dG.nextButton4)) {
				dG.genericClick(driver, dG.nextButton4);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton4);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			String[] text = mattersMoreInvest.split(",");
			String matterMoreInvesttext = text[0];
			By matterMoreInvest01 = By.xpath("//label[contains(text(),'" + matterMoreInvesttext + "')]");
			fun.scrollToElement(driver.findElement(matterMoreInvest01));
			fun.waitTillElementClickable(matterMoreInvest01);
			dG.genericClick(driver, matterMoreInvest01);
			logger.pass("Selected " + " " + mattersMoreInvest);
			if (fun.isElementDisplayed(dG.nextButton5)) {
				dG.genericClick(driver, dG.nextButton5);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton5);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String assume100kText= datagatheringList.get(21);
			By assume100k = By.xpath("//label[contains(text(),'" + assume100000 + "')]");
			fun.scrollToElement(driver.findElement(assume100k));
			// Thread.sleep(3000);
			dG.genericClick(driver, assume100k);
			logger.pass("Selected " + " " + assume100000);
			if (fun.isElementDisplayed(dG.nextButton6)) {
				dG.genericClick(driver, dG.nextButton6);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton6);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String investmentFell60kText= datagatheringList.get(22);
			By investmentFell60k = By.xpath("//label[contains(text(),'" + investFell60000 + "')]");
			fun.scrollToElement(driver.findElement(investmentFell60k));
			// Thread.sleep(3000);
			dG.genericClick(driver, investmentFell60k);
			logger.pass("Selected " + " " + investFell60000);
			if (fun.isElementDisplayed(dG.nextButton7)) {
				dG.genericClick(driver, dG.nextButton7);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton7);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String hypothticalInvest100kText= datagatheringList.get(23);
			By hypothticalInvest100k = By.xpath("//label[contains(text(),'" + hypotheticalInvest100000 + "')]");
			fun.scrollToElement(driver.findElement(hypothticalInvest100k));
			// Thread.sleep(3000);
			dG.genericClick(driver, hypothticalInvest100k);
			logger.pass("Selected " + " " + hypotheticalInvest100000);
			if (fun.isElementDisplayed(dG.nextButton8)) {
				dG.genericClick(driver, dG.nextButton8);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton8);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(3000);
			// String factorsInvestFundsText= datagatheringList.get(24);
			By factorsInvestFunds01 = By.xpath("//label[contains(text(),'" + factorsInvestFunds + "')]");
			fun.scrollToElement(driver.findElement(factorsInvestFunds01));
			dG.genericClick(driver, factorsInvestFunds01);
			logger.pass("Selected " + " " + factorsInvestFunds);
			if (fun.isElementDisplayed(dG.nextButton9)) {
				dG.genericClick(driver, dG.nextButton9);
			}
			dG.genericClick(driver, dG.dataGatheringSaveButton9);
			logger.pass("Clicked on Save Button ");
			Thread.sleep(6000);
			// String financialSecurityText= datagatheringList.get(25);
			By financialSecurity01 = By.xpath("//label[contains(text(),'" + financialSecurity + "')]");
			fun.scrollToElement(driver.findElement(financialSecurity01));
			dG.genericClick(driver, financialSecurity01);
			logger.pass("Selected " + " " + financialSecurity);
			dG.genericClick(driver, dG.dataGatheringSaveButton10);
			logger.pass("Clicked on Save Button ");
		}
		Thread.sleep(6000);
		dG.genericClick(driver, dG.dGContinueButton);
		logger.pass("Clicked on Continue Button ");
		if(fun.isElementDisplayed(dG.beforeFamilyPopUp)) {
			dG.genericClick(driver, dG.beforeFamilyPopUp);
			logger.pass("Clicked on PopUp");
		}
		int familySize = loginSize;
		for (int z = loginSize; z < rowsize; z++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
			String familyDetailText = data.get("FamilyDetails");
			if (!(familyDetailText == null)) {
				familySize++;
			} else {
				break;
			}

		}

		for (int i = loginSize; i < familySize; i++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
			String familyDetailText = data.get("FamilyDetails");
			if (!(familyDetailText == null)) {
				// String familyDetailText= data.get("FamilyDetails");
				By familyDetail = By.xpath("//label[contains(.,'" + familyDetailText + "')]");
				Thread.sleep(10000);
				if (!familyDetailText.contains("Spouse")) {
					dG.genericClick(driver, familyDetail);
				}
				logger.pass("Clicked on " + familyDetailText);
				Thread.sleep(6000);
				String familyFirstNameText = data.get("FFirstName");
				dG.genericSendKeys(driver, dG.familyFirstName, familyFirstNameText);
				logger.pass("Enter Family First Name" + familyFirstNameText);
				// Thread.sleep(6000);
				String familyLastNameText = data.get("FLastName");
				dG.genericSendKeys(driver, dG.familyLastName, familyLastNameText);
				logger.pass("Enter Family Last Name" + familyLastNameText);
				// Thread.sleep(6000);
				if (familyDetailText.contains("Spouse") || familyDetailText.contains("Others")) {
					String familyGenderText = data.get("Fgender");
					By familyGender = By.xpath("(//label[contains(text(),'" + familyGenderText + "')])[2]");
					dG.genericClick(driver, familyGender);
					logger.pass("Enter Family Gender is " + familyGenderText);
				}
				// Thread.sleep(6000);
				String familyDependantStatusText = data.get("FDependencyStatus");
				By familyDependantStatus = By.xpath("//label[contains(text(),'" + familyDependantStatusText + "')]");
				dG.genericClick(driver, familyDependantStatus);
				logger.pass("Clicked on dependency status " + familyDependantStatusText);
				// Thread.sleep(6000);
				if (familyDependantStatusText.contains("Earning")) {
					String occupation = data.get("Foccupation");
					driver.findElement(By.xpath("(//span[@class='ui-selectmenu-text'])[2]")).click();
					try {
						driver.findElement(By.xpath("(//div[contains(text(),'" + occupation + "')])[2]")).click();
					} catch (Exception e) {
						driver.findElement(By.xpath("(//div[contains(text(),'" + occupation + "')])[1]")).click();
					}

					logger.pass("Clicked on Occupation " + occupation);
				}
				// Thread.sleep(6000);
				dG.genericClick(driver, dG.familyDob);
				String familyDOB = data.get("FDOB");
				calender01(familyDOB);
				logger.pass("Selected Family DOB" + familyDOB);

				if (familyDependantStatusText.contains("Earning")) {
					String familyRetirementAgeText = data.get("FRetirementAge");
					dG.genericSendKeys(driver, dG.familyRetirementAge, familyRetirementAgeText);
					logger.pass("Entered family member Retirement age" + familyRetirementAgeText);
					String familyLifeExpectancyText = data.get("FLifeExpectancy");
					dG.genericSendKeys(driver, dG.familyLifeExpectancy, familyLifeExpectancyText);
					logger.pass("Entered family member Life Expectancy age" + familyLifeExpectancyText);
					String FamilysalaryText = data.get("FSalaryRange");
					By FamilysalaryRange = By.xpath("(//label[contains(text(),'" + FamilysalaryText + " ')])[2]");
					dG.genericClick(driver, FamilysalaryRange);
					logger.pass("Clicked on Family Salary is" + FamilysalaryText);
				}

				dG.genericClick(driver, dG.familySaveAddMoreButton);
				logger.pass("Clicked on Save and Add more Button");
			} else {
				break;
			}
		}
		}

	}

	@Test(priority = 3)
	public void incomeExpensePositive() throws InterruptedException, AWTException, IOException {
		
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("IncomeRequired");
		if (required.equalsIgnoreCase("Yes")) {
		logger = extent.createTest("Datagathering Income And Expenses");
		extentTest.set(logger);

		// Income and Expense Section
		dG.genericClick(driver, dG.incomeAndExpenseButton);
		logger.pass("Clicked on income&Expenses Link");
		Thread.sleep(5000);
		dG.genericClick(driver, dG.incomeAndExpenseButton);
		int paymentNatureSize = loginSize;
		for (int z = loginSize; z < rowsize; z++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
			String paymentNature = data.get("NaturePayment");
			if (!(paymentNature == null)) {
				paymentNatureSize++;
			} else {
				break;
			}

		}

		for (int i = loginSize; i < paymentNatureSize; i++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
			String paymentNatureText = data.get("NaturePayment");
			if (!(paymentNatureText == null)) {
				By paymentNature = By.xpath("//label[contains(.,'" + paymentNatureText + "')]");
				if (!paymentNatureText.contains("Salary & Bonus")) {
					dG.genericClick(driver, paymentNature);
				}
				logger.pass("Clicked on" + paymentNatureText);
				String incomeName = data.get("IncomeName");
				dG.genericSendKeys(driver, dG.incomeNameText, incomeName);
				logger.pass("Entered Salary Name " + incomeName);
				String incomeValue = data.get("IncomeValue");
				dG.genericSendKeys(driver, dG.incomeValueText, incomeValue);
				logger.pass("Entered Salary Value " + incomeValue);
				dG.genericClick(driver, dG.incomeFrom);
				logger.pass("Clicked on Income from DropDown");

				String incomeFromTxt = data.get("IncomeFrom");
				By incomeFromElement = By.xpath("(//div[text()=' " + incomeFromTxt + " '])[1]");
				By incomeFromElement2 = By.xpath("(//div[text()=' " + incomeFromTxt + " '])[2]");
				Thread.sleep(3000);
				try {
					dG.genericClick(driver, incomeFromElement);
					dG.genericClick(driver, incomeFromElement2);
				} catch (Exception e) {
					// dG.genericClick(driver, incomeFromElement2);
				}
				logger.pass("Clicked on Income From" + incomeFromTxt);
				String toggleText = data.get("IncomeFixedorVariable");

				if (!toggleText.contains("Fixed")) {
					dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
				}
				logger.pass("Selected income is" + toggleText);
				String toggleRecurringText = data.get("IncomeOneTimeorRecurring");

				if((paymentNatureText.equals("Gifts") || paymentNatureText.equals("Other"))) {
				if (!toggleRecurringText.contains("One Time")) {
					dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
				}
				logger.pass("Selected income Type is" + toggleRecurringText);
				if (!toggleRecurringText.contains("One Time")) {
					dG.genericClick(driver, dG.incomeStartDate);
					String incomeStartDate = data.get("IncomeStartDate");
					calender01(incomeStartDate);
					logger.pass("Selected Income End Date is " + incomeStartDate);
					String EndDateText = data.get("IncomeEndDate");
					By EndDate = By.xpath("//label[contains(.,'" + EndDateText + "')]");
					dG.genericClick(driver, EndDate);
					logger.pass("Clicked on End Date" + EndDateText);
					Thread.sleep(4000);
					String annualGrowthRateText = data.get("AnnualGrowthRate");
					int slidervalue = Integer.parseInt(annualGrowthRateText);
					int aa = (slidervalue * 10) - 100;

					WebElement slider = driver.findElement(dG.annualGrowthSlider);
					Actions move = new Actions(driver);
					Action action = (Action) move.dragAndDropBy(slider, aa, 0).build();
					action.perform();
					logger.pass("Selected Annual grwth Rate is" + annualGrowthRateText);

					String frequencyTxt = data.get("Frequency");
					By frequencyValue = By.xpath("//label[contains(.,'" + frequencyTxt + "')]");
					dG.genericClick(driver, frequencyValue);
					logger.pass("Frequency selected is " + " " + frequencyTxt);
				} else {
					dG.genericClick(driver, dG.incomeEndDate);
					String EndDateText = data.get("IncomeEndDate");
					calender01(EndDateText);
					logger.pass("Selected End Date is" + EndDateText);
				}
				}
				else {
					
					if (!toggleRecurringText.contains("Recurring")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Selected income Type is" + toggleRecurringText);
					if (!toggleRecurringText.contains("Recurring")) {

						dG.genericClick(driver, dG.incomeEndDate);
						String EndDateText = data.get("IncomeEndDate");
						calender01(EndDateText);
						logger.pass("Selected End Date is" + EndDateText);
						
						
					} else {
						
						dG.genericClick(driver, dG.incomeStartDate);
						String incomeStartDate = data.get("IncomeStartDate");
						calender01(incomeStartDate);
						logger.pass("Selected Income End Date is " + incomeStartDate);
						String EndDateText = data.get("IncomeEndDate");
						By EndDate = By.xpath("//label[contains(.,'" + EndDateText + "')]");
						dG.genericClick(driver, EndDate);
						logger.pass("Clicked on End Date" + EndDateText);
						Thread.sleep(4000);
						String annualGrowthRateText = data.get("AnnualGrowthRate");
						int slidervalue = Integer.parseInt(annualGrowthRateText);
						int aa = (slidervalue * 10) - 100;

						WebElement slider = driver.findElement(dG.annualGrowthSlider);
						Actions move = new Actions(driver);
						Action action = (Action) move.dragAndDropBy(slider, aa, 0).build();
						action.perform();
						logger.pass("Selected Annual grwth Rate is" + annualGrowthRateText);

						By freqDropDown = By.xpath("(//span[@role='combobox'])[2]");
						dG.genericClick(driver, freqDropDown);
						String frequencyTxt = data.get("Frequency");
						By frequencyValue = By.xpath("//div[text()=' "+frequencyTxt+"']");
						dG.genericClick(driver, frequencyValue);
						logger.pass("Frequency selected is " + " " + frequencyTxt);
						
					}

					
				}

				dG.genericClick(driver, dG.saveAddMoreButton);
				logger.pass("Clicked on Save and Add more Button");
				Thread.sleep(6000);
				
			}

			else {
				break;
			}
		}
		dG.genericClick(driver, dG.dGContinueButton);
		logger.pass("Clicked on Continue Button");}

		String required01 = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("ExpenseRequired");
		if (required01.equalsIgnoreCase("Yes")) {
		dG.genericClick(driver, dG.buttonExpenses);
		logger.pass("Clicked on income&Expenses Link");
		dG.genericClick(driver, dG.expenseTab);
		logger.pass("Clicked on Expense Tab");
		int expenseSize = loginSize;
		for (int z = loginSize; z < rowsize; z++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
			String expensecat = data.get("ExpenseCategory");
			if (!(expensecat == null)) {
				expenseSize++;
			} else {
				break;
			}

		}

		for (int i = loginSize; i < expenseSize; i++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
			String expenseCatogeryTxt = data.get("ExpenseCategory");
			if (!(expenseCatogeryTxt == null)) {
				By expenseCatogeryElement = By.xpath("//label[contains(.,'" + expenseCatogeryTxt + "')]");
				if (!expenseCatogeryTxt.contains("House Expenses")) {
					dG.genericClick(driver, expenseCatogeryElement);
				}

				logger.pass("Category selected is " + " " + expenseCatogeryTxt);

				String expenseNameTxt = data.get("ExpenseName");
				dG.genericSendKeys(driver, dG.expenseNameText, expenseNameTxt);
				logger.pass("Expense Name Entered is " + " " + expenseNameTxt);

				String expenseValueTxt = data.get("ExpenseValue");
				dG.genericSendKeys(driver, dG.expenseValueText, expenseValueTxt);
				logger.pass("Expense Value Entered is " + " " + expenseValueTxt);

				String expenseForTxt = data.get("ExpenseFor");
				By expenseForElement = By.xpath("(//div[contains(text(),'" + expenseForTxt + " ')])[1]");
				By expenseForElement2 = By.xpath("(//div[contains(text(),'" + expenseForTxt + " ')])[2]");
			//	fun.scrollToElement(driver.findElement(dG.expenseForDropDown));
				dG.genericClick(driver, dG.expenseForDropDown);
				try {
					dG.genericClick(driver, expenseForElement2);
					dG.genericClick(driver, expenseForElement);
				} catch (Exception e) {

				}
				logger.pass("Dropdown Value Selected is " + " " + expenseForTxt);

				String expenseFixVarTxt = data.get("Expensefix0rVar");
				By expenseFixVar = By.xpath("(//span[@class='slider round'])[3]");
				if (expenseFixVarTxt.contains("Variable")) {
					dG.genericClick(driver, expenseFixVar);
				}
				logger.pass(" Selected is " + " " + expenseFixVarTxt);

				String expenseMandWishTxt = data.get("ExpenseMandorWishful");
				By expenseMandWish = By.xpath("(//span[@class='slider round'])[4]");
				if (expenseMandWishTxt.contains("Wishful")) {
					dG.genericClick(driver, expenseMandWish);
				}
				logger.pass("Selected is " + " " + expenseMandWishTxt);

				String expenseOneRecurrTxt = data.get("ExpenseOneorRecurr");
				By expenseOneRecurr = By.xpath("(//span[@class='slider round'])[5]");
				if(expenseCatogeryTxt.contains("Club Membership and Subscriptions")||expenseCatogeryTxt.contains("Hotel Leisure and Entertainment")||expenseCatogeryTxt.contains("Gifts")||expenseCatogeryTxt.contains("Other")) {
				if (expenseOneRecurrTxt.contains("Recurring")) {
					dG.genericClick(driver, expenseOneRecurr);
				}}
				else {
					if (!(expenseOneRecurrTxt.contains("Recurring"))) {
						dG.genericClick(driver, expenseOneRecurr);
					}
					
				}
				logger.pass("Dropdown Value Selected is " + " " + expenseOneRecurrTxt);
           try {
				String expenseInflationRateText = data.get("ExpenseInflationRate");
				int slidervalue1 = Integer.parseInt(expenseInflationRateText);
				int aa1 = (slidervalue1 * 10) - 100;

				WebElement slider1 = driver.findElement(dG.annualGrowthSlider);

				Actions move = new Actions(driver);
				Action action1 = (Action) move.dragAndDropBy(slider1, aa1, 0).build();
				action1.perform();
				logger.pass("Selected Annual grwth Rate is" + " " + expenseInflationRateText);}
           catch(Exception e) {
        	   e.printStackTrace();
           }
				

				dG.genericClick(driver, dG.expenseStartDate);
				String expenseStartDate = data.get("ExpenseStartDate");

				calender01(expenseStartDate);
				logger.pass("Selected Expense Start Date" + expenseStartDate);

				String uptoAgeTxt = data.get("ExpenseuptoAge");
				By uptoAge = By.xpath("(//label[contains(.,'" + uptoAgeTxt + "')])[2]");
				dG.genericClick(driver, uptoAge);
				logger.pass("Expenses End Date  is " + " " + uptoAgeTxt);

				
				//By expenseFrequency = By.xpath("//label[contains(.,'" + expenseFrequencyTxt + "')]");
				//dG.genericClick(driver, expenseFrequency);
				
				
				By freqDropDown = By.xpath("(//span[@role='combobox'])[4]");
				dG.genericClick(driver, freqDropDown);
				String expenseFrequencyTxt = data.get("ExpenseFrequency");
				By expenseFrequency = By.xpath("//div[text()=' "+expenseFrequencyTxt+"']");
				dG.genericClick(driver, expenseFrequency);
				logger.pass("Expenses Frequency is " + " " + expenseFrequencyTxt);

				dG.genericClick(driver, dG.expenseSaveAddMoreButton);
				logger.pass("Clicked on Save And AddMore");
				Thread.sleep(10000);
				
				if(fun.isElementDisplayed(dG.incomeExpPopUp)) {
					dG.genericClick(driver, dG.incomeExpPopUp);
					logger.pass("Clicked on Income-Exp PopUp");
				}
			}
		}
	}

	}

	// Goal Module Positive Scenarios
	@Test(priority = 4)
	public void goalsPositive() throws InterruptedException, AWTException, IOException {
		
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("GoalsRequired");
		if (required.equalsIgnoreCase("Yes")) {
		logger = extent.createTest("Datagathering Goals Positive");
		extentTest.set(logger);
		dG.genericClick(driver, dG.goalLink);
		logger.pass("Clicked on Goal Link");
		int goalSize = loginSize;
		for (int z = loginSize; z < rowsize; z++) {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
			String goalNat = data.get("NatureofGoal");
			if (!(goalNat == null)) {
				goalSize++;
			} else {
				break;
			}

		}
		List<Map<String, String>> sheetData = fun.getTestDataInMap(excelPath, "Datagathering");
		for (int i = loginSize; i < goalSize; i++) {
			Map<String, String> data = sheetData.get(i);
			String natureGoal = data.get("NatureofGoal");// datagatheringList.get(65);
			if (!(natureGoal == null)) {
				By natureGoalElement = By.xpath("//label[contains(.,'" + natureGoal + "')]");
				dG.genericClick(driver, natureGoalElement);
				logger.pass("Nature of Goal Selected is" + natureGoal);
				String goalName = data.get("GoalName"); // datagatheringList.get(66);
				dG.genericSendKeys(driver, dG.goalNameTxt, goalName);
				logger.pass("Goal name Entered is" + " " + goalName);
				// Select s = new Select(driver.findElement(dG.goalForSelect));
				dG.genericClick(driver, dG.goalForSelect);
				String goalForTxt = data.get("GoalFor"); // datagatheringList.get(67);
				// s.selectByVisibleText(goalForTxt);
				By goalForElement = By.xpath("//div[contains(text(),'" + goalForTxt + "')]");

				dG.genericClick(driver, goalForElement);
				logger.pass("Selected Goal is For" + " " + goalForTxt);
				String presentGoalCost = data.get("PresentCostGoal"); // datagatheringList.get(68);
				dG.genericSendKeys(driver, dG.goalPresentValueTxt, presentGoalCost);
				logger.pass("Present value of Goal Entered is" + " " + presentGoalCost);

				if (natureGoal.equals("Education")) {
					String goalType = data.get("TypeofGoal");// datagatheringList1.get(69);
					// Select s1 = new Select(driver.findElement(dG.goalEduTypeSelect));
					dG.genericClick(driver, dG.goalEduTypeSelect);
					By goalTypeElement = By.xpath("//div[contains(text(),'" + goalType + "')]");
					dG.genericClick(driver, goalTypeElement);
					// s1.selectByVisibleText(goalType);
					logger.pass("Selected Goal type is" + " " + goalType);
				}

				String goalPriority = data.get("GoalPriority");// datagatheringList.get(70);
				dG.genericClick(driver, dG.goalPrioritySelect);
				By goalPriorityElement = By.xpath("//div[contains(text(),'" + goalPriority + "')]");
				if (goalPriority.equals("High")) {
					By goalPriorityElement1 = By.xpath("(//div[contains(text(),'" + goalPriority + "')])[2]");
					dG.genericClick(driver, goalPriorityElement1);
				}
				dG.genericClick(driver, goalPriorityElement);
				// Select s2 = new Select(driver.findElement(dG.goalPrioritySelect));
				// s2.selectByVisibleText(goalPriority);
				logger.pass("Selected Goal Priority is" + " " + goalPriority);

				// String[] goalInflationRateText1=
				// data.get("GoalInflationRate").split(".");//datagatheringList.get(71);
				// String goalInflationRateText=goalInflationRateText1[0];
				String goalInflationRateText = data.get("GoalInflationRate");
				int slidervalue1 = Integer.parseInt(goalInflationRateText);
				int aa1 = (slidervalue1 * 15) - 150;

				WebElement slider1 = driver.findElement(dG.annualGrowthSlider);
				Actions move = new Actions(driver);
				if (natureGoal.equals("Marriage") || natureGoal.equals("Vehicle") || natureGoal.equals("Vacation")) {
					Action action1 = (Action) move.dragAndDropBy(slider1, 45, 0).build();
					action1.perform();
				}

				if (natureGoal.equals("Emergency") || natureGoal.equals("Others")) {
					Action action1 = (Action) move.dragAndDropBy(slider1, 60, 0).build();
					action1.perform();
				}

				Action action1 = (Action) move.dragAndDropBy(slider1, aa1, 0).build();
				action1.perform();
				logger.pass("Selected Goal Inflation Rate is" + " " + goalInflationRateText);

				String criticalorNonCritical = data.get("GoalCritical");// datagatheringList.get(72);
				if (criticalorNonCritical.contains("Critical")) {
					dG.genericClick(driver, dG.criticalNonCriticalToggle);
				}
				logger.pass("Clicked on Toggle" + " " + criticalorNonCritical);

				String oneTRecurr = data.get("GoalOneTimeorRecurr");// datagatheringList.get(73);
				if (!oneTRecurr.contains("One")) {
					dG.genericClick(driver, dG.oneTimeRecurrToggle);
					logger.pass("Clicked on Toggle" + " " + oneTRecurr);
					dG.genericClick(driver, dG.goalStartDate);
					String[] goalStartDate = data.get("GoalStartDate").split("-"); // datagatheringList.get(74).split("-");
					String date03 = goalStartDate[0];
					String month03 = goalStartDate[1];
					month03 = month03.substring(0, 3);
					String year03 = goalStartDate[2];
					calender(date03, month03, year03);
					logger.pass("Selected Goal Start Date" + " " + goalStartDate);

					if (goalForTxt.equals("Self")) {
						String endUpto = data.get("GoalEndDate"); // datagatheringList.get(75);
						By endUptoElement = By.xpath("//label[contains(.,'" + endUpto + "')]");
						dG.genericClick(driver, endUptoElement);
						logger.pass("Selected Age is" + " " + endUpto);
					}
					if (goalForTxt.equals("Family")) {

						dG.genericClick(driver, dG.goalEndDate);
						String goalendDate1 = data.get("GoalEndDate"); // datagatheringList.get(74).split("-");
						String[] goalendDate = goalendDate1.split("-");
						String date = goalendDate[0];
						String month = goalendDate[1];
						month = month.substring(0, 3);
						String year = goalendDate[2];
						calender(date, month, year);
						logger.pass("Selected Goal Start Date" + " " + goalendDate1);

					}

					String frequencyTxt = data.get("GoalFrequency");// datagatheringList.get(76);
					//By frequencyElement = By.xpath("//label[contains(.,'" + frequencyTxt + "')]");
					//dG.genericClick(driver, frequencyElement);
					//logger.pass("Selected Frequency is" + " " + frequencyTxt);
					
					By freqDropDown = By.xpath("(//span[@role='combobox'])[3]");
					dG.genericClick(driver, freqDropDown);
					//String frequencyTxt = data.get("Frequency");
					By frequencyValue = By.xpath("//div[text()=' "+frequencyTxt+"']");
					dG.genericClick(driver, frequencyValue);
					logger.pass("Frequency selected is " + " " + frequencyTxt);


				} else {

					logger.pass("Clicked on Toggle" + " " + oneTRecurr);
					dG.genericClick(driver, dG.oneTGoalDate);
					String goalEndDate1 = data.get("GoalEndDate"); // datagatheringList.get(75).split("-");
					String[] goalEndDate = goalEndDate1.split("-");
					String date03 = goalEndDate[0];
					String month03 = goalEndDate[1];
					month03 = month03.substring(0, 3);
					String year03 = goalEndDate[2];
					calender(date03, month03, year03);
					logger.pass("Selected Goal End Date" + " " + goalEndDate1);

				}
				dG.genericClick(driver, dG.goalSaveAndAddMore);
				logger.pass("Clicked on Save Add more Button");
				Thread.sleep(4000);

			} else {
			}
			if(fun.isElementDisplayed(dG.goalsPopUp)) {
				dG.genericClick(driver, dG.goalsPopUp);
				logger.pass("Clicked on Goals PopUp");
			}
		}}
	}

	@Test(priority = 5)
	public void assetsEquityPostive() throws IOException, InterruptedException, AWTException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			equitySize = loginSize;
			for (int z = loginSize; z < rowsize; z++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String equityCat = data.get("AssetCategory");
				if ((equityCat.contains("Equity"))) {
					equitySize++;
				} else {
					break;
				}

			}

			for (int i = loginSize; i < equitySize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String OneOrRecurr = data.get("EquityRecurring");
				String purchaseDate = data.get("DateofPurchase");
				String numOfShares = data.get("NoOfShares");
				String purchasePrice = data.get("PurchasePrice");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String currentPrice = data.get("CurrentPrice");
				String startDateSIP = data.get("SIPStartDate");
				String amountSIP = data.get("SIPAmount");
				String totalInvestedValueSIP = data.get("TotalInvestedValue");
				String endDateSIP = data.get("SIPEndDate");
				String uptoAgeMFSIP = data.get("UptoAgeOnlyMF");
				String mfELSS = data.get("MFELSS");
				String uploadOrManual= data.get("UploadOrManual");
				String docmentPath = data.get("CamsKarveyDocumentPath");
				String documentPassword = data.get("camsKarveyPassword");

				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);
					

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + driver.findElement(category).getText());

					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}
					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);
					
					if(assetSubCategory.contains("Equity Shares") || assetSubCategory.contains("Equity Mutual Funds") ) {
						if(uploadOrManual.contains("Upload")) {
							uploadAsset(docmentPath, documentPassword, assetSubCategory);
						}
						else {
						  dG.genericClick(driver, dG.manualEquityButton);
						  logger.pass("Clicked on ManualForm Button");
						}
					}
					
					if (assetSubCategory.contains("Equity Shares")
							|| assetSubCategory.contains("Equity Mutual Funds")) {
						dG.genericClick(driver, dG.startSearchDropDown);
						logger.pass("Clicked on Search DropDown");
						By assetName = By.xpath("//span[text()='" + nameAsset + "']");
						dG.genericClick(driver, assetName);
						logger.pass("Clicked on Scrip" + " " + driver.findElement(assetName).getText());
					} else {
						dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
						logger.pass("Entered Scrip name is" + " " + nameAsset);

					}
					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);
					dG.genericClick(driver, dG.investmentFor);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);
					if (mfELSS.contains("Yes") && assetSubCategory.contains("Equity Mutual Funds")) {
						dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
						logger.pass("Selected ELSS as Yes");
					} else if (assetSubCategory.contains("Equity Mutual Funds")) {
						logger.pass("Selected ELSS as No");
					}

					if (!OneOrRecurr.contains("One Time")) {
						if (assetSubCategory.contains("Equity Mutual Funds")) {
							dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");
						} else {
							dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");
						}
						if (!(uptoAgeMFSIP.contains("Perpetual") && assetSubCategory.contains("Equity Mutual Funds"))) {
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(startDateSIP);
							logger.pass("Purchase Date Entered is" + " " + startDateSIP);
						}
						dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
						logger.pass("SIP Amount Entered is" + " " + amountSIP);
						dG.genericSendKeys(driver, dG.investmentAmounTxt, totalInvestedValueSIP);
						logger.pass("Total Invested Value Entered is" + " " + totalInvestedValueSIP);
						dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
						logger.pass("Number of Shares Entered is" + " " + numOfShares);
						if (!(assetSubCategory.contains("Equity Mutual Funds") && !uptoAgeMFSIP.contains("0"))) {
							dG.genericClick(driver, dG.sipEndDateTxt);
							calender01(endDateSIP);
							logger.pass("SIP End Date Entered is" + " " + endDateSIP);
						} else {
							By uptoAge = By.xpath("//label[contains(.,'" + uptoAgeMFSIP + "')]");
							dG.genericClick(driver, uptoAge);
							logger.pass("Selected option is" + " " + uptoAge);
						}

					} else {
						logger.pass("Clicked on Toggle Button" + " " + OneOrRecurr);
						dG.genericClick(driver, dG.assetPurchaseDate);
						calender01(purchaseDate);
						logger.pass("Purchase Date Entered is" + " " + purchaseDate);
						dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
						logger.pass("Number of Shares Entered is" + " " + numOfShares);
						dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
						logger.pass("Purchase Price Entered is" + " " + purchasePrice);
					}
					if (!(assetSubCategory.contains("Equity Shares")
							|| assetSubCategory.contains("Equity Mutual Funds"))) {
						dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
						logger.pass("Entered Current Price is" + " " + currentPrice);
					}

					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");
				}
				
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}
		

	}

	@Test(priority = 6)
	public void assetDebtPositive() throws InterruptedException, AWTException, IOException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			debtSize = equitySize;
			for (int z = equitySize; z < rowsize; z++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String debtCat = data.get("AssetCategory");
				if ((debtCat.contains("Debt"))) {
					debtSize++;
				} else {
					break;
				}

			}
			for (int i = equitySize; i < debtSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String purchaseDate = data.get("DateofPurchase");
				String purchasePrice = data.get("PurchasePrice");
				String debtMaturityDate = data.get("DebtMaturityDate");
				String debtMaturityAmount = data.get("DebtMaturityAmount");
				String OneOrRecurr = data.get("EquityRecurring");
				String numOfShares = data.get("NoOfShares");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String rateOfReturn = data.get("RateOfReturn");
				String accountBalanceOn = data.get("AccountBalanceOn");
				String frequencyTxt = data.get("Frequency");

				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + driver.findElement(category).getText());

					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}

					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);
					if (assetSubCategory.contains("Debt Mutual Funds")) {
						dG.genericClick(driver, dG.startSearchDropDown);
						logger.pass("Clicked on Search DropDown");
						By assetName = By.xpath("//span[text()='" + nameAsset + "']");
						dG.genericClick(driver, assetName);
						logger.pass("Clicked on Scrip" + " " + driver.findElement(assetName).getText());
					} else {
						dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
						logger.pass("Entered Scrip name is" + " " + nameAsset);

					}
					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);
					dG.genericClick(driver, dG.investmentFor);
//					if (assetSubCategory.contains("Debt Mutual Funds")) {
//						dG.genericClick(driver, dG.investmentFor);
//					} else {
//						dG.genericClick(driver, dG.investmentForDebt);
//					}
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);

					if (assetSubCategory.contains("PPF") || assetSubCategory.contains("Gratutity")
							|| assetSubCategory.contains("Superannuation") || assetSubCategory.contains("NSC")
							|| assetSubCategory.contains("Pension") || assetSubCategory.contains("Capital Gain")) {
						dG.genericSendKeys(driver, dG.currentNavTxt, accountBalanceOn);
						logger.pass("Account Balance on Entered is" + " " + accountBalanceOn);
						By frequency = By.xpath("//label[text()='" + frequencyTxt + "']");
						dG.genericClick(driver, frequency);
						logger.pass("Frequency selected is" + frequencyTxt);
					}

					if (assetSubCategory.contains("Debt Mutual Funds")) {
						if (!OneOrRecurr.contains("One Time")) {

							dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");
						}
						dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
						logger.pass("Number of Shares Entered is" + " " + numOfShares);

					}
					if (!(assetSubCategory.contains("PPF") || assetSubCategory.contains("Gratutity")
							|| assetSubCategory.contains("Superannuation") || assetSubCategory.contains("NSC")
							|| assetSubCategory.contains("Pension") || assetSubCategory.contains("Capital Gain"))) {
						dG.genericClick(driver, dG.assetPurchaseDate);
						calender01(purchaseDate);
						logger.pass("Purchase Date Entered is" + " " + purchaseDate);
					}
					dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
					logger.pass("Purchase Price Entered is" + " " + purchasePrice);

					if (!assetSubCategory.contains("Debt Mutual Funds")) {

						int slidervalue1 = Integer.parseInt(rateOfReturn);
						int aa1 = (slidervalue1 * 14);

						WebElement slider1 = driver.findElement(dG.annualGrowthSlider);

						Actions move = new Actions(driver);
						Action action1 = (Action) move.dragAndDropBy(slider1, aa1, 0).build();
						action1.perform();
						logger.pass("Selected Rate of return is" + " " + rateOfReturn);

						dG.genericClick(driver, dG.debtMaturityDate);
						calender01(debtMaturityDate);
						logger.pass("Maturity Date Entered is" + " " + debtMaturityDate);
						dG.genericSendKeys(driver, dG.debtMaturityAmount, debtMaturityAmount);
						logger.pass("Maturity Amount Entered is" + " " + debtMaturityAmount);
					}

					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");
				}
				
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}

	}

	@Test(priority = 7)
	public void realEstatePositive() throws InterruptedException, IOException, AWTException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			realEstateSize = debtSize;
			for (int z = debtSize; z < rowsize; z++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String realCat = data.get("AssetCategory");
				if ((realCat.contains("Real Estate"))) {
					realEstateSize++;
				} else {
					break;
				}

			}
			for (int i = debtSize; i < realEstateSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String purchaseDate = data.get("DateofPurchase");
				String purchasePrice = data.get("PurchasePrice");
				String realEstateMarketValueTxt = data.get("RealEstateCurrentMarketValue");
				String pincodeNum = data.get("RealEstatePincode");
				String residentialTypeTxt = data.get("ResidentPremiseType");
				String mortgageOrFreeholdTxt = data.get("MortgageOrFreehold");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String cityTypeTxt = data.get("CityType");
				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + driver.findElement(category).getText());

					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}

					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);
					dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
					logger.pass("Entered Scrip name is" + " " + nameAsset);

					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);

					dG.genericClick(driver, dG.investmentFor);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);
					dG.genericClick(driver, dG.assetPurchaseDate);
					calender01(purchaseDate);
					logger.pass("Purchase Date Entered is" + " " + purchaseDate);
					dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
					logger.pass("Purchase Price Entered is" + " " + purchasePrice);
					dG.genericSendKeys(driver, dG.addAssetValueTxt, realEstateMarketValueTxt);
					logger.pass("SIP Amount Entered is" + " " + realEstateMarketValueTxt);
					dG.genericSendKeys(driver, dG.pincodeTxt, pincodeNum);
					logger.pass("SIP Amount Entered is" + " " + pincodeNum);
					By residentialType = By.xpath("//label[contains(.,'" + residentialTypeTxt + "')]");
					dG.genericClick(driver, residentialType);
					logger.pass("Residential type Selected is " + " " + residentialTypeTxt);
					By cityType = By.xpath("//label[contains(.,'" + cityTypeTxt + "')]");
					if (driver.findElement(cityType).isDisplayed()) {
						dG.genericClick(driver, cityType);
						logger.pass("Residential type Selected is " + " " + cityTypeTxt);
					}
					By mortgageOrFree = By.xpath("(//label[contains(.,'" + mortgageOrFreeholdTxt + "')])[2]");
					dG.genericClick(driver, mortgageOrFree);
					logger.pass("Residential type Selected is " + " " + mortgageOrFreeholdTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");

				}
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}

	}

	@Test(priority = 8)
	public void liquidPositive() throws InterruptedException, IOException, AWTException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");

			liquidSize = realEstateSize;
			for (int z = realEstateSize; z < rowsize; z++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String liquidCat = data.get("AssetCategory");
				if ((liquidCat.contains("Liquid"))) {
					liquidSize++;
				} else {
					break;
				}

			}
			for (int i = realEstateSize; i < liquidSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String purchaseDate = data.get("DateofPurchase");
				String purchasePrice = data.get("PurchasePrice");
				String OneOrRecurr = data.get("EquityRecurring");
				String numOfShares = data.get("NoOfShares");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String startDateSIP = data.get("SIPStartDate");
				String amountSIP = data.get("SIPAmount");
				String totalInvestedValueSIP = data.get("TotalInvestedValue");
				String endDateSIP = data.get("SIPEndDate");
				String uptoAgeMFSIP = data.get("UptoAgeOnlyMF");
				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + driver.findElement(category).getText());

					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}

					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);
					if (assetSubCategory.contains("Liquid Funds")) {
						dG.genericClick(driver, dG.startSearchDropDown);
						logger.pass("Clicked on Search DropDown");
						By assetName = By.xpath("//span[text()='" + nameAsset + "']");
						dG.genericClick(driver, assetName);
						logger.pass("Clicked on Scrip" + " " + driver.findElement(assetName).getText());
					} else {
						dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
						logger.pass("Entered Scrip name is" + " " + nameAsset);

					}
					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);

					dG.genericClick(driver, dG.investmentFor);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);
					if (assetSubCategory.contains("Liquid Funds")) {
						if (!OneOrRecurr.contains("One Time")) {

							dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");

							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(startDateSIP);
							logger.pass("Purchase Date Entered is" + " " + startDateSIP);
							dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
							logger.pass("SIP Amount Entered is" + " " + amountSIP);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, totalInvestedValueSIP);
							logger.pass("Total Invested Value Entered is" + " " + totalInvestedValueSIP);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							if (!(assetSubCategory.contains("Liquid Funds") && !uptoAgeMFSIP.contains("0"))) {
								dG.genericClick(driver, dG.sipEndDateTxt);
								calender01(endDateSIP);
								logger.pass("SIP End Date Entered is" + " " + endDateSIP);
							} else {
								By uptoAge = By.xpath("//label[contains(.,'" + uptoAgeMFSIP + "')]");
								dG.genericClick(driver, uptoAge);
								logger.pass("Selected option is" + " " + uptoAge);
							}

						}

						else {

							logger.pass("Clicked on Toggle Button" + " " + OneOrRecurr);
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(purchaseDate);
							logger.pass("Purchase Date Entered is" + " " + purchaseDate);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
							logger.pass("Purchase Price Entered is" + " " + purchasePrice);
						}
					}
					if (!(assetSubCategory.contains("Liquid Funds"))) {
						dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
						logger.pass("Current Balance Entered is" + " " + amountSIP);
					}

					if (assetSubCategory.contains("Others")) {
						dG.genericClick(driver, dG.assetPurchaseDate);
						calender01(startDateSIP);
						logger.pass("Purchase Date Entered is" + " " + startDateSIP);
					}

					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");
				}
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}

	}

	@Test(priority = 9)
	public void alternativePositive() throws InterruptedException, AWTException, IOException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");

			alternateSize = liquidSize;
			for (int z = liquidSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String alternateCat = data02.get("AssetCategory");
				if ((alternateCat.contains("Alternate"))) {
					alternateSize++;
				} else {
					break;
				}
			}
			for (int i = liquidSize; i < alternateSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String purchaseDate = data.get("DateofPurchase");
				String purchasePrice = data.get("PurchasePrice");
				String OneOrRecurr = data.get("EquityRecurring");
				String numOfShares = data.get("NoOfShares");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String startDateSIP = data.get("SIPStartDate");
				String amountSIP = data.get("SIPAmount");
				String totalInvestedValueSIP = data.get("TotalInvestedValue");
				String endDateSIP = data.get("SIPEndDate");

				String currentPrice = data.get("CurrentPrice");
				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + driver.findElement(category).getText());
					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}

					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);

					dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
					logger.pass("Entered Scrip name is" + " " + nameAsset);
					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);

					dG.genericClick(driver, dG.investmentFor);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);
					if (assetSubCategory.contains("Commodity") || assetSubCategory.contains("Currency")) {
						if (!OneOrRecurr.contains("One Time")) {
							dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(startDateSIP);
							logger.pass("Purchase Date Entered is" + " " + startDateSIP);
							dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
							logger.pass("SIP Amount Entered is" + " " + amountSIP);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, totalInvestedValueSIP);
							logger.pass("Total Invested Value Entered is" + " " + totalInvestedValueSIP);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
							logger.pass("Entered Current Price is" + " " + currentPrice);
							dG.genericClick(driver, dG.sipEndDateTxt);
							calender01(endDateSIP);
							logger.pass("SIP End Date Entered is" + " " + endDateSIP);
						}

						else {

							logger.pass("Clicked on Toggle Button" + " " + OneOrRecurr);
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(purchaseDate);
							logger.pass("Purchase Date Entered is" + " " + purchaseDate);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
							logger.pass("Purchase Price Entered is" + " " + purchasePrice);
							dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
							logger.pass("Entered Current Price is" + " " + currentPrice);
						}
					} else {
						dG.genericClick(driver, dG.assetPurchaseDate);
						calender01(purchaseDate);
						logger.pass("Purchase Date Entered is" + " " + purchaseDate);

						dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
						logger.pass("Current Balance Entered is" + " " + amountSIP);
					}

					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");
				}
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}

	}

	@Test(priority = 10)
	public void goldPositive() throws InterruptedException, AWTException, IOException {

		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			goldSize = alternateSize;
			for (int z = alternateSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String goldCat = data02.get("AssetCategory");
				if ((goldCat.contains("Gold"))) {
					goldSize++;
				} else {
					break;
				}
			}
			for (int i = alternateSize; i < goldSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String purchaseDate = data.get("DateofPurchase");
				String purchasePrice = data.get("PurchasePrice");
				String OneOrRecurr = data.get("EquityRecurring");
				String numOfShares = data.get("NoOfShares");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String startDateSIP = data.get("SIPStartDate");
				String amountSIP = data.get("SIPAmount");
				String totalInvestedValueSIP = data.get("TotalInvestedValue");
				String endDateSIP = data.get("SIPEndDate");
				String goldKaratText = data.get("Karat");
				String currentPrice = data.get("CurrentPrice");
				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By category = By.xpath("//span[text()='" + assetCategory + "']");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + assetCategory);
					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					By subCategory01 = By.xpath("(//label[contains(.,'" + assetSubCategory + "')])[2]");
					if (!assetSubCategory.contains("Others")) {
						dG.genericClick(driver, subCategory);
					} else {
						dG.genericClick(driver, subCategory01);
					}

					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);

					if (assetSubCategory.contains("Gold Mutual Fund")) {
						dG.genericClick(driver, dG.startSearchDropDown);
						logger.pass("Clicked on Search DropDown");
						By assetName = By.xpath("//span[text()='" + nameAsset + "']");
						dG.genericClick(driver, assetName);
						logger.pass("Clicked on Scrip" + " " + driver.findElement(assetName).getText());
					} else {
						dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
						logger.pass("Entered Scrip name is" + " " + nameAsset);

					}

					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);

					dG.genericClick(driver, dG.investmentFor);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);
					if (assetSubCategory.contains("Gold Mutual Fund")) {
						if (!OneOrRecurr.contains("One Time")) {
							dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
							logger.pass("Clicked on Recurring Toggle Button");
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(startDateSIP);
							logger.pass("Purchase Date Entered is" + " " + startDateSIP);
							dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
							logger.pass("SIP Amount Entered is" + " " + amountSIP);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, totalInvestedValueSIP);
							logger.pass("Total Invested Value Entered is" + " " + totalInvestedValueSIP);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
							logger.pass("Entered Current Price is" + " " + currentPrice);
							dG.genericClick(driver, dG.sipEndDateTxt);
							calender01(endDateSIP);
							logger.pass("SIP End Date Entered is" + " " + endDateSIP);
						}

						else {

							logger.pass("Clicked on Toggle Button" + " " + OneOrRecurr);
							dG.genericClick(driver, dG.assetPurchaseDate);
							calender01(purchaseDate);
							logger.pass("Purchase Date Entered is" + " " + purchaseDate);
							dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
							logger.pass("Number of Shares Entered is" + " " + numOfShares);
							dG.genericSendKeys(driver, dG.investmentAmounTxt, purchasePrice);
							logger.pass("Purchase Price Entered is" + " " + purchasePrice);
							dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
							logger.pass("Entered Current Price is" + " " + currentPrice);
						}
					} else {
						dG.genericClick(driver, dG.assetPurchaseDate);
						calender01(purchaseDate);
						logger.pass("Purchase Date Entered is" + " " + purchaseDate);
						dG.genericSendKeys(driver, dG.currentUnitTxt, numOfShares);
						logger.pass("Number of Shares Entered is" + " " + numOfShares);
						if (assetSubCategory.contains("Physical Gold") || assetSubCategory.contains("Others")) {
							dG.genericSendKeys(driver, dG.goldKaratTxt, goldKaratText);
							logger.pass("Gold Karat Entered is " + " " + goldKaratText);
						}
						dG.genericSendKeys(driver, dG.investmentAmounTxt, totalInvestedValueSIP);
						logger.pass("Total Invested Value Entered is" + " " + totalInvestedValueSIP);
						dG.genericSendKeys(driver, dG.currentNavTxt, currentPrice);
						logger.pass("Entered Current Price is" + " " + currentPrice);

						// dG.genericSendKeys(driver, dG.addAssetValueTxt, amountSIP);
						// logger.pass("Current Balance Entered is"+" "+amountSIP);
					}

					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");
				}
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}
		}

	}
@Test(priority=11)
	public void othersAssetPositive() throws IOException, InterruptedException, AWTException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			otherSize = goldSize;
			for (int z = goldSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String otherCat = data02.get("AssetCategory");
				if ((otherCat.contains("Others"))) {
					otherSize++;
				} else {
					break;
				}
			}

			for (int i = goldSize; i < otherSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String nameAsset = data.get("NameAsset");
				String investmentTxt = data.get("investmentFor");
				String rateOfReturnTxt = data.get("RateOfReturn");
				String automatedLinkageTxt = data.get("ConsiderAutomatedLinkage");
				String LinkToGoalTxt = data.get("LinkToGoal");
				String currentBalance = data.get("CurrentBalance");
				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetCategory);
					extentTest.set(logger);
					Thread.sleep(3000);
					By category = By.xpath("//label[contains(.,'"+assetCategory+"')]");
					dG.genericClick(driver, category);
					logger.pass("Clicked on Category" + " " + assetCategory);

					dG.genericSendKeys(driver, dG.assetNameTxt, nameAsset);
					logger.pass("Entered Scrip name is" + " " + nameAsset);
					dG.genericClick(driver, dG.otherHolderName);
					By investmentFor = By.xpath("//div[text()=' " + investmentTxt + " ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);
					dG.genericClick(driver, investmentFor);
					logger.pass("Clicked on Invested For " + " " + investmentTxt);

					int slidervalue1 = Integer.parseInt(rateOfReturnTxt);
					int aa1 = (slidervalue1 * 10);

					WebElement slider1 = driver.findElement(dG.annualGrowthSlider);
					Actions move = new Actions(driver);

					Action action1 = (Action) move.dragAndDropBy(slider1, aa1, 0).build();
					action1.perform();

					dG.genericSendKeys(driver, dG.addAssetValueTxt, currentBalance);
					logger.pass("SIP Amount Entered is" + " " + currentBalance);
					if (!automatedLinkageTxt.contains("Yes")) {
						dG.genericClick(driver, dG.sliderOneTimeOrRecurringToggleButton);
					}
					logger.pass("Clicked on Toggle Button" + " " + automatedLinkageTxt);

					try {
						dG.genericClick(driver, dG.linkGoalSelectOpt);
						By linkGoalOpt = By.xpath("//div[text()=' " + LinkToGoalTxt + " ']");
						dG.genericClick(driver, linkGoalOpt);
						logger.pass("Selected Goal Link is" + " " + LinkToGoalTxt);
					} catch (Exception e) {
					}
					dG.genericClick(driver, dG.saveAddMoreAssetsLib);
					logger.pass("Clicked on Save and Add More");

				} 
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
			}

		}

	}

	//@Test(priority = 11)
public void uploadAsset(String documentPath01,String documentPassword01,String SubCategory ) throws AWTException, InterruptedException {
	dG.genericClick(driver, dG.uploadCASButton);
	logger.pass("Clicked on Upload Cas Button");
	By subCategory = By.xpath("//label[contains(.,'" + SubCategory + "')]");
	dG.genericClick(driver, subCategory);
	logger.pass("Clicked on SubCategory" + " " + SubCategory);
	dG.genericClick(driver, dG.uploadDragDropFileAsset);
	logger.pass("Clicked on Drag And Drop");
	
	StringSelection ss = new StringSelection(documentPath01);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	// imitate mouse events like ENTER, CTRL+C, CTRL+V
	Robot robot = new Robot();
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	dG.genericSendKeys(driver, dG.uploadPassTxt, documentPassword01);
	logger.pass("Entered Password is" + " " + documentPassword01);
	dG.genericClick(driver, dG.saveAndAddUpload);
	logger.pass("Clicked on Save and Add More");

	
}

	public void uploadAsset01() throws IOException, InterruptedException, AWTException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("AssetLiabRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			int uploadSize = otherSize;
			for (int z = otherSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String uploadCat = data02.get("AssetCategory");
				try {
					if ((uploadCat.contains("Upload"))) {
						uploadSize++;
					} else {
						break;
					}
				} catch (Exception e) {
					break;
				}
			}
			dG.genericClick(driver, dG.uploadTab);
			logger.pass("Clicked on Upload Tab");
			for (int i = otherSize; i < uploadSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String assetCategory = data.get("AssetCategory");
				String assetSubCategory = data.get("AssetSubCategory");
				String docmentPath = data.get("CamsKarveyDocumentPath");
				String documentPassword = data.get("camsKarveyPassword");

				if (!(assetCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + assetSubCategory);
					extentTest.set(logger);
					Thread.sleep(3000);

					By subCategory = By.xpath("//label[contains(.,'" + assetSubCategory + "')]");
					dG.genericClick(driver, subCategory);
					logger.pass("Clicked on SubCategory" + " " + assetSubCategory);
					dG.genericClick(driver, dG.uploadDragDropFileAsset);
					logger.pass("Clicked on Drag And Drop");

					StringSelection ss = new StringSelection(docmentPath);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

					// imitate mouse events like ENTER, CTRL+C, CTRL+V
					Robot robot = new Robot();
					Thread.sleep(5000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

					dG.genericSendKeys(driver, dG.uploadPassTxt, documentPassword);
					logger.pass("Entered Password is" + " " + documentPassword);
					dG.genericClick(driver, dG.saveAndAddUpload);
					logger.pass("Clicked on Save and Add More");
				}
			}

		}
	}

	@Test(priority = 12)
	public void liabilitiesPositive() throws InterruptedException, AWTException, IOException {
		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("LiabilitiesRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
			logger.pass("Clicked on Assets and Liabilities Tab");
			Thread.sleep(8000);
			dG.genericClick(driver, dG.liabilitiesTab);
			logger.pass("Clicked on Liabilities Tab");

			int liabSize = 0;
			for (int z = loginSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String liabCat = data02.get("LiabilitiesCategory");
				if (!(liabCat == null)) {
					liabSize++;
				} else {
					break;
				}
			}
			for (int i = loginSize; i < liabSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);

				String liabCategory = data.get("LiabilitiesCategory");
				String liabilitiesName = data.get("NameLiability");
				String holderNameTxt = data.get("NameHolder");
				String currOutstandAmntTxt = data.get("CurrentOutstandingAmount");
				String liabEndDate = data.get("EndDate");
				String currentEMILiabTxt = data.get("CurrentEMI");
				String liabFrequency = data.get("LiabilitiesFrequency");

				if (!(liabCategory == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + liabCategory);
					extentTest.set(logger);
					Thread.sleep(3000);
					if (!liabCategory.contains("Housing")) {
						By category = By.xpath("//label[contains(.,'" + liabCategory + "')]");
						dG.genericClick(driver, category);
					}
					logger.pass("Clicked on Category" + " " + liabCategory);

					dG.genericSendKeys(driver, dG.liabilitiesNameTxt, liabilitiesName);
					logger.pass("Liabilities Name Entered is" + " " + liabilitiesName);
					By investmentFor = By.xpath("//html/body/div[5]/ul/li/div[text()=' " + holderNameTxt + "  ']");
					// fun.scrollToElement(driver.findElement(dG.investmentForLiquid));
					Thread.sleep(4000);
                  
					dG.genericClick(driver, dG.nameOfHolderLiab);
                  
					Thread.sleep(4000);
					try {
					dG.genericClick(driver, investmentFor);}
					catch(Exception e) {
	                	  driver.findElement(By.xpath("/html/body/div[7]/ul/li[1]")).click();
	                  }
					
					logger.pass("Clicked on Invested For " + " " + holderNameTxt);

					dG.genericSendKeys(driver, dG.currentOutstandingamtTxt, currOutstandAmntTxt);
					logger.pass("Entered Current Outstanding Amount is" + " " + currOutstandAmntTxt);

					dG.genericClick(driver, dG.liabilitiesEndDate);
					calender01(liabEndDate);
					logger.pass("Liabilities End Date Entered is" + " " + liabEndDate);
					dG.genericSendKeys(driver, dG.currentEMITxt, currentEMILiabTxt);
					logger.pass("Current EMI Entered is" + " " + currentEMILiabTxt);

					By frequencyTxt = By.xpath("//label[contains(.,'" + liabFrequency + "')]");
					dG.genericClick(driver, frequencyTxt);
					logger.pass("Slected frequency is" + " " + liabFrequency);
					driver.findElement(By.xpath("//span[text()='Select']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[6]/ul/li[2]/div")).click();
                 try {
                	 dG.genericClick(driver, dG.saveLiabilities);
					dG.genericClick(driver, dG.saveAddMoreLiabilities);}
                 catch(Exception e) {
                	 
                	 try {
                		 dG.genericClick(driver, dG.saveAddMoreAssetsLib);
                	 }
                	 catch(Exception a) {
                		 dG.genericClick(driver, dG.saveLiabilities);
                	 }
                 }
					logger.pass("Clicked on Save and Add More");
					Thread.sleep(3000);

				}
			}
		}

	}

	@Test(priority = 13)
	public void insurancePositive() throws InterruptedException, AWTException, IOException {

		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("InsuranceRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			Thread.sleep(5000);
			fun.scrollToElement(driver.findElement(dG.insuranceLink));
			dG.genericClick(driver, dG.insuranceLink);
			logger.pass("Clicked on Insurance Tab");
			Thread.sleep(8000);
			dG.genericClick(driver, dG.insuranceLink);
			int insuranceSize = 0;
			for (int z = loginSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String insuranceCat = data02.get("Insurance Nature of Payment");
				if (!(insuranceCat == null)) {
					insuranceSize++;
				} else {
					break;
				}
			}

			for (int i = loginSize; i < insuranceSize; i++) {
				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String natureOfInsuranceTxt = data.get("Insurance Nature of Payment");
				String insurancePlanName = data.get("NameOfPlan");
				String premiumAmtTxt = data.get("PremiumAmount");
				String insuranceForTxt = data.get("InsuranceFor");
				String sumAssuredInsuranceTxt = data.get("SumAssuredInsurance");
				String maturityAmtTxt = data.get("MaturityAmount");
				String surrendervalueTxt = data.get("SurrenderValue");
				String paymentFrequencyTxt = data.get("PremiumPaymentFrequency");
				String insurancePurchaseDate = data.get("InsuranceDateofPurchase");
				String policyEnddate = data.get("PolicyEndDate");
				String premiumPaymentDate = data.get("PremiumPaymentEndDate");
				String insuranceLinkToGoal = data.get("InsuranceLinkToGoal");
				String insuranceReturn = data.get("InsOneTimeOrRecurring");
				String recurringStartDate = data.get("RecurrStartDate");
				String recurringEndDate = data.get("RecurrEndDate");
				String recurringAmount = data.get("RecurrAmount");
				String insTypeTxt = data.get("InsuranceType");

				if (!(natureOfInsuranceTxt == null)) {
					logger = extent.createTest("Datagathering Positive" + " " + natureOfInsuranceTxt);
					extentTest.set(logger);

					By insuranceNatureElement = By.xpath("//label[contains(.,'" + natureOfInsuranceTxt + "')]");
					Thread.sleep(5000);
					if (!natureOfInsuranceTxt.contains("Term Plan")) {
						dG.genericClick(driver, insuranceNatureElement);
					}
					logger.pass("Insurance Selected is" + natureOfInsuranceTxt);
					if (natureOfInsuranceTxt.contains("ULIP")) {
						dG.genericClick(driver, dG.startSearchDropDown);
						By ulipPlanName = By.xpath("//span[contains(text(),'" + insurancePlanName + "')]");
						dG.genericClick(driver, ulipPlanName);
					} else {
						dG.genericSendKeys(driver, dG.insurancePlanNameTxt, insurancePlanName);
					}
					logger.pass("Clicked on Insurance Plan is" + insurancePlanName);
					By insuranceForElement = By.xpath("//div[text()=' " + insuranceForTxt + "  ']");
					dG.genericClick(driver, dG.insuranceForDropDown);
					dG.genericClick(driver, insuranceForElement);
					logger.pass("Clicked on Insurance for" + insuranceForTxt);
					dG.genericSendKeys(driver, dG.insPremiumAmountTxt, premiumAmtTxt);
					logger.pass("Entered Premium Amount is" + premiumAmtTxt);
					dG.genericSendKeys(driver, dG.insSumAssuredTxt, sumAssuredInsuranceTxt);
					logger.pass("Entered Sum Assured Value is" + sumAssuredInsuranceTxt);
					dG.genericSendKeys(driver, dG.insMaturityAmountTxt, maturityAmtTxt);
					logger.pass("Entered Maturity Amount is" + maturityAmtTxt);
					if (fun.isElementDisplayed(dG.insSurrenderValueTxt)) {
						dG.genericSendKeys(driver, dG.insSurrenderValueTxt, surrendervalueTxt);
						logger.pass("Entered Surrendered Value is" + surrendervalueTxt);
					}
					if (fun.isElementDisplayed(dG.insTypeDropDownText)) {
						dG.genericClick(driver, dG.insTypeDropDown);
						By insTypeElement = By.xpath("//div[text()=' " + insTypeTxt + " ']");
						dG.genericClick(driver, insTypeElement);
						logger.pass("Selected Insurance Type is" + insTypeTxt);
					}
					
					By freqDropDown = By.xpath("(//span[@role='combobox'])[2]");
					dG.genericClick(driver, freqDropDown);
					//String frequencyTxt = data.get("Frequency");
					By frequencyValue = By.xpath("//div[text()=' "+paymentFrequencyTxt+"']");
					dG.genericClick(driver, frequencyValue);
					logger.pass("Frequency selected is " + " " + paymentFrequencyTxt);
					
					
				//	By premPayFrequency = By.xpath("//label[text()='" + paymentFrequencyTxt + "']");
				//	dG.genericClick(driver, premPayFrequency);
				//	logger.pass("Frequency selected is" + paymentFrequencyTxt);
					dG.genericClick(driver, dG.insurancePurchaseDate);
					calender01(insurancePurchaseDate);
					logger.pass("Insurance Purchase date Entered is" + insurancePurchaseDate);
					dG.genericClick(driver, dG.insurancePremiumPayEndDate);
					calender01(premiumPaymentDate);
					logger.pass("Selected Insurance Premium Payment End Date is" + premiumPaymentDate);
					dG.genericClick(driver, dG.insurancePolicyEndDate);
					calender01(policyEnddate);
					logger.pass("Entered Insurance Policy End Date is" + policyEnddate);
					dG.genericClick(driver, dG.insLinkToGoalDropDown);
					By linkToGoalElement = By.xpath("//div[text()=' " + insuranceLinkToGoal + " ']");
					Thread.sleep(5000);
					dG.genericClick(driver, linkToGoalElement);
					logger.pass("Selected Goal to link is" + insuranceLinkToGoal);
					if (fun.isElementDisplayed(dG.recurringReturn01)) {
						if (insuranceReturn.contains("One Time") || insuranceReturn.contains("Recurring")) {
							if (insuranceReturn.contains("Recurring")) {
								dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
								logger.pass("Selected Return Type" + insuranceReturn);
								dG.genericClick(driver, dG.insRecurrStartDateDropdown);
								calender01(recurringStartDate);
								logger.pass("Recurring Start date Selected is" + recurringStartDate);
								dG.genericClick(driver, dG.insRecurrEndDateDropdown);
								calender01(recurringEndDate);
								logger.pass("Recurring End date Selected is" + recurringEndDate);
								dG.genericSendKeys(driver, dG.insRecurrAmount, recurringAmount);
								logger.pass("Insurance Recurring Amount Entered is" + recurringAmount);
							} else {
								logger.pass("Selected Return Type" + insuranceReturn);
							}
						}
					}
					dG.genericClick(driver, dG.insuranceSave);
					logger.pass("Clicked on save and More Button");

				}
				if(fun.isElementDisplayed(dG.assetPopUp)) {
					dG.genericClick(driver, dG.assetPopUp);
					logger.pass("Clicked on Assets PopUp");
				}
				
			}
		}
	}

	@Test(priority = 14)
	public void myDocumentPositive() throws IOException, InterruptedException, AWTException {

		String required = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("DocumentRequired");
		if (required.equalsIgnoreCase("Yes")) {
			dG.genericClick(driver, dG.aboutYouLink);
			fun.scrollToElement(driver.findElement(dG.documentLink));
			dG.genericClick(driver, dG.documentLink);
			Thread.sleep(8000);
			logger.pass("Clicked on My Document Link");
			int documentSize = 0;
			for (int z = loginSize; z < rowsize; z++) {
				Map<String, String> data02 = fun.getTestDataInMap(excelPath, "Datagathering").get(z);
				String documentType = data02.get("DocumentType");
				if (!(documentType == null)) {
					documentSize++;
				} else {
					break;
				}
			}

			for (int i = loginSize; i < documentSize; i++) {

				Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(i);
				String documentType = data.get("DocumentType");
				String documentName = data.get("DocumentName");
				if (!(documentType == null)) {
					logger = extent.createTest("MyDocument Positive Scenarios");
					extentTest.set(logger);

					dG.genericClick(driver, dG.documentLink);
					dG.genericClick(driver, dG.documentDropDown);
					By documentTypeElement = By.xpath("//div[text()='" + documentType + "']");
					dG.genericClick(driver, documentTypeElement);
					logger.pass("Entered Document Type" + documentType);
					dG.genericSendKeys(driver, dG.documentNameTxt, documentName);
					logger.pass("Document Name Entered is " + " " + documentName);
					dG.genericClick(driver, dG.fileUploadLink);
					logger.pass("Click on Drag and Drop");
					// String filePath="C:\\Users\\Hp\\OneDrive\\Desktop\\PanTest.pdf";
					// String
					// filePath="C:\\Users\\Hp\\git\\DemoProject\\Fintoo\\UploadDocuments\\PanTest.pdf";
					String filePath = data.get("FilePath");
					StringSelection ss = new StringSelection(filePath);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

					// imitate mouse events like ENTER, CTRL+C, CTRL+V
					Robot robot = new Robot();
					Thread.sleep(5000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					logger.pass("Pdf file Uploaded Successfully");
					Thread.sleep(4000);
					dG.genericClick(driver, dG.documentSubmitButton);
					logger.pass("Clicked on Document Submit Button");
				}
			}
		}
	}

	
	@Test(priority=15)
	public void generateReport() throws IOException, InterruptedException {
		String reportGen = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("GenerateReport");
		if(reportGen.equals("Yes")){
		dG.genericClick(driver, dG.generateReportButton);
		logger.pass("Clicked on Generate Report Button");
		dG.genericClick(driver, dG.genRepYesBtn);
		logger.pass("Clicked Generate Report Button");
		//fun.fluentWait(driver, dG.downloadRepBtn,20000,1000);
		Thread.sleep(5000);
		}
		
	}
	@Test(priority = 16)
	public void logOut() throws InterruptedException, IOException {
		String logOut = fun.getTestDataInMap(excelPath, "Datagathering").get(loginSize).get("LogOut");
		if(logOut.equals("Yes")){
		By lowerBox = By.xpath("//a[text()='Generate Report']");
		// dG.genericClick(driver, lowerBox);
		Thread.sleep(3000);
		By logOutButton = By.xpath("(//a[text()='Logout'])[1]");
		dG.genericClick(driver, logOutButton);
		logger.pass("Clicked on LogOut Button");}
		loginSize = family_try.incrementDG + 3;
	}

	public void calender(String date, String month, String year) {
		Select s = new Select(driver.findElement(dG.calenderYear));
		s.selectByVisibleText(year);
		Select ss = new Select(driver.findElement(dG.calenderMonth));
		ss.selectByVisibleText(month);
		// By date01 = By.xpath("(//a[text()='"+date+"'])[2]");
		By date01 = By.xpath("//*[@id='ui-datepicker-div']//a[text()='" + date + "']");
		driver.findElement(date01).click();

	}

	public void calender01(String date) {
		String[] goalEndDate = date.split("-");
		String date01 = goalEndDate[0];
		String month = goalEndDate[1];
		month = month.substring(0, 3);
		String year = goalEndDate[2];

		Select s = new Select(driver.findElement(dG.calenderYear));
		s.selectByVisibleText(year);
		Select ss = new Select(driver.findElement(dG.calenderMonth));
		ss.selectByVisibleText(month);
		// By date01 = By.xpath("(//a[text()='"+date+"'])[2]");
		By date02 = By.xpath("//*[@id='ui-datepicker-div']//a[text()='" + date01 + "']");
		driver.findElement(date02).click();
		logger.pass("Selected Date is" + " " + date);
	}

}
