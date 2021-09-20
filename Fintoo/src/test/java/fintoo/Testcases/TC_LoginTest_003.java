package fintoo.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import fintoo.PageObject.LoginPage;
import fintoo.Utilities.XLUtils;

public class TC_LoginTest_003 extends BaseClass {
	public String logindata[][];

	@Test
	public void testLogin() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		logger=extent.createTest("TestLogin");
		 extentTest.set(logger);
		 logger.pass("Login Started");
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Forget Password");
		lp.genericClick(driver, lp.forgotPassword);
	
		String excelPath = readconfig.getExcelPath();
		int rownum=XLUtils.getRowCount(excelPath, "Login");
		int colcount=XLUtils.getCellCount(excelPath,"Login",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(excelPath,"Login", i,j);//1 0
			}
				
		}
		
		for(int k=0;k<rownum;k++) {
			lp.setEmailMob(logindata[k][0]);
			logger.pass("Entered email or mobile number:- " +logindata[k][0]);
			lp.genericClick(driver, lp.sendOTPButton);
			logger.pass("Clicked on Send OTP Button");
			Thread.sleep(8000);
			if(driver.findElement(lp.sendOTPButton).isDisplayed()) {
				logger.pass("Please Enter Valid Email or Mobile number");
			}
			else
			{
				logger.pass(driver.findElement(lp.labelOTPSend).getText());
				driver.navigate().back();
				
				logger.pass("Clicked on Back Button");
				Thread.sleep(3000);
				lp.genericClick(driver, lp.forgotPassword);
				logger.pass("Clicked on Forget Password");
				
				
			}
			
					}
		
		lp.genericClick(driver, lp.loginWithPassword);
		logger.pass("Clicked on Login with Password");
		lp.genericClick(driver, lp.loginOTP);
		logger.pass("Clicked on Login with OTP");
		
		for(int k=0;k<rownum;k++) {
			Thread.sleep(5000);
			lp.setEmailMob(logindata[k][0]);
			logger.pass("Entered email or mobile number:- " +logindata[k][0]);
			lp.genericClick(driver, lp.sendOTPButton);
			logger.pass("Clicked on Send OTP Button");
			Thread.sleep(8000);
			if(driver.findElement(lp.sendOTPButton).isDisplayed()) {
				logger.pass("Please Enter Valid Email or Mobile number");
			}
			else
			{
				logger.pass(driver.findElement(lp.labelOTPSend).getText());
				driver.navigate().back();
				logger.pass("Clicked on Back Button");
				Thread.sleep(3000);
				lp.genericClick(driver, lp.loginOTP);
				logger.pass("Clicked on Login with OTP Password");
				Thread.sleep(3000);
				
			}
			
					}
		Thread.sleep(5000);
		if(driver.findElement(lp.sendOTPButton).isDisplayed()) {
			driver.navigate().back();
			logger.pass("Clicked on Back Button");
		}
		Thread.sleep(3000);
		 lp.genericClick(driver, lp.registerNow);
		 logger.pass("Clicked on Register Now Link");
		 logger.pass("Registeration Page Opened");
		
		
	}
	
	
	public void getData() throws IOException
	{
		String excelPath = readconfig.getExcelPath();
		int rownum=XLUtils.getRowCount(excelPath, "Login");
		int colcount=XLUtils.getCellCount(excelPath,"Login",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(excelPath,"Login", i,j);//1 0
			}
				
		}
	
	}
	public void forgetOTPLogin() {}
}
