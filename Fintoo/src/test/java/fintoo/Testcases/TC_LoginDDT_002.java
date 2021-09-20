package fintoo.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import fintoo.PageObject.LoginPage;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_LoginDDT_002 extends BaseClass {
	//private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{Thread.sleep(5000);
		logger=extent.createTest("LoginDDT");
		extentTest.set(logger);
		LoginPage lp=new LoginPage(driver);
		logger.pass("Login Started");
		//logger.log(Pass, "Login IN");
		
		lp.genericClick(driver, lp.loginLink);
		
		//lp.loginLink();
		logger.pass("Clicked on Login Link");
		lp.setEmailMob(user);
		logger.pass("Entered email Id or Mobile number:- "+user);
		lp.setPassword(pwd);
		logger.pass("Entered password:- "+pwd);
		lp.loginButton();
	
//		
		if(driver.findElement(lp.emailMobErrorMsg).isDisplayed()) {
			logger.pass(driver.findElement(lp.emailMobErrorMsg).getText());
		}
		
		if(driver.findElement(lp.passwordErrorMsg).isDisplayed()) {
			logger.pass(driver.findElement(lp.passwordErrorMsg).getText());
		}
		if(lp.webElement(lp.errorMsg).isDisplayed()) {
			Thread.sleep(1000);
			logger.fail("Please Enter Valid Credentials");
			logger.fail("Login failed");
			Assert.assertTrue(false);
			
		}
//		
		/*if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.fail("Login failed");
		}*/
		else
		{   Thread.sleep(5000);
			Assert.assertEquals(driver.getTitle(),"Fintoo"); 
		logger.pass("Login sucessful");
		      lp.logOutButton();
		logger.pass("LogOut sucessful");
			Thread.sleep(3000);
		//	driver.switchTo().alert().accept();//close logout alert
			//driver.switchTo().defaultContent();
			
		}
//		
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
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
	return logindata;
	}
	
	

}
