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

public class TC_UserFlowCombo_004 extends BaseClass {

	
	@Test
	public void userFlowTestCombo() throws Exception {
	 logger=  extent.createTest("UserFlow Combo Planning");
	extentTest.set(logger);
		LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	String excelPath = readconfig.getExcelPath();
	int rownum = XLUtils.getRowCount(excelPath, "Login");
	int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
	String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
	String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
	
	//JavascriptExecutor js = ((JavascriptExecutor) driver);
	//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	//logger=extent.createTest("loginTest");
	logger.pass("Login Started");
	//logger.log(Pass, "Login IN");
	lp.genericClick(driver, lp.loginLink);
	
	//lp.loginLink();
	logger.pass("Clicked on Loggin Link");
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
     Thread.sleep(6000);
     dB.clickFP_AddCart();
     logger.pass("Clicked on Financial Planning Add to Cart");
     Thread.sleep(6000);
     dB.clickRP_AddCart();
     logger.pass("Clicked on Retirement Planning Add to Cart");
     Thread.sleep(6000);
     dB.clickApplyComboOffer();
     logger.pass("Clicked on Apply Combo Offer");
     Thread.sleep(6000);
     dB.clickStartMyPlan();
     logger.pass("Clicked on Start My Plan");
     Thread.sleep(6000);
     dB.genericClick(driver, dB.firstContinueButton);
     logger.pass("Clicked on latest Plan");
     Thread.sleep(6000);
     bill.genericClick(driver, bill.billingButton);
     logger.pass("Clicked on Billing Button");
     Thread.sleep(3000);
        logger.pass(bill.paymentsucess());
    logger.pass("Total MRP is"+bill.totalMRP());
    logger.pass("Total GST is"+bill.totalGST());
    logger.pass("Total Amount Paid is"+bill.totalPaidAmount());
	
	
	}

}
