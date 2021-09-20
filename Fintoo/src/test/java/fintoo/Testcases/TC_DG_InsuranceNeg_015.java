package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.functions;


public class TC_DG_InsuranceNeg_015 extends BaseClass {
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
	@Test
	public void insuranceNegative() throws IOException, InterruptedException, AWTException {
		dG8.dataGathering01();
		// dG8.incomeExpensePositive();
		//  dG8.goalsPositive();
		logger=  extent.createTest("Insurance Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.aboutYouLink);
		fun.scrollToElement(driver.findElement(dG.insuranceLink));
		dG.genericClick(driver, dG.insuranceLink);
		logger.pass("Clicked on insurance Link");
		termPlan();
		dG.genericClick(driver, dG.ulipTab);
		logger.pass("Clicked on ULIP Tab");
		termPlan();
		dG.genericClick(driver, dG.endownmentTab);
		logger.pass("Clicked on EnDownment Tab");
		termPlan();
		dG.genericClick(driver, dG.guranteeIncomePlanTab);
		logger.pass("Clicked on Gurantee Income Plan Tab");
		termPlan();
		dG.genericClick(driver, dG.generalPlanTab);
		logger.pass("Clicked on General plan Tab");
		termPlan();
		dG.genericClick(driver, dG.mediClaimTab);
		logger.pass("Clicked on MediClaim Tab");
		termPlan();
		dG.genericClick(driver, dG.pensionPlanTab);
		logger.pass("Clicked on Pension Plan Tab");
		termPlan();
		dG.genericClick(driver, dG.otherPlanTab);
		logger.pass("Clicked on Other plan Tab");
		termPlan();
	}
	
	public void termPlan() {
		dG.genericClick(driver, dG.saveAddMoreAssetsLib);
        logger.pass("Clicked on save and More Button");
        if( fun.isElementDisplayed(dG.insurancePlanNameTxt)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insPlanNameErrMsg).getText(), "Please enter plan name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insPlanNameErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Insurance Plan Name");
			}}
        
        if( fun.isElementDisplayed(dG.ulipErrMsg)) {
			try {
				Assert.assertEquals(driver.findElement(dG.ulipErrMsg).getText(), "Please select ULIP name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.ulipErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for ULIP Plan");
			}}
        
        if( fun.isElementDisplayed(dG.insuranceForErrMsg)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insuranceForErrMsg).getText(), "Please select member name");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insuranceForErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Insurance Type");
			}}
        
        if( fun.isElementDisplayed(dG.insPremiumAmountTxt)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insPremiumAmountErrMsg).getText(), "Please enter premium amount");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insPremiumAmountErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Premium Amount");
			}}
        
        if( fun.isElementDisplayed(dG.insSumAssuredTxt)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insSumAssuredErrMsg).getText(), "Please enter sum assured");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insSumAssuredErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Sum Assured");
			}}
        
        if( fun.isElementDisplayed(dG.typeInsuranceErrMsg)) {
			try {
				Assert.assertEquals(driver.findElement(dG.typeInsuranceErrMsg).getText(), "This field is required.");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.typeInsuranceErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Type of Insurance");
			}}
        
        
        if( fun.isElementDisplayed(dG.insPremiumPaymentEndDateErrMsg)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insPremiumPaymentEndDateErrMsg).getText(), "Please select premium payment end date");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insPremiumPaymentEndDateErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Premium Payment End Date");
			}}
        
        if( fun.isElementDisplayed(dG.insPolicyEndDateErrMsg)) {
			try {
				Assert.assertEquals(driver.findElement(dG.insPolicyEndDateErrMsg).getText(), "Please select policy end date");
				logger.pass("Error Message Displayed is"+driver.findElement(dG.insPolicyEndDateErrMsg).getText());
			}
			catch(Exception e) {
				logger.fail("Error Message not Displayed for Policy End Date");
			}}
        if(fun.isElementDisplayed(dG.recurringTxt)) {
        	  dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
        	  logger.pass("Clicked on Recurring Toggle Button");
        	  dG.genericClick(driver, dG.saveAddMoreAssetsLib);
              logger.pass("Clicked on save and More Button");
        	  
        	if( fun.isElementDisplayed(dG.insuranceEndDateErrMsg)) {
    			try {
    				Assert.assertEquals(driver.findElement(dG.insuranceEndDateErrMsg).getText(), "Please select end date");
    				logger.pass("Error Message Displayed is"+driver.findElement(dG.insuranceEndDateErrMsg).getText());
    			}
    			catch(Exception e) {
    				logger.fail("Error Message not Displayed for Recurring End Date");
    			}}
        	if( fun.isElementDisplayed(dG.insRecurringAmterrMsg)) {
    			try {
    				Assert.assertEquals(driver.findElement(dG.insRecurringAmterrMsg).getText(), "Please enter amount");
    				logger.pass("Error Message Displayed is"+driver.findElement(dG.insRecurringAmterrMsg).getText());
    			}
    			catch(Exception e) {
    				logger.fail("Error Message not Displayed for Recurring Amount");
    			}}
        	
        	  dG.genericClick(driver, dG.sliderFixedVariableToggleButton);
         	  logger.pass("Clicked on One Time Toggle Button");
        	
        }
	}
	
}
