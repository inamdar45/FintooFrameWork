package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_DataGathering_Neg_KnowYourRisk_009 extends BaseClass{

	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);
	
	@Test
	public void dataGatheringNegative01() throws IOException, InterruptedException, AWTException{
		Robot robot= new Robot();
		logger=  extent.createTest("Datagathering_Neg_KnowYourRisk");
		extentTest.set(logger);
			
		String excelPath = readconfig.getExcelPath();
		int rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
		ArrayList<String> datagatheringList= new ArrayList<>();
		//HashMap<String, String> dGMap=new HashMap<String, String>();
		int rowsize = XLUtils.getRowCount(excelPath, "Datagathering");
		int colsize = XLUtils.getCellCount(excelPath, "Datagathering", rowsize);
		
		for(int i=5;i<=rowsize;i++) {
			for(int j=0;j<=colsize;j++) {
		//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
			
			String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
			datagatheringList.add(abc);
		//	dGMap.put(key, value)
			}
		}
		logger.pass("Login Started");
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Loggin Link");
        //lp.setEmailMob(username);
		lp.genericSendKeys(driver, lp.emailMobTextBox, username);
		logger.pass("Entered email Id or mobile number "+username);
		lp.genericSendKeys(driver, lp.passwordTextBox, pass);
		logger.pass("Entered password "+pass);
		//lp.loginButton();
		lp.genericClick(driver, lp.loginButton);
		logger.pass("Clicked on LoginButton ");
	    Assert.assertEquals(driver.getTitle(),"Fintoo"); 
		logger.pass("Login sucessful");
		Thread.sleep(6000);
		if(driver.findElement(dG.scoreCard).isDisplayed()) {
			dG.genericClick(driver, dG.myPlan);
			logger.pass("Clicked on My Plan");
		}
		Thread.sleep(3000);
		dG.genericClick(driver, dG.continueButton01);
		logger.pass("Clicked on Continue Button");
		Thread.sleep(5000);
		if(driver.findElement(dG.signOffButton).isDisplayed()) {
			dG.genericClick(driver, dG.dataGatheringButton);
			logger.pass("Clicked on DataGathering link");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.addDataButton);
		logger.pass("Clicked on Add Data Button");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.knowYourRiskLink);
		logger.pass("Clicked on Know Your Risk Link");
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton1);
		logger.pass("Clicked on Next 1");
		dG.genericClick(driver, dG.dataGatheringSaveButton1);
		logger.pass("Clicked on Save button 1");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer One Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton2);
		logger.pass("Clicked on Next 2");
		dG.genericClick(driver, dG.dataGatheringSaveButton2);
		logger.pass("Clicked on Save button 2");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer two Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton3);
		logger.pass("Clicked on Next 3");
		dG.genericClick(driver, dG.dataGatheringSaveButton1);
		logger.pass("Clicked on Save button 3");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Three Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton4);
		logger.pass("Clicked on Next 4");
		dG.genericClick(driver, dG.dataGatheringSaveButton4);
		logger.pass("Clicked on Save button 4");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Four Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton5);
		logger.pass("Clicked on Next 5");
		dG.genericClick(driver, dG.dataGatheringSaveButton5);
		logger.pass("Clicked on Save button 5");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Five Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton6);
		logger.pass("Clicked on Next 6");
		dG.genericClick(driver, dG.dataGatheringSaveButton6);
		logger.pass("Clicked on Save button 6");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Six Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton7);
		logger.pass("Clicked on Next 7");
		dG.genericClick(driver, dG.dataGatheringSaveButton7);
		logger.pass("Clicked on Save button 7");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Seven Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton8);
		logger.pass("Clicked on Next 8");
		dG.genericClick(driver, dG.dataGatheringSaveButton8);
		logger.pass("Clicked on Save button 8");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Eight Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.nextButton9);
		logger.pass("Clicked on Next 9");
		dG.genericClick(driver, dG.dataGatheringSaveButton9);
		logger.pass("Clicked on Save button 9");
		if(driver.findElement(dG.saveUpdate).getText().contains("0")) {
			logger.pass("Answer Nine Not Saved");
		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.dataGatheringSaveButton10);
		logger.pass("Clicked on Save button 10");
		Thread.sleep(5000);
		if(driver.findElement(dG.familyDetailLable).isDisplayed()) {
			logger.pass("Proceeded without Saving any Answer.");
		}
	}
	
}
