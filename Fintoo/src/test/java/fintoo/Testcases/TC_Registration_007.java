package fintoo.Testcases;

import org.testng.annotations.Test;

import fintoo.PageObject.LoginPage;
import fintoo.PageObject.RegistrationPage;

public class TC_Registration_007 extends BaseClass{

	
	LoginPage lp = new LoginPage(driver);
	RegistrationPage rp = new RegistrationPage(driver);
	String excelPath = readconfig.getExcelPath();
	int rownum;
	int colnum;
	String mobileNo, randomNumber, pass, randomEmail;

	@Test
	public void randomRegistration() throws InterruptedException {
		logger = extent.createTest("Random Registration");
		extentTest.set(logger);
		 randomNumber = "987654"+randomeNum();
		 randomEmail = randomestring()+"@gmail.com";
		 pass = "12345678";
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Login Link");
		lp.genericClick(driver, lp.registerNow);
		logger.pass("Clicked on Register Now");
		
		rp.genericSendKeys(driver, rp.mobileNumberTxtField,randomNumber );
		logger.pass("Enter Mobile Number is:-" + randomNumber);
		rp.genericSendKeys(driver, rp.emailTxtField, randomEmail);
		logger.pass("Entered Emil is:-"+randomEmail);
		rp.genericSendKeys(driver, rp.passwordTxtField, pass);
		logger.pass("Entered Password is:-"+pass);
		rp.genericSendKeys(driver, rp.confirmPasswordTxtField, pass);
		logger.pass("Confirmed Password is:-"+pass);
		
		rp.genericClick(driver, rp.checkBox);
		logger.pass("Clicked on  I Accept T&C CheckBox");
		rp.genericClick(driver, rp.registerButton);
		logger.pass("Clicked on Register Button");
		Thread.sleep(3000);
		logger.pass(driver.findElement(rp.otpSentTo).getText());
	}
}
