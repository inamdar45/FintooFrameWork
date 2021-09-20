package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.functions;


public class TC_AssetsAndLiabilitiesNeg_014 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);
	ArrayList<String> datagatheringList;
	ArrayList<String> datagatheringList1;
	ArrayList<String> datagatheringList2;
	ArrayList<String> datagatheringList3;
	String excelPath = readconfig.getExcelPath();
	TC_DataGathering_008 dG8 = new TC_DataGathering_008();



	@Test(priority=1)
	public void AssetsEquityNeg() throws IOException, InterruptedException, AWTException {
		dG8.dataGathering01();
		// dG8.incomeExpensePositive();
		//  dG8.goalsPositive();
		logger=  extent.createTest("Assets-Equity Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.aboutYouLink);
		fun.scrollToElement(driver.findElement(dG.assetAndLiabilitiesLink));
			dG.genericClick(driver, dG.assetAndLiabilitiesLink);
		logger.pass("Clicked on Asset and Liabilities");
		dG.genericClick(driver, dG.assetEquityTab);
		logger.pass("Clicked on Assets Tab");
		dG.genericClick(driver, dG.equityShareTab);
		logger.pass("Clicked on Equity Shares Tab");
		equityNegative();
		dG.genericClick(driver, dG.equityMFTab);
		logger.pass("Clicked on Equity Mutual funds Tab");
		equityNegative();
		dG.genericClick(driver, dG.equityPMSTab);
		logger.pass("Clicked on Equity PMS Tab");
		equityNegative();
		dG.genericClick(driver, dG.equityUnlistedTab);
		logger.pass("Clicked on Equity Unlisted Tab");
		equityNegative();
		dG.genericClick(driver, dG.equityESOPTab);
		logger.pass("Clicked on Equity ESOP Tab");
		equityNegative();
		dG.genericClick(driver, dG.equityFurAndOptTab);
		logger.pass("Clicked on Equity Future And Options Tab");
		equityNegative();




	}


	@Test(priority=2)
	public void AssetsDebtNeg() throws InterruptedException, IOException, AWTException {

		// dG8.dataGathering01();
		// dG8.incomeExpensePositive();
		//  dG8.goalsPositive();
		logger=  extent.createTest("Assets-Debt Negative Scenarios");
		extentTest.set(logger);
		// dG.genericClick(driver, dG.assetAndLiabilitiesLink);
		//logger.pass("Clicked on Asset and Liabilities");
		dG.genericClick(driver, dG.assetDebtTab);
		logger.pass("Clicked on Assets Debt Tab");
		dG.genericClick(driver, dG.debtFixedDeposit);
		logger.pass("Clicked on Debt Fixed Deposit Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtGOVScheme);
		logger.pass("Clicked on Debt Government Scheme Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtMF);
		logger.pass("Clicked on Debt MF Tab");
		debtNegative();
		invalidDataMF();
		dG.genericClick(driver, dG.debtPostOfficeSch);
		logger.pass("Clicked on Debt Post Office Scheme Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtGOVBond);
		logger.pass("Clicked on Debt Gov Bond Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtDebentures);
		logger.pass("Clicked on Debt Debentures Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtPPF);
		logger.pass("Clicked on Debt PPF Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtGratutity);
		logger.pass("Clicked on Debt Gratutity Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtSuperannuation);
		logger.pass("Clicked on Debt Superannuation Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtNSC);
		logger.pass("Clicked on Debt NSC Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtPensionScheme);
		logger.pass("Clicked on Debt Pension Scheme Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtCapitalGainBonds);
		logger.pass("Clicked on Debt Capital Gain Bonds Tab");
		debtNegative();
		debtWithInvalidData();
		dG.genericClick(driver, dG.debtOthers);
		logger.pass("Clicked on Debt Others Tab");
		debtNegative();
		debtWithInvalidData();

	}
	public void equityNegative() throws InterruptedException {
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and Add More Button");
		Thread.sleep(3000);
		if(fun.isElementDisplayed(dG.selectShareErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.selectShareErrMsg).getText(), "Please select share name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.selectShareErrMsg).getText());
		}

		else if(fun.isElementDisplayed(dG.selectShareMFErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.selectShareMFErrMsg).getText(), "Please select fund name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.selectShareMFErrMsg).getText());
		}
		else if(fun.isElementDisplayed(dG.debtShareMFErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.debtShareMFErrMsg).getText(), "Please select fund name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtShareMFErrMsg).getText());
		}
		else if(fun.isElementDisplayed(dG.assetNameErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Please add asset name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Share Select Field");
		}

		if(fun.isElementDisplayed(dG.investmentForErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.investmentForErrMsg).getText(), "Please select a member");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.investmentForErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Select Member Field");
		}

		if(fun.isElementDisplayed(dG.numofSharesErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.numofSharesErrMsg).getText(), "Please add units");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.numofSharesErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Share Units Field");
		}

		/* if(functions.isElementDisplayed(dG.purchasePriceErrMsg)) {
	    	Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "Please add asset purchase amount");
	    	logger.pass("Error Message Displayed is"+driver.findElement(dG.purchasePriceErrMsg).getText());
	    }
	    else {
	    	logger.fail("Error Message not Displayed for Purchase Price Field");
	    }*/

		if(fun.isElementDisplayed(dG.currentUnitPriceErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.currentUnitPriceErrMsg).getText(), "Please add current unit price");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentUnitPriceErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Current Unit Field");
		}
		if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
			dG.genericClick(driver, dG.oneTRecurrSliderAsset);
			logger.pass("Clicked on Recurring Toggle Button");
			dG.genericClick(driver, dG.saveAddMoreAssetsLib);
			logger.pass("Clicked on Save and Add More Button");

			if(fun.isElementDisplayed(dG.sipAmountErrMsg)) {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add asset value");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			else {
				logger.fail("Error Message not Displayed for SIP Amount Field");
			}

			if(fun.isElementDisplayed(dG.debtSipEndDateErrMsg)) {
				Assert.assertEquals(driver.findElement(dG.debtSipEndDateErrMsg).getText(), "Please select end date");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.debtSipEndDateErrMsg).getText());
			}
			else {
				logger.fail("Error Message not Displayed for Debt MF End Date");
			}
			if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
				dG.genericClick(driver, dG.oneTRecurrSliderAsset);
				logger.pass("Clicked on One Time Toggle Button");}}

	}
	public void debtNegative() throws InterruptedException, IOException {

		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and Add More Button");
		Thread.sleep(3000);
		if(fun.isElementDisplayed(dG.selectShareErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.selectShareErrMsg).getText(), "Please select share name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.selectShareErrMsg).getText());
		}

		else if(fun.isElementDisplayed(dG.selectShareMFErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.selectShareMFErrMsg).getText(), "Please select fund name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.selectShareMFErrMsg).getText());
		}
		else if(fun.isElementDisplayed(dG.debtShareMFErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.debtShareMFErrMsg).getText(), "Please select fund name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtShareMFErrMsg).getText());
		}
		else if(fun.isElementDisplayed(dG.assetNameErrMsg)) {

			Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Please add asset name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Share Select Field");
		}

		if(fun.isElementDisplayed(dG.investmentForErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.investmentForErrMsg).getText(), "Please select a member");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.investmentForErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Select Member Field");
		}



		if(fun.isElementDisplayed(dG.purchasePriceErrMsg)) {
		try {	Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "Please add asset purchase amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.purchasePriceErrMsg).getText());}
		catch(Exception e) {
				logger.fail("Error Message not Displayed for Purchase Price Field");}
		}

		if(fun.isElementDisplayed(dG.debtAssetPurchasedateErrMsg)) {
			try{Assert.assertEquals(driver.findElement(dG.debtAssetPurchasedateErrMsg).getText(), "Please select asset purchase date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtAssetPurchasedateErrMsg).getText());}
			catch(Exception e) {
		
			logger.fail("Error Message not Displayed for Assets Purchase date Field");}
			}
		

		if(fun.isElementDisplayed(dG.debtMaturityDateErrMsg)) {
			try {
			Assert.assertEquals(driver.findElement(dG.debtMaturityDateErrMsg).getText(), "Please select maturity date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtMaturityDateErrMsg).getText());}
		
		catch(Exception e) {
			logger.fail("Error Message not Displayed for Maturity Date Field");
		}}
		
		if(fun.isElementDisplayed(dG.numofSharesErrMsg)) {
			try{Assert.assertEquals(driver.findElement(dG.numofSharesErrMsg).getText(), "Please add units");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.numofSharesErrMsg).getText());}
		
		catch(Exception e) {
			logger.fail("Error Message not Displayed for Share Units Field");
		}}


		if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
			dG.genericClick(driver, dG.oneTRecurrSliderAsset);
			logger.pass("Clicked on Recurring Toggle Button");
			dG.genericClick(driver, dG.saveAddMoreAssetsLib);
			logger.pass("Clicked on Save and Add More Button");

			if(fun.isElementDisplayed(dG.sipAmountErrMsg)) {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add asset value");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			else {
				logger.fail("Error Message not Displayed for SIP Amount Field");
			}
			if(fun.isElementDisplayed(dG.sipCurrentPriceErrMsg)) {
				Assert.assertEquals(driver.findElement(dG.sipCurrentPriceErrMsg).getText(), "Please add current unit price");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipCurrentPriceErrMsg).getText());
			}
			else {
				logger.fail("Error Message not Displayed for Current Unit Field");
			}

			if(fun.isElementDisplayed(dG.debtSipEndDateErrMsg)) {
				Assert.assertEquals(driver.findElement(dG.debtSipEndDateErrMsg).getText(), "Please select end date");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.debtSipEndDateErrMsg).getText());
			}
			else {
				logger.fail("Error Message not Displayed for Debt MF End Date");
			}


			if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
				dG.genericClick(driver, dG.oneTRecurrSliderAsset);
				logger.pass("Clicked on One Time Toggle Button");}}

	}

	public void debtWithInvalidData() throws IOException, AWTException {
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String assetName = data.get("NameAsset");
		String assetInvestAmount = data.get("InvestmentAmount");
			dG.genericSendKeys(driver, dG.assetNameTxt, assetName);
		logger.pass("Entered Asset Name is"+" "+assetName);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		if(driver.findElement(dG.assetNameErrMsg).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Special characters not allowed");
				logger.pass("Error Message Displayed is"+" "+driver.findElement(dG.assetNameErrMsg).getText());}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Asset invalid Name");
			}
			driver.findElement(dG.assetNameTxt).clear();

		}
		dG.genericSendKeys(driver, dG.investmentAmounTxt, assetInvestAmount);
		logger.pass("Entered Investment Amount is"+" "+assetInvestAmount);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		if(driver.findElement(dG.purchasePriceErrMsg).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "upto 2 digits allowed after decimal");
				logger.pass("Error Message Displayed is"+" "+driver.findElement(dG.purchasePriceErrMsg).getText());}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Investment invalid Amount");
			}
			driver.findElement(dG.investmentAmounTxt).clear();	 
		}


	}
	public void invalidDataMF() throws IOException, AWTException {
		Robot r = new Robot();
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String currentNAV = data.get("CurrentNAV");
		String currentUnits = data.get("CurrentUnits");
		dG.genericSendKeys(driver, dG.currentUnitTxt, currentUnits);
		logger.pass("Entered Investment Amount is"+" "+currentUnits);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		if(driver.findElement(dG.numofSharesErrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.numofSharesErrMsg).getText(), "upto 4 digits allowed after decimal");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.numofSharesErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Current Units Field");
		}	
		driver.findElement(dG.investmentAmounTxt).clear();

		dG.genericSendKeys(driver, dG.currentNavTxt, currentNAV);
		logger.pass("Entered Investment Amount is"+" "+currentNAV);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		if(driver.findElement(dG.currentUnitPriceErrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.currentUnitPriceErrMsg).getText(), "upto 2 digits allowed after decimal");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentUnitPriceErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Current NAV Field");
		}	
		driver.findElement(dG.currentNavTxt).clear();
		
	}
	@Test(priority=3)
	public void assetRealEstateNeg () throws IOException, AWTException {
		logger=  extent.createTest("Assets-RealEstate Negative Scenarios");
		extentTest.set(logger);
		
		dG.genericClick(driver, dG.assetRealEstateTab);
		logger.pass("Clicked on RealEstate Tab");
		dG.genericClick(driver, dG.residentialLink);
		logger.pass("Clicked on Residential Link");
		realEstate();
		dG.genericClick(driver, dG.commercialLink);
		logger.pass("Clicked on Commercial Link");
		realEstate();
		dG.genericClick(driver, dG.agriculturalLandLink);
		logger.pass("Clicked on AgricultureLand Link");
		realEstate();
		dG.genericClick(driver, dG.holidaysLink);
		logger.pass("Clicked on Holiday Link");
		realEstate();
		dG.genericClick(driver, dG.constructionPropertyLink);
		logger.pass("Clicked on Construction Link");
		realEstate();
		dG.genericClick(driver, dG.landLink);
		logger.pass("Clicked on Land Link");
		realEstate();
		dG.genericClick(driver, dG.otherLink);
		logger.pass("Clicked on Other Link");
		realEstate();
	
	}
	@Test(priority=4)
	public void liquidNegative() throws IOException, AWTException {
		logger=  extent.createTest("Assets-Liquid Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.assetLiquidTab);
		logger.pass("Clicked on Liquid Tab");
		dG.genericClick(driver, dG.cashBalanceTab);
		logger.pass("Clicked on Cash Balance Tab");
		liquid();
		dG.genericClick(driver, dG.bankBalanceTab);
		logger.pass("Clicked on Bank Balance Tab");
		liquid();
		
		dG.genericClick(driver, dG.liquidFundsTab);
		logger.pass("Clicked on Liquid Funds Tab");
		liquid();
		invalidDataMF();
		dG.genericClick(driver, dG.othersTab);
		logger.pass("Clicked on Others Tab");
		liquid();
	}
	@Test(priority=5)
	public void alternateNeg() throws IOException, AWTException {
		logger=  extent.createTest("Assets-ALternate Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.assetAlternateTab);
		logger.pass("Clicked on Alternate Tab");
		dG.genericClick(driver, dG.artInvestmentTab);
		logger.pass("Clicked on Art Investment Tab");			
		liquid();
		dG.genericClick(driver, dG.wineInvestmentTab);
		logger.pass("Clicked on Wine Investment Tab");
		liquid();
		dG.genericClick(driver, dG.carsTab);
		logger.pass("Clicked on Cars Tab");
		liquid();
		dG.genericClick(driver, dG.commoditityTab);
		logger.pass("Clicked on Commodity Tab");
		liquid();
		dG.genericClick(driver, dG.currencyTab);
		logger.pass("Clicked on Currency Tab");
		liquid();
		dG.genericClick(driver, dG.alternateOthersTab);
		logger.pass("Clicked on Others Tab");
		liquid();
		
	}
	
	@Test(priority=6)
	public void goldNegative() throws IOException, AWTException {
		logger=  extent.createTest("Assets-Gold Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.assetGoldTab);
		logger.pass("Clicked on Gold Tab");
		dG.genericClick(driver, dG.physicalGoldTab);
		logger.pass("Clicked on Physical Gold Tab");
		liquid();
		dG.genericClick(driver, dG.goldETFTab);
		logger.pass("Clicked on GoldETF Tab");
		liquid();
		dG.genericClick(driver, dG.goldMFTab);
		logger.pass("Clicked on Gold Mutual Funds Tab");
		liquid();
		dG.genericClick(driver, dG.goldBondTab);
		logger.pass("Clicked on Gold Bond Tab");
		liquid();
		dG.genericClick(driver, dG.goldOtherTab);
		logger.pass("Clicked on Gold Others Tab");
		liquid();
	}
	@Test(priority=7)
	public void uploadNeg() throws IOException, AWTException, InterruptedException {
		logger=  extent.createTest("Assets-Upload Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.assetUploadTab);
		logger.pass("Clicked on Upload Tab");
		dG.genericClick(driver, dG.camsKarvyTab);
		logger.pass("Clicked on Cams/Kravey Tab");
		upload();
		dG.genericClick(driver, dG.cdslTab);
		logger.pass("Clicked on CDSL Tab");
		upload();
		dG.genericClick(driver, dG.nsdlTab);
		logger.pass("Clicked on NSDL Tab");
		upload();
		
	}
	@Test(priority=8)
	public void liabilitiesNegative() throws IOException, AWTException {
		logger=  extent.createTest("Liabilities Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.liabilitiesTab);
		logger.pass("Clicked on Liabilities Tab");
		dG.genericClick(driver, dG.housingTab);
		logger.pass("Clicked on Housing Tab");
		liabilities();
		dG.genericClick(driver, dG.creditCardTab);
		logger.pass("Clicked on CreditCard Tab");
		liabilities();
		dG.genericClick(driver, dG.carTab);
		logger.pass("Clicked on Car Tab");
		liabilities();
		dG.genericClick(driver, dG.businessTab);
		logger.pass("Clicked on Business Tab");
		liabilities();
		dG.genericClick(driver, dG.otherPropertyLoanTab);
		logger.pass("Clicked on Other Property Loan Tab");
		liabilities();
		dG.genericClick(driver, dG.personnalTab);
		logger.pass("Clicked on Personnal Tab");
		liabilities();
		dG.genericClick(driver, dG.consumerTab);
		logger.pass("Clicked on Consumer Tab");
		liabilities();
		dG.genericClick(driver, dG.familyAndFriendTab);
		logger.pass("Clicked on Family and Friend Tab");
		liabilities();
		
	}
	public void realEstate() throws IOException, AWTException {
		Robot r = new Robot();
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String assetName =data.get("NameAsset");
		String amountPurchase =data.get("PurchasePrice");
		String currentValue = data.get("CurrentValue");
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save Add More");
		if(driver.findElement(dG.assetNameTxt).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Please add asset name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Asset Name");
			}
		}
		
		if(driver.findElement(dG.investmentForRealEstate).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.memberErrorMsg).getText(), "Please select a member");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.memberErrorMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Investment For");
			}
		}
		
		if(driver.findElement(dG.investmentAmounTxt).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "Please add asset purchase amount");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.purchasePriceErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Purchase Amount");
			}
		}
		
		if(driver.findElement(dG.addAssetValueTxt).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add asset value");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Current Market Value");
			}
		}
		
		if(driver.findElement(dG.pincodeTxt).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.pincodeErrMsg).getText(), "Please add pincode");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.pincodeErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate PinCode");
			}
		}
		
		if(driver.findElement(dG.assetNameTxt).isDisplayed()) {
			dG.genericSendKeys(driver, dG.assetNameTxt, assetName);
			logger.pass("Assets Name Entered is"+assetName);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Special characters not allowed");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Asset Name");
			}
			driver.findElement(dG.assetNameTxt).clear();
		}
		
		if(driver.findElement(dG.investmentAmounTxt).isDisplayed()) {
			dG.genericSendKeys(driver, dG.investmentAmounTxt, amountPurchase);
			logger.pass("Purchase Amount Entered is"+amountPurchase);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "upto 2 digits allowed after decimal");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.purchasePriceErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Purchase Amount");
			}
			driver.findElement(dG.investmentAmounTxt).clear();
		}
		
		if(driver.findElement(dG.addAssetValueTxt).isDisplayed()) {
			dG.genericSendKeys(driver, dG.addAssetValueTxt, currentValue);
			logger.pass("Current Value Entered is"+currentValue);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "upto 2 digits allowed after decimal");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Current Market Value");
			}
			driver.findElement(dG.addAssetValueTxt).clear();
		}
	}
	
	public void liquid() throws IOException, AWTException {
		Robot r = new Robot();
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String assetName =data.get("NameAsset");
		String currentBalance=data.get("CurrentBalance");
		String assetInvestAmount = data.get("InvestmentAmount");
		String currentNAV = data.get("CurrentNAV");
		
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and AddMore");
		
		if(fun.isElementDisplayed(dG.assetNameTxt)) {
			try {
				Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Please add asset name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Liquid Asset Name");
			}
		}
		
		if(fun.isElementDisplayed(dG.holderName)||fun.isElementDisplayed(dG.investmentForLiquid)) {
			try {
				Assert.assertEquals(driver.findElement(dG.memberErrorMsg).getText(), "Please select a member");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.memberErrorMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Liquid Investment For");
			}
		}
		
		if( fun.isElementDisplayed(dG.addAssetValueTxt)) {
			if(driver.findElement(dG.sipAmountErrMsg).getText().contentEquals("Please add asset value")) {
			try {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add asset value");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Liquid Current Market Value");
			}}
			
			if(driver.findElement(dG.sipAmountErrMsg).getText().contentEquals("Please add market value")) {
				try {
					Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add market value");
					logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
				}
				catch(Exception e) {
					logger.fail("Error Message not Displayed for Alternate Current Market Value");
				}}
			
			
		}
		
		if(driver.findElement(dG.investmentAmounTxt).isDisplayed()) {
			try {
				Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "Please add asset purchase amount");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.purchasePriceErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Real Estate Purchase Amount");
			}
		}
		
		if(fun.isElementDisplayed(dG.assetPurchaseDate)&&fun.isElementDisplayed(dG.debtAssetPurchasedateErrMsg)) {
			try{Assert.assertEquals(driver.findElement(dG.debtAssetPurchasedateErrMsg).getText(), "Please select asset purchase date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtAssetPurchasedateErrMsg).getText());}
			catch(Exception e) {
		
			logger.fail("Error Message not Displayed for Assets Purchase date Field");}
			}
		
		if( fun.isElementDisplayed(dG.startSearchDropDown)) {
			if( fun.isElementDisplayed(dG.liquidShareMFErrMsg)) {
			try{Assert.assertEquals(driver.findElement(dG.liquidShareMFErrMsg).getText(), "Please select fund name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.liquidShareMFErrMsg).getText());}
			catch(Exception e) {
		
			logger.fail("Error Message not Displayed for Select Fund Name Field");}
			}
			if( fun.isElementDisplayed(dG.goldShareMFErrMsg)) {
				try{Assert.assertEquals(driver.findElement(dG.goldShareMFErrMsg).getText(), "Please select fund name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.goldShareMFErrMsg).getText());}
				catch(Exception e) {
			
				logger.fail("Error Message not Displayed for Select Fund Name Field");}
				}
			
		}
		
		if( fun.isElementDisplayed(dG.investmentForLiquid)||fun.isElementDisplayed(dG.currentUnitTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.numofSharesErrMsg).getText(), "Please add units");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.numofSharesErrMsg).getText());}
			catch(Exception e) {
		
			logger.fail("Error Message not Displayed for Current Units Field");}
			}
		
		if( fun.isElementDisplayed(dG.currentNavTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.currentUnitPriceErrMsg).getText(), "Please add current unit price");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentUnitPriceErrMsg).getText());}
			catch(Exception e) {
		
			logger.fail("Error Message not Displayed for Current NAV Field");}
			}
		
		if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
			dG.genericClick(driver, dG.oneTRecurrSliderAsset);
			logger.pass("Clicked on Recurring Toggle Button");
			dG.genericClick(driver, dG.saveAddMoreAssetsLib);
			logger.pass("Clicked on Save and Add More Button");
		if( fun.isElementDisplayed(dG.addAssetValueTxt)) {
			try {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "Please add asset value");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Alternate Asset Amount");
			}
			
		}
		
		if(fun.isElementDisplayed(dG.sipEndDateTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.debtSipEndDateErrMsg).getText(), "Please select end date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.debtSipEndDateErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for SIP End Date Field");}
			}
		}
			
		if(fun.isElementDisplayed(dG.oneTRecurrSliderAsset)) {
			dG.genericClick(driver, dG.oneTRecurrSliderAsset);
			logger.pass("Clicked on One Time Toggle Button");}
		
		/*if( fun.isElementDisplayed(dG.assetNameTxt)) {
			dG.genericSendKeys(driver, dG.assetNameTxt, assetName);
			logger.pass("Assets Name Entered is"+assetName);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.assetNameErrMsg).getText(), "Special characters not allowed");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.assetNameErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Liquid Asset Name");
			}
			driver.findElement(dG.assetNameTxt).clear();
		}*/
		
		if( fun.isElementDisplayed(dG.addAssetValueTxt)) {
			dG.genericSendKeys(driver, dG.addAssetValueTxt, currentBalance);
			logger.pass("Current Balance Entered is"+currentBalance);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.sipAmountErrMsg).getText(), "upto 2 digits allowed after decimal");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.sipAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Liquid Current Balance");
			}
			driver.findElement(dG.addAssetValueTxt).clear();
		}
		
		
		if(fun.isElementDisplayed(dG.investmentAmounTxt)) {
			dG.genericSendKeys(driver, dG.investmentAmounTxt, assetInvestAmount);
			logger.pass("Entered Investment Amount is"+" "+assetInvestAmount);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try {
				Assert.assertEquals(driver.findElement(dG.purchasePriceErrMsg).getText(), "upto 2 digits allowed after decimal");
				logger.pass("Error Message Displayed is"+" "+driver.findElement(dG.purchasePriceErrMsg).getText());}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Investment invalid Amount");
			}
			driver.findElement(dG.investmentAmounTxt).clear();	 
		}
		
		
		if( fun.isElementDisplayed(dG.currentNavTxt)) {
			dG.genericSendKeys(driver, dG.currentNavTxt, currentNAV);
			logger.pass("Entered Investment Amount is"+" "+currentNAV);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try{Assert.assertEquals(driver.findElement(dG.currentUnitPriceErrMsg).getText(), "upto 2 digits allowed after decimal");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentUnitPriceErrMsg).getText());}
		
		catch(Exception e) {
			logger.fail("Error Message not Displayed for Current NAV Field");
		}	
		driver.findElement(dG.currentNavTxt).clear();}
		
			}
	
	public void upload() throws IOException, AWTException, InterruptedException {
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String camsPassword = data.get("camsKarveyPassword");
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and AddMore");
		if(fun.isElementDisplayed(dG.uploadPassTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.uploadPassErrMsg).getText(), "Please enter password");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.uploadPassErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for Password Field");}
			}
		dG.genericSendKeys(driver, dG.uploadPassTxt, camsPassword);
		logger.pass("Entered Password is"+" "+camsPassword);
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and AddMore");
		
		if(fun.isElementDisplayed(dG.camsFileUploadErrMsg)) {
			try{Assert.assertEquals(driver.findElement(dG.camsFileUploadErrMsg).getText(), "Please select atleast one document to upload.");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.camsFileUploadErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for Upload Document Field");}
		}
		
		
		//driver.findElement(By.xpath("//div[@class='dz-default dz-message']")).sendKeys("C:\\Users\\Hp\\OneDrive\\Desktop\\PanTest.pdf");

		driver.findElement(By.xpath("//div[@class='dz-default dz-message']")).click();
		logger.pass("Clicked on Drag and Drop");

		StringSelection ss = new StringSelection("C:\\Users\\Hp\\OneDrive\\Desktop\\PanTest.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		    //imitate mouse events like ENTER, CTRL+C, CTRL+V
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
		    logger.pass("Pdf file Uploaded.");
		Thread.sleep(2000);
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
		logger.pass("Clicked on Save and AddMore");
		//Thread.sleep(5000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(dG.incorrectPdfErrMsg)));
		if(fun.isElementDisplayed(dG.incorrectPdfErrMsg)) {
			Assert.assertEquals(driver.findElement(dG.incorrectPdfErrMsg).getText(), "incorrect pdf file");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incorrectPdfErrMsg).getText());
		}
		else {
			logger.pass("Correct pdf File is Uploaded.");
		}
		driver.findElement(dG.uploadPassTxt).clear();
		/*dG.genericClick(driver, dG.camsLink);
		logger.pass("Clicked on Cams Link");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(dG.camsDisclaimerAccept)));
		dG.genericClick(driver, dG.camsDisclaimerAccept);
		logger.pass("Clicked on Disclaimer Accept");
		dG.genericClick(driver, dG.camsDisclaimerProceed);
		logger.pass("Clicked on Disclaimer Proceed");
		dG.genericClick(driver, dG.camsStatementLink);
		logger.pass("Clicked on Cas-Cams Link");
		 dG.genericClick(driver, dG.camsSubmitButton);
		 logger.pass("Clicked on Cams Submit Button");
		 if(fun.isElementDisplayed(dG.camsEmailTxt)) {
				try{Assert.assertEquals(driver.findElement(dG.camsEmailErrMsg).getText(), "Please enter the Email");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.camsEmailErrMsg).getText());}
				catch(Exception e) {
						logger.fail("Error Message not Displayed for Email Field");}
				}
		 if(fun.isElementDisplayed(dG.camsPassTxt)) {
				try{Assert.assertEquals(driver.findElement(dG.camsPasswordErrMsg).getText(), "Password is required");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.camsPasswordErrMsg).getText());}
				catch(Exception e) {
						logger.fail("Error Message not Displayed for Password Field");}
				}
		 if(fun.isElementDisplayed(dG.camsConfirmPassTxt)) {
				try{Assert.assertEquals(driver.findElement(dG.camsConfirmPassErrMsg).getText(), "Re-enter Password is required");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.camsConfirmPassErrMsg).getText());}
				catch(Exception e) {
						logger.fail("Error Message not Displayed for Confirm Password Field");}
				}
		 
		 

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)*/

		
	}
	public void liabilities() throws IOException, AWTException {
		Robot r = new Robot();
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(4);
		String currentOutstdAmount = data.get("CurrentOutstandingAmount");
	    String currentEMI = data.get("CurrentEMI");

		dG.genericClick(driver, dG.saveAddMoreLiabilities);
		logger.pass("Clicked on Save and AddMore");
		if(fun.isElementDisplayed(dG.liabilitiesNameTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.liabNameErrMsg).getText(), "Please enter name of liability");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.liabNameErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for Liabilities Name Field");}
			}
		
		if(fun.isElementDisplayed(dG.nameHolderDropDown)) {
			try{Assert.assertEquals(driver.findElement(dG.nameHolderErrMsg).getText(), "Please select name of liability holder");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.nameHolderErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for Holder Name Selection Field");}
			}
		
		if(fun.isElementDisplayed(dG.currentOutstandingamtTxt)) {
			try{Assert.assertEquals(driver.findElement(dG.outstandingAmtErrMsg).getText(), "Please enter current outstanding amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.outstandingAmtErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for Current Outstanding Amount Field");}
			}
		
		if(fun.isElementDisplayed(dG.liabilitiesEndDate)) {
			try{Assert.assertEquals(driver.findElement(dG.liabEndDateErrMsg).getText(), "Please select end date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.liabEndDateErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for End Date Field");}
			}
		if(fun.isElementDisplayed(dG.currentEMITxt)) {
			try{Assert.assertEquals(driver.findElement(dG.currentEMIErrMsg).getText(), "Please enter EMI amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentEMIErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for EMI Amount Field");}
			}
		
		if(fun.isElementDisplayed(dG.currentEMITxt)) {
			dG.genericSendKeys(driver, dG.currentOutstandingamtTxt, currentOutstdAmount);
			logger.pass("Entered Outstanding Amount is"+" "+currentOutstdAmount);
			dG.genericSendKeys(driver, dG.currentEMITxt, currentEMI);
			logger.pass("Entered EMI is"+" "+currentEMI);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			try{Assert.assertEquals(driver.findElement(dG.currentEMIErrMsg).getText(), "Please enter EMI less than outstanding amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.currentEMIErrMsg).getText());}
			catch(Exception e) {
					logger.fail("Error Message not Displayed for EMI Amount Field");}
			}
		
		    driver.findElement(dG.currentOutstandingamtTxt).clear();
		    driver.findElement(dG.currentEMITxt).clear();
	}
	
}
