package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import fintoo.PageObject.ChatBot;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_ChatBot_001 extends BaseClass{
	functions fun = new functions(driver);
	String excelPath = readconfig.getExcelPath();
	int loginSize = 0;
	ChatBot cB = new ChatBot(driver);
	int rowsize;
	
	
	@Test
	public void chatBotPlan() throws IOException, AWTException, InterruptedException {
		logger = extent.createTest("ChatBot");
		extentTest.set(logger);
		rowsize = XLUtils.getRowCount(excelPath, "ChatBot");
		Map<String, String> data01 = fun.getTestDataInMap(excelPath, "ChatBot").get(loginSize);
		 String planTypeTxt=  data01.get("TypeofPlan");   
		 String investTypeTxt = data01.get("InvestType");
		 String firstNameTxt = data01.get("FirstName");
		 String emailTxt = data01.get("EmailAddress");
		 String moileNumberTxt = data01.get("MobileNumber");
		 String subCategoryTxt=data01.get("SubCategory");
		 
		// String chatInputTxt = data01.get("ChatInput");
		 //String selectOptionTxt = data01.get("SelectOption");
		 By subCategory =By.xpath("//a[text()='"+subCategoryTxt+"']");
		By planType = By.xpath("//div[@class='askMeSentence']/following::a[text()='"+planTypeTxt+"']");
		cB.genericClick(driver, planType);
		logger.pass("Clicked on Plan type as"+" "+planTypeTxt);
        By investType=By.xpath("//div[@class='askMeSentence']//following::a[text()='"+investTypeTxt+"']");
        cB.genericClick(driver, investType);
        logger.pass("Clicked on Investment type as"+" "+investTypeTxt);
        try {
        	cB.genericClick(driver, subCategory);
        	logger.pass("clicked on "+subCategoryTxt);
        }
        catch(NoSuchElementException e) {}
        try {
			cB.genericClick(driver, cB.sipButton);
			logger.pass("Clicked on SIP Button");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        cB.genericSendKeys(driver, cB.firstNameElement, firstNameTxt);
        logger.pass("First Name Entered is"+" "+firstNameTxt);
       	Thread.sleep(3000);
         driver.findElement(cB.firstNameElement).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
        JavascriptExecutor jse = ((JavascriptExecutor)driver);        	
        WebElement email = driver.findElement(cB.emailAddressElement);
        jse.executeScript("arguments[0].value='"+emailTxt+"';", email);
        Thread.sleep(3000);
        driver.findElement(cB.emailAddressElement).sendKeys(Keys.ENTER);

        logger.pass("Email Address Entered is"+" "+emailTxt);
        Thread.sleep(3000);
          
		cB.genericSendKeys(driver, cB.mobileElement, moileNumberTxt);
		driver.findElement(cB.mobileElement).sendKeys(Keys.ENTER);
		logger.pass("Mobile Number Entered is"+" "+moileNumberTxt);
		Thread.sleep(3000);
		
		cB.genericClick(driver, cB.chatSubmit);
		logger.pass("Clicked on Chat Submit Button");
		Thread.sleep(4000);
		fun.waitTillElementVisible(cB.chatInputElement);
		jse.executeScript("window.scrollBy(900,0)", "");
		for (int z = 0; z < rowsize; z++) {
			try {
			Map<String, String> data = fun.getTestDataInMap(excelPath, "ChatBot").get(z);
			String chatInputTxt = data.get("ChatInput");
			 //  String selectOptionTxt01=data.get("SelectOption");
		cB.genericSendKeys(driver, cB.chatInputElement, chatInputTxt);
		driver.findElement(cB.chatInputElement).sendKeys(Keys.ENTER);
		logger.pass("Entered Text In ChatBot is"+" "+chatInputTxt);
		Thread.sleep(4000);
		try {
			driver.findElement(By.xpath("//button[text()='No']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			driver.findElement(By.xpath("//button[text()='No']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//By selectOption =By.xpath("//a[contains(.,'"+selectOptionTxt01+"')]");
		
		//Thread.sleep(3000);
		//cB.genericClick(driver, selectOption);
	//	logger.pass("Selected Option is"+" "+selectOptionTxt);
		//By selectOptionPara =By.xpath("//p[contains(.,'"+selectOptionTxt01+"')]");
	//	int optionSize=driver.findElements(selectOptionPara).size();
	//	Thread.sleep(3000);
	//	String ans=driver.findElement(By.xpath("(//p[contains(.,'"+selectOptionTxt01+"')])["+optionSize+"]//following::p[1]")).getText();
	//	int questionSize= driver.findElements(By.xpath("//p[contains(text(),'"+chatInputTxt+"')]")).size();
		int questionSize= driver.findElements(By.xpath("//p[contains(text(),\""+chatInputTxt+"\")]")).size();
		String ans1=  driver.findElement(By.xpath("(//p[contains(text(),\""+chatInputTxt+"\")])["+questionSize+"]/following::p[1]")).getText();
		String dateTime =driver.findElement(By.xpath("(//p[contains(text(),\""+chatInputTxt+"\")])["+questionSize+"]/following::span[1]")).getText();
	String ans =ans1.replaceAll(dateTime, "");
		XLUtils.setDataForCell(excelPath, "ChatBot", "ActualAnswer", z+1, ans);
		Thread.sleep(3000);
		logger.pass("Answer is"+" "+ans);
		System.out.println(ans);
		driver.findElement(cB.chatInputElement).sendKeys(Keys.ENTER);
		logger.pass("Clicked on Enter");
		Thread.sleep(5000);
		Map<String, String> data02 = fun.getTestDataInMap(excelPath, "ChatBot").get(z);
		String expectedAns01 =data02.get("ExpectedAnswer");
		String[] expectedAns= expectedAns01.split(" ");
		String actualAns01 =data02.get("ActualAnswer");
		String[] actualAns= actualAns01.split(" ");
		ArrayList<String> unMatchValue = new ArrayList<String>();
		int ansLength=0;
		if(expectedAns.length<actualAns.length) {
			ansLength=expectedAns.length;
		}
		else {
			ansLength=actualAns.length;
		}
		
		for (int i = 0; i < ansLength; i++) {
			if(actualAns[i].equals(expectedAns[i])) {
				
			}
			else {
				unMatchValue.add(actualAns[i]);
			}
		}
		//StringBuilder unMatchString = new StringBuilder();
		String unMatchString="";
		for (String string : unMatchValue) {
			//unMatchString.append(string);
			//unMatchString.append("\t");
			unMatchString += string + " ";
		}
		System.out.println(unMatchString);
		if(!(unMatchString.isEmpty())) {
			XLUtils.setDataForCell(excelPath, "ChatBot", "UnmatchedWords", z+1, unMatchString);
		}
		else {
			XLUtils.setDataForCell(excelPath, "ChatBot", "Remark", z+1, "All Matching");
		}


		
		}
		catch(Exception e) {
			e.printStackTrace();}
		}
		
        
	}
}
