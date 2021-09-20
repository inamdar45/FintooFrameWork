package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_DataGathering_Negative_009 extends BaseClass {

	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);
	
	@Test
	public void dataGatheringNegative01() throws IOException, InterruptedException, AWTException{
		Robot robot= new Robot();
		logger=  extent.createTest("Datagathering_Neg_YourInfo");
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
		dG.genericClick(driver, dG.continueButton01);
		logger.pass("Clicked on Continue Button");
		Thread.sleep(5000);
		dG.genericClick(driver, dG.addDataButton);
		logger.pass("Clicked on Add Data Button");
		dG.genericClick(driver, dG.saveAndContinue);
		logger.pass("Clicked on Save and Continue");
		WebElement firstName = driver.findElement(dG.firstNameErrorMsg);
		if(firstName.isDisplayed()) {
			Assert.assertEquals(firstName.getText(), "Please enter first name");
			logger.pass("Error Message displayed is"+firstName.getText());
		}
		WebElement lastName = driver.findElement(dG.lastNameErrorMsg);
		if(lastName.isDisplayed()) {
			Assert.assertEquals(lastName.getText(), "Please enter last name");
			logger.pass("Error Message displayed is"+lastName.getText());
		}
		
		WebElement pinCode = driver.findElement(dG.pinCodeErrorMsg);
		if(pinCode.isDisplayed()) {
			Assert.assertEquals(pinCode.getText(), "Please enter pincode");
			logger.pass("Error Message displayed is"+pinCode.getText());
		}
		WebElement panNo = driver.findElement(dG.panNoErrorMsg);
		if(panNo.isDisplayed()) {
			Assert.assertEquals(panNo.getText(), "Please enter PAN");
			logger.pass("Error Message displayed is"+panNo.getText());
		}
		WebElement dob = driver.findElement(dG.dobErrorMsg);
		if(dob.isDisplayed()) {
			Assert.assertEquals(dob.getText(), "Please enter date of birth");
			logger.pass("Error Message displayed is"+dob.getText());
		}
		WebElement occupation = driver.findElement(dG.occupationErrorMsg);
		if(occupation.isDisplayed()) {
			Assert.assertEquals(occupation.getText(), "Please select occupation");
			logger.pass("Error Message displayed is"+occupation.getText());
		}
		
		WebElement retirementAge = driver.findElement(dG.retirementAgeErrorMsg);
		if(retirementAge.isDisplayed()) {
			Assert.assertEquals(retirementAge.getText(), "Please enter retirement age");
			logger.pass("Error Message displayed is"+retirementAge.getText());
		}
		WebElement lifeExpectancy = driver.findElement(dG.lifeExpectancyAgeErrorMsg);
		if(lifeExpectancy.isDisplayed()) {
			Assert.assertEquals(lifeExpectancy.getText(), "Please enter life expectancy age");
			logger.pass("Error Message displayed is"+lifeExpectancy.getText());
		}
		
		dG.genericSendKeys(driver, dG.firstName, datagatheringList.get(0));
		logger.pass("First Name entered is"+datagatheringList.get(0));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement firstName1 = driver.findElement(dG.firstNameErrorMsg);
		if(firstName.isDisplayed()) {
			Assert.assertEquals(firstName1.getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is"+firstName1.getText());
		}
	
		dG.genericSendKeys(driver, dG.lastName, datagatheringList.get(1));
		logger.pass("Last Name entered is"+datagatheringList.get(1));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement lastName1 = driver.findElement(dG.lastNameErrorMsg);
		if(lastName.isDisplayed()) {
			Assert.assertEquals(lastName1.getText(), "Alphabets only allowed");
			logger.pass("Error Message displayed is"+lastName1.getText());
		}
		
		dG.genericSendKeys(driver, dG.residentialAddress, datagatheringList.get(2));
		logger.pass("Residential Address entered is"+datagatheringList.get(2));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement residentialAddress1 = driver.findElement(dG.resAddressErrorMsg);
		if(residentialAddress1.isDisplayed()) {
			Assert.assertEquals(residentialAddress1.getText(), "Please enter atleast 10 characters");
			logger.pass("Error Message displayed is"+residentialAddress1.getText());
		}
		
		dG.genericSendKeys(driver, dG.pinCode, datagatheringList.get(3));
		logger.pass("PinCode entered is"+datagatheringList.get(3));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement pinCode1 = driver.findElement(dG.pinCodeErrorMsg);
		if(pinCode.isDisplayed()) {
			Assert.assertEquals(pinCode1.getText(), "Please enter valid pincode");
			logger.pass("Error Message displayed is"+pinCode1.getText());
		}
		
		dG.genericSendKeys(driver, dG.panNo, datagatheringList.get(5));
		logger.pass("PanNo entered is"+datagatheringList.get(5));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement panNo1 = driver.findElement(dG.panNoErrorMsg);
		if(panNo.isDisplayed()) {
			Assert.assertEquals(panNo1.getText(), "Please enter valid PAN");
			logger.pass("Error Message displayed is"+panNo1.getText());
		}
		
		dG.genericSendKeys(driver, dG.alternateMobileNo, datagatheringList.get(7));
		logger.pass("Alternate Mobile No entered is"+datagatheringList.get(7));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement alternateMobileNo = driver.findElement(dG.alternateNoErrorMsg);
		if(alternateMobileNo.isDisplayed()) {
			Assert.assertEquals(alternateMobileNo.getText(), "Please enter at least 8 characters.");
			logger.pass("Error Message displayed is"+alternateMobileNo.getText());
		}
		
		dG.genericSendKeys(driver, dG.retirementAge, datagatheringList.get(13));
		logger.pass("Retirement Age entered is"+datagatheringList.get(13));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement retirementAge1 = driver.findElement(dG.retirementAgeErrorMsg);
		if(retirementAge.isDisplayed()) {
			Assert.assertEquals(retirementAge1.getText(), "Please enter value more than age");
			logger.pass("Error Message displayed is"+retirementAge1.getText());
		}
		
		dG.genericSendKeys(driver, dG.lifeExpectancy, datagatheringList.get(14));
		logger.pass("life Expectancy Age entered is"+datagatheringList.get(14));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement lifeExpectancy1 = driver.findElement(dG.lifeExpectancyAgeErrorMsg);
		if(lifeExpectancy.isDisplayed()) {
			Assert.assertEquals(lifeExpectancy1.getText(), "Please enter value more than retirement age");
			logger.pass("Error Message displayed is"+lifeExpectancy1.getText());
		}
		
}
}
