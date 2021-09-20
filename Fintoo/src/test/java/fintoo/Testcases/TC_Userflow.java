package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.ReadConfig;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;

public class TC_Userflow extends BaseClass{
	ReadConfig readconfig = new ReadConfig();
	
	
	@Test
	public void userFlowTest() throws IOException, InterruptedException, AWTException {
	 logger=  extent.createTest("UserFlow Financial Planning");
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
	logger.pass("Login Started");
	lp.genericClick(driver, lp.loginLink);
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
     dB.clickApplyFintooOffer();
     logger.pass("Clicked on Apply fintoo Offer");
     Thread.sleep(6000);
     dB.clickStartMyPlan();
     logger.pass("Clicked on Start My Plan");
     Thread.sleep(6000);
    logger.pass(bill.paymentsucess());
    logger.pass("Total MRP is"+bill.totalMRP());
    logger.pass("Total GST is"+bill.totalGST());
    logger.pass("Total Amount Paid is"+bill.totalPaidAmount());
	
	
	}

	}
