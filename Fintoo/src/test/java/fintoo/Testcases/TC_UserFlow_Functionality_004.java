package fintoo.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_UserFlow_Functionality_004 extends BaseClass {

	@Test
	public void userFlowFunctionality() throws Exception {
	 logger=  extent.createTest("UserFlow Functionality");
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
     Thread.sleep(6000);
     dB.clickFP_AddCart();
     logger.pass("Clicked on Financial Planning Add to Cart");
     Thread.sleep(6000);
     dB.genericClick(driver, dB.deleteItem_Cart);
     logger.pass("Clicked on Delete Item from Cart");
     Thread.sleep(6000);
     dB.clickFP_AddCart();
     logger.pass("Clicked on Financial Planning Add to Cart");
     Thread.sleep(6000);
     
     dB.clickStartMyPlan();
     logger.pass("Clicked on Start My Plan");
   logger.pass("Landed on Page:- "+ bill.onLinePayLabel());
     Thread.sleep(3000);
     driver.navigate().back();
     logger.pass("Clicked on Back Arrow");
     Thread.sleep(2000);
     dB.genericClick(driver, dB.inVoice);
     logger.pass("Clicked on Invoice");
     Thread.sleep(3000);
     dB.genericClick(driver, dB.downloadFirstInvoicePdf);
     logger.pass("Clicked on Download First Pdf");
     Thread.sleep(19000);
     logger.pass("Downloaded file name is:- "+fun.isFileDownloaded());
     dB.genericClick(driver, dB.startAPlan);
     Thread.sleep(3000);//p[text()='financial planning']
     dB.clickStartPlan();
     logger.pass("Clicked on Start Plan");
     Thread.sleep(6000);
     dB.genericClick(driver, dB.deleteItem_Cart);
     logger.pass("Clicked on Delete Item from Cart");
     dB.genericClick(driver, dB.iIcon_Fp);
     Thread.sleep(3000);
     dB.genericClick(driver, dB.iIcon_DownloadReport);
     logger.pass("Clicked on Download Report");
     dB.genericClick(driver, dB.iIcon_AddCart);
     logger.pass("Clicked on Add to Cart");
     if(driver.findElement(dB.fp_Label).isDisplayed()) {
    	 logger.pass("Finnancial Plan Added through i Icon");
     }
     
     
     
	
	
	}


	
}
