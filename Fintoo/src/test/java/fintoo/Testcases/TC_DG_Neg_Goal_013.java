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


public class TC_DG_Neg_Goal_013 extends BaseClass {
	
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

	TC_DataGathering_008 tcDG=new TC_DataGathering_008();
	TC_DG_Neg_IncomeAndExpense_012 tcDG12 = new TC_DG_Neg_IncomeAndExpense_012();
	String excelPath = readconfig.getExcelPath();
	
	@Test
	public void datagatheringGoalNeg01() throws IOException, InterruptedException, AWTException {
		
		
		tcDG.dataGathering01();
		tcDG.incomeExpensePositive();
		logger=  extent.createTest("Datagathering Goal Negative");
		extentTest.set(logger);
		dG.genericClick(driver, dG.goalLink);
		logger.pass("Clicked on goal link.");
		dG.genericClick(driver, dG.educationButton);
		logger.pass("Clicked on Education Tab");
		negErrMsg();
		dG.genericClick(driver, dG.marriageButton);
		logger.pass("Clicked on Marriage Tab");
		negErrMsg();
		dG.genericClick(driver, dG.vehicleButton);
		logger.pass("Clicked on Vehicle Tab");
		negErrMsg();
		dG.genericClick(driver, dG.propertyButton);
		logger.pass("Clicked on Property Tab");
		negErrMsg();
		dG.genericClick(driver, dG.vacationButton);
		logger.pass("Clicked on Vacation Tab");
		negErrMsg();
		dG.genericClick(driver, dG.emergencyButton);
		logger.pass("Clicked on Emergency Tab");
		negErrMsg();
		dG.genericClick(driver, dG.goalOthersButton);
		logger.pass("Clicked on Others Tab");
		negErrMsg();
	}
	
	
	public void negErrMsg() throws IOException {
		
		dG.genericClick(driver, dG.goalSaveAndAddMore);
		logger.pass("Clicked on Save and AddMore Button");
		if(driver.findElement(dG.goalNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalNameErrorMsg).getText(), "Please enter goal name");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalNameErrorMsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Goal Name");
		}
		
		if(driver.findElement(dG.goalSelectMemberErrormsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalSelectMemberErrormsg).getText(), "Please select a member");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalSelectMemberErrormsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Goal For");
		}
		
		if(driver.findElement(dG.goalCurrentValueErrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalCurrentValueErrMsg).getText(), "Please enter goal current value");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalCurrentValueErrMsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Goal Current Value");
		}
		
		if(driver.findElement(dG.setPriorityErrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.setPriorityErrMsg).getText(), "Please set priority for this goal");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.setPriorityErrMsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Set Priority for Goal ");
		}
		
		if(driver.findElement(dG.goalEndDateErrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalEndDateErrMsg).getText(), "Please select date");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalEndDateErrMsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Goal End Date ");
		}
		
		String goalName=fun.getDataList(excelPath, "Datagathering").get(66);
		//tcDG12.datagatheringList5.get(66);
		dG.genericSendKeys(driver, dG.goalNameTxt, goalName);
		
		if(driver.findElement(dG.goalNameErrorMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalNameErrorMsg).getText(), "Special characters not allowed");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalNameErrorMsg).getText());
			driver.findElement(dG.goalNameTxt).clear();
		}
		else {
			logger.fail("Error Message not Displayed for Goal Name with Special Characters ");
			driver.findElement(dG.goalNameTxt).clear();
		}
		
		dG.genericClick(driver, dG.oneTimeRecurrSlider);
		logger.pass("Clicked on Recurring");
		dG.genericClick(driver, dG.goalSaveAndAddMore);
		logger.pass("Clicked on Save and AddMore Button");
		
		if(driver.findElement(dG.goalStartDateerrMsg).isDisplayed()) {
			Assert.assertEquals(driver.findElement(dG.goalStartDateerrMsg).getText(), "Please select start date");
			logger.pass("Error Message displayed is"+ " "+driver.findElement(dG.goalStartDateerrMsg).getText());
			
		}
		else {
			logger.fail("Error Message not Displayed for Goal Start Date ");
		}
		
		dG.genericClick(driver, dG.oneTimeRecurrSlider);
		logger.pass("Clicked on Recurring");
		
		
	}
	
}
