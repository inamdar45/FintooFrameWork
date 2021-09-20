package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_UserFlow_Negative_005 extends BaseClass{
	
	
	@Test
	public void userFlowNegative() throws IOException, InterruptedException, AWTException {
		
		logger=  extent.createTest("UserFlow Negative Scenarios");
		extentTest.set(logger);
			LoginPage lp = new LoginPage(driver);
		Reporting r = new Reporting();
		DashBoard dB= new DashBoard(driver);
		Billing bill =new Billing(driver);
		functions fun =new functions(driver);
		String excelPath = readconfig.getExcelPath();
		int rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
		
		logger.pass("Login Started");
		Thread.sleep(8000);
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Login Link");
	     Thread.sleep(8000);
		lp.setEmailMob(username);
		logger.pass("Entered email Id or mobile number "+username);
		lp.setPassword(pass);
		logger.pass("Entered password "+pass);
		lp.loginButton();
	    Assert.assertEquals(driver.getTitle(),"Fintoo"); 
		logger.pass("Login sucessful");
		Thread.sleep(6000);
	     dB.clickStartPlan();
	     logger.pass("Clicked on Start Plan");
	     dB.clickStartMyPlan();
	     logger.pass("Clicked on Start My Plan");
	     if(driver.findElement(dB.errorMsg).isDisplayed()) {
	    	
	    	 logger.pass(driver.findElement(dB.errorMsg).getText());
	    	
	     }
	     Thread.sleep(6000);
	     dB.clickApplyFintooOffer();
	     logger.pass("Clicked on Apply fintoo Offer");
	     Thread.sleep(3000);
	     
	     if(driver.findElement(dB.addPlanFirst).isDisplayed()) {
		    	
	    	 logger.pass(driver.findElement(dB.addPlanFirst).getText());
	    	
	     }
	     
	     dB.clickStartMyPlan();
	     logger.pass("Clicked on Start My Plan");
	     if(driver.findElement(dB.errorMsg).isDisplayed()) {
	    	
	    	 logger.pass(driver.findElement(dB.errorMsg).getText());
	    	
	     }
	     
	     Thread.sleep(6000);
	     dB.clickFP_AddCart();
	     logger.pass("Clicked on Financial Planning Add to Cart");
	     Thread.sleep(6000);
	     dB.clickFP_AddCart();
	     logger.pass("Clicked on Financial Planning Add to Cart");
	     logger.pass(driver.findElement(dB.planAlreadyExist).getText());
	     
	   
	}

}
