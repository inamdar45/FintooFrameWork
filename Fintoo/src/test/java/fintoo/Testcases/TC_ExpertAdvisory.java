package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.FinancialPlanningPage;
import fintoo.PageObject.HomePage;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_ExpertAdvisory extends BaseClass {
	LoginPage lp = new LoginPage(driver);
	String excelPath = readconfig.getExcelPath();
	HomePage hp = new HomePage(driver);
	FinancialPlanningPage fp = new FinancialPlanningPage(driver);
	functions fun = new functions(driver);
	static int p;
	@Test
	public void expertAdvisory() throws IOException, InterruptedException, AWTException {
		logger = extent.createTest("Login");
 		extentTest.set(logger);
 		String excelPath = readconfig.getExcelPath();
 		int expertRowCount=XLUtils.getRowCount(excelPath, "FP_Details");
 		for( p=1;p<=expertRowCount;p++) {
 		
		String username = XLUtils.getCellData(excelPath, "Login", p, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", p, 1);
		
		TC_DataGathering_008 tcDG= new TC_DataGathering_008();
		try {
		tcDG.loginAndStartPlan();}
		catch(Exception e) {e.printStackTrace();}
		if(fun.isElementDisplayed(lp.loginLink)) {
		logger.pass("Login Started");
		lp.genericClick(driver, lp.loginLink);
		logger.pass("Clicked on Loggin Link");
		lp.genericSendKeys(driver, lp.emailMobTextBox, username);
		logger.pass("Entered email Id or mobile number " + username);
		lp.genericSendKeys(driver, lp.passwordTextBox, pass);
		logger.pass("Entered password " + pass);
		Thread.sleep(5000);
		String value1 = driver.findElement(By.id("captcha_code")).getAttribute("value");
		Base64.Decoder decoder = Base64.getDecoder();
		String captchaTxt = new String(decoder.decode(value1));
		lp.genericSendKeys(driver, lp.captchaText, captchaTxt);
		logger.pass("Entered Captcha is" + captchaTxt);
		lp.genericClick(driver, lp.loginButton);
		logger.pass("Clicked on LoginButton ");
		Assert.assertEquals(driver.getTitle(), "Fintoo");
		logger.pass("Login sucessful");}
		Thread.sleep(6000);
		if(fun.isElementDisplayed(lp.fintooLogoDashboard)) {
		lp.genericClick(driver, lp.fintooLogoDashboard);
		logger.pass("Clicked on Fintoo logo");
		hp.genericClick(driver, hp.advisoryLink);
		logger.pass("Clicked on Advisory Link");
		hp.genericClick(driver, hp.services_FP);
		logger.pass("Clicked on Financial Planning");
		fp.genericClick(driver, fp.startPlanButton);
		logger.pass("Clicked on Start a Plan Button");
		fp.genericClick(driver, fp.expertAdvisoryButton);
		logger.pass("Clicked on Expert Advisory Button");
		fp.genericClick(driver, fp.startButton);
		logger.pass("Clicked on Start Button");
		// Fill in your details code
		Map<String, String> data = fun.getTestDataInMap(excelPath, "FP_Details").get(p-1);
		String formName =  data.get("FormName");
		String formEmailID =  data.get("FormEmailID");
		String formMobileNum =  data.get("FormMobile");
		String formExpertName =  data.get("ExpertName");
		fp.genericSendKeys(driver, fp.formName, formName);
		logger.pass("Form Name Entered"+formName);
		fp.genericSendKeys(driver, fp.formEmailId, formEmailID);
		logger.pass("Form EmailID Entered"+formEmailID);
		fp.genericSendKeys(driver, fp.formMobNum, formMobileNum);
		logger.pass("Form Form Mobile Number Entered"+formMobileNum);
		fp.genericClick(driver, fp.formDropdown);
		By expertNameLocator = By.xpath("//div[text()='"+formExpertName+"']");
		fp.genericClick(driver, expertNameLocator);
		logger.pass("Form Expert Name Entered"+formExpertName);
		Thread.sleep(5000);
		String value01 = driver.findElement(By.id("captcha_code")).getAttribute("value");
		Base64.Decoder decoder1 = Base64.getDecoder();
		String captchaTxt1 = new String(decoder1.decode(value01));
		lp.genericSendKeys(driver, lp.captchaText, captchaTxt1);
		logger.pass("Entered Captcha is" + captchaTxt1);
		fp.genericClick(driver, fp.submitButton);
		logger.pass("Clicked on Submit Button");
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(fp.agreeCheckBox));
	/*	JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");*/
		Thread.sleep(5000);
		element.click();
          logger.pass("Clicked on CheckBox");
          fp.genericClick(driver, fp.proceedButton);
          logger.pass("Clicked on Proceed Button");
          Thread.sleep(5000);
          WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(fp.popOkButtonNDA));
	       element1.click();
	       logger.pass("clicked on NDA Ok Popup");
		}
		
		
		try {
		tcDG.dataGathering01();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.incomeExpensePositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.goalsPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.assetsEquityPostive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.assetDebtPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.realEstatePositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.liquidPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.alternativePositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.goldPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.othersAssetPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.liabilitiesPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.insurancePositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.myDocumentPositive();}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.generateReport();
		WebDriverWait wait=new WebDriverWait(driver,15);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(fp.agreeFPCheckBox));
		Thread.sleep(5000);
		element.click();
		logger.pass("Clicked on CheckBox");
        fp.genericClick(driver, fp.proceedButton);
        logger.pass("Clicked on Proceed Button");
        
        Thread.sleep(5000);
        WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(fp.popOkButtonFP));
	       element1.click();
	       logger.pass("clicked on FP Ok Popup");
		}
		catch(Exception e) {e.printStackTrace();}
		try {
		tcDG.logOut();}
		catch(Exception e) {e.printStackTrace();}
		
		
		
 		}
 		}
}
