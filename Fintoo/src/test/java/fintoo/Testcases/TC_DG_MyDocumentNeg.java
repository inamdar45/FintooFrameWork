package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.functions;

public class TC_DG_MyDocumentNeg extends BaseClass{
	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);
	ArrayList<String> datagatheringList;
	ArrayList<String> datagatheringList1;
	ArrayList<String> datagatheringList2;
	ArrayList<String> datagatheringList3;
	String excelPath = readconfig.getExcelPath();
	TC_DataGathering_008 dG8 = new TC_DataGathering_008();
	
	
	@Test
	public void myDocumentNegative() throws IOException, InterruptedException, AWTException {
		Map<String, String> data = fun.getTestDataInMap(excelPath, "Datagathering").get(0);
		  String documentType=data.get("DocumentType");
		  String documentName=data.get("DocumentName");
		dG8.dataGathering01();
		// dG8.incomeExpensePositive();
		//  dG8.goalsPositive();
		logger=  extent.createTest("MyDocument Negative Scenarios");
		extentTest.set(logger);
		dG.genericClick(driver, dG.aboutYouLink);
		fun.scrollToElement(driver.findElement(dG.documentLink));
		dG.genericClick(driver, dG.documentLink);
		Thread.sleep(6000);
		logger.pass("Clicked on My Document Link");
		dG.genericClick(driver, dG.documentLink);
		dG.genericClick(driver, dG.documentSubmitButton);
		logger.pass("Clicked on Document Submit Button");
		
		try {
			Assert.assertEquals(driver.findElement(dG.documentTypeErrMsg).getText(), "This field is required.");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.documentTypeErrMsg).getText());}
		catch(Exception e) {
			logger.fail("Error Mesage Not Displayed for Document Type");
		}
		
		try {
			Assert.assertEquals(driver.findElement(dG.documentNameErrMsg).getText(), "Please enter document name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.documentNameErrMsg).getText());}
		catch(Exception e) {
			logger.fail("Error Mesage Not Displayed for Document Name");
		}
		dG.genericClick(driver, dG.documentDropDown);
		By documentTypeElement = By.xpath("//div[text()='"+documentType+"']");
		dG.genericClick(driver, documentTypeElement);
		logger.pass("Entered Document Type"+documentType);
		dG.genericSendKeys(driver, dG.documentNameTxt, documentName);
		logger.pass("Document Name Entered is "+" "+documentName );
		dG.genericClick(driver, dG.documentSubmitButton);
		logger.pass("Clicked on Document Submit Button");
		try {
			Assert.assertEquals(driver.findElement(dG.documentUploadErrMsg).getText(), "Please select atleast one document to upload.");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.documentUploadErrMsg).getText());}
		catch(Exception e) {
			logger.fail("Error Mesage Not Displayed for Upload Documents");
		}
		
		
		
		
		
	}
}
