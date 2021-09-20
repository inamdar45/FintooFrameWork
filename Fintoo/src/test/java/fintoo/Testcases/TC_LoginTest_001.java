package fintoo.Testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import fintoo.PageObject.LoginPage;
import fintoo.Utilities.ReadConfig;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass {
	ReadConfig readconfig = new ReadConfig();
	 
            
	// LoginTest checks basic login and logout functions with valid credentials.
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
	 logger=extent.createTest("LoginTest");
	 extentTest.set(logger);
		LoginPage lp = new LoginPage(driver);
		Reporting r = new Reporting();
		String excelPath = readconfig.getExcelPath();
		int rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
		
		logger.pass("Login Started");
		//logger.log(Pass, "Login IN");
		lp.genericClick(driver, lp.loginLink);
		
		//lp.loginLink();
		logger.pass("Clicked on Loggin Link");
		lp.setEmailMob(username);
		logger.pass("Entered email Id or Mobile number "+username);
		lp.setPassword(pass);
		logger.pass("Entered password "+pass);
		lp.genericClick(driver, lp.rememberCheckBox);
		logger.pass("Clicked on Remember CheckBox");
		lp.loginButton();
	    Assert.assertEquals(driver.getTitle(),"Fintoo"); 
		logger.pass("Login sucessful");
		lp.logOutButton();
		logger.pass("LogOut sucessful");
	}

}
