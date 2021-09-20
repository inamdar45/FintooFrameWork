package fintoo.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class TC_DG_Neg_IncomeAndExpense_012 extends BaseClass{

	
	LoginPage lp = new LoginPage(driver);
	Reporting r = new Reporting();
	DashBoard dB= new DashBoard(driver);
	Billing bill =new Billing(driver);
	DataGathering dG = new DataGathering(driver);
	functions fun = new functions(driver);
	JavascriptExecutor  js =(JavascriptExecutor) driver;
	ArrayList<String> datagatheringList5;
	@Test
	public void dataGathering01() throws IOException, InterruptedException, AWTException{
		
		logger=  extent.createTest("DatagatheringNegIncome");
		extentTest.set(logger);
			
		String excelPath = readconfig.getExcelPath();
		int rownum = XLUtils.getRowCount(excelPath, "Login");
		int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
		String username = XLUtils.getCellData(excelPath, "Login", 1, 0);
		String pass = XLUtils.getCellData(excelPath, "Login", 1, 1);
		
		/*String firstName = XLUtils.getCellData(excelPath, "Datagathering", 1, 0);
		String lastName = XLUtils.getCellData(excelPath, "Datagathering", 1, 1);
		String resAddress = XLUtils.getCellData(excelPath, "Datagathering", 1, 2);
		String pincode = XLUtils.getCellData(excelPath, "Datagathering", 1, 3);*/
		ArrayList<String> datagatheringList= new ArrayList<>();
		ArrayList<String> datagatheringList1= new ArrayList<>();
		ArrayList<String> datagatheringList2= new ArrayList<>();
		ArrayList<String> datagatheringList3= new ArrayList<>();
		ArrayList<String> datagatheringList4= new ArrayList<>();
		datagatheringList5= new ArrayList<>();
		//HashMap<String, String> dGMap=new HashMap<String, String>();
		int rowsize = XLUtils.getRowCount(excelPath, "Datagathering");
		int colsize = XLUtils.getCellCount(excelPath, "Datagathering", rowsize);
		
		for(int i=5;i<=rowsize;i++) {
			for(int j=0;j<=colsize;j++) {
		//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
			
			String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
			datagatheringList5.add(abc);
		//	dGMap.put(key, value)
			}
		}
	
		for(int i=1;i<=rowsize;i++) {
			if(i==1) {
			for(int j=0;j<=colsize;j++) {
		//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
			
			String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
			datagatheringList.add(abc);
		//	dGMap.put(key, value)
			}}
			
			if(i==2) {
				for(int j=0;j<=colsize;j++) {
			//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
				
				String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
				datagatheringList1.add(abc);
			//	dGMap.put(key, value)
				}}
			
			if(i==3) {
				for(int j=0;j<=colsize;j++) {
			//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
				
				String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
				datagatheringList2.add(abc);
			//	dGMap.put(key, value)
				}}
			
			if(i==4) {
				for(int j=0;j<=colsize;j++) {
			//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
				
				String abc=XLUtils.getCellData(excelPath, "Datagathering", i, j);
				datagatheringList3.add(abc);
			//	dGMap.put(key, value)
				}}
		}
		
		/*if(driver.findElement(lp.taxNotification).isDisplayed()) {
			lp.genericClick(driver, lp.taxNotification);
		}*/
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
		Thread.sleep(8000);
		dG.genericClick(driver, dG.addDataButton);
		logger.pass("Clicked on Add Data Button");
		Thread.sleep(3000);
		dG.genericSendKeys(driver, dG.firstName, datagatheringList.get(0));
		logger.pass("First Name entered is"+datagatheringList.get(0));
		dG.genericSendKeys(driver, dG.lastName, datagatheringList.get(1));
		logger.pass("Last Name entered is"+datagatheringList.get(1));
		dG.genericSendKeys(driver, dG.residentialAddress, datagatheringList.get(2));
		logger.pass("Address entered is"+datagatheringList.get(2));
		dG.genericSendKeys(driver, dG.pinCode, datagatheringList.get(3));
		logger.pass("Pincode entered is"+datagatheringList.get(3));
		dG.genericSendKeys(driver, dG.emailAddress, datagatheringList.get(4));
		logger.pass("Email entered is"+datagatheringList.get(4));
		dG.genericSendKeys(driver, dG.panNo, datagatheringList.get(5));
		logger.pass("Pan No. entered is"+datagatheringList.get(5));
		dG.genericSendKeys(driver, dG.mobileNo, datagatheringList.get(6));
		logger.pass("Mobile Number entered is"+datagatheringList.get(6));
		dG.genericSendKeys(driver, dG.alternateMobileNo, datagatheringList.get(7));
		logger.pass("Alternate No. entered is"+datagatheringList.get(7));
		dG.genericClick(driver, dG.dOB);
		
		 String[] dob =datagatheringList.get(8).split("-");
		String date= dob[0];
		String month =dob[1];
	month=	month.substring(0, 3);
		String year =dob[2];
		calender(date, month, year);
		logger.pass("DOB entered is"+datagatheringList.get(8));
		String salary =datagatheringList.get(10);
		 By salaryRange=By.xpath("//label[contains(text(),'"+ salary +"')]");
		 Thread.sleep(3000);
		dG.genericClick(driver, salaryRange);
		logger.pass("Salary Range Selected is"+datagatheringList.get(10));
		Thread.sleep(3000);
		//fun.scrollToElement(driver.findElement(dG.saveAndContinue));
		//js.executeScript("window.scrollBy(0,300)");
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_TAB);
		 ro.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("(//span[@class='ui-selectmenu-text'])[1]")).click();
		//Thread.sleep(1000);
	    driver.findElement(By.xpath("(//div[contains(text(),'"+datagatheringList.get(11)+"')])[1]")).click();
	    logger.pass("Occupation entered is"+datagatheringList.get(11));
		//Select ss= new Select(driver.findElement(By.xpath("//select[@id='ui-id-1']")));
		System.out.println(datagatheringList.get(11));
		//ss.selectByVisibleText(datagatheringList.get(11));
		String genText =datagatheringList.get(12);
		 By gender = By.xpath("(//label[text()='"+genText+"'])[1]");
		dG.genericClick(driver, gender);
		logger.pass("Gender entered is"+datagatheringList.get(12));
		String retrimentAge=datagatheringList.get(13);
		dG.genericSendKeys(driver, dG.retirementAge, retrimentAge);
		logger.pass("Retirement Age entered is"+datagatheringList.get(13));
		String lifeExpectancy = datagatheringList.get(14);
		dG.genericSendKeys(driver, dG.lifeExpectancy, lifeExpectancy);
		logger.pass("Life Expectancy Age entered is"+datagatheringList.get(14));
		if(!datagatheringList.get(15).contentEquals("0")) {
			dG.genericSendKeys(driver, dG.remark, datagatheringList.get(15));
			logger.pass("Remark entered is"+datagatheringList.get(15));
		}
		dG.genericClick(driver, dG.saveAndContinue);
		logger.pass("Clicked on Save and Continue");
		
		dG.genericClick(driver, dG.incomeAndExpenseButton);
		logger.pass("Clicked on Income And Expense Link");
		
		dG.genericClick(driver, dG.salaryIncomeButton);
		logger.pass("Clicked on Salary Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.postOfficeMISButton);
		logger.pass("Clicked on Post Office MIS Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.businessButton);
		logger.pass("Clicked on Business Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.rentalButton);
		logger.pass("Clicked on Rental Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.giftsButton);
		logger.pass("Clicked on Gift Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.pensionButton);
		logger.pass("Clicked on Pension Button");
		incomeFlowNeg();
		dG.genericClick(driver, dG.otherButton);
		logger.pass("Clicked on Other Button");
		incomeFlowNeg();
		
		dG.genericClick(driver, dG.salaryIncomeButton1);
		logger.pass("Clicked on Salary Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.postOfficeMISButton);
		logger.pass("Clicked on Post Office MIS Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.businessButton);
		logger.pass("Clicked on Business Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.rentalButton);
		logger.pass("Clicked on Rental Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.giftsButton);
		logger.pass("Clicked on Gift Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.pensionButton);
		logger.pass("Clicked on Pension Button");
		incomeInvaliddata();
		dG.genericClick(driver, dG.otherButton);
		logger.pass("Clicked on Other Button");
		incomeInvaliddata();	
		
	}
	
	
	
	
	@Test
	public void datagatheringNegExpenses() throws InterruptedException, AWTException {
		logger=  extent.createTest("DatagatheringNegExpenses");
		extentTest.set(logger);
		dG.genericClick(driver, dG.expenseTab);
		logger.pass("Clicked on Expense Tab");
		Thread.sleep(3000);
		dG.genericClick(driver, dG.houseExpenseButton);
		logger.pass("Clicked on House Expense Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.houseRentButton);
		logger.pass("Clicked on House Rent Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.emiButton);
		logger.pass("Clicked on EMI Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.clubMembershipButton);
		logger.pass("Clicked on clubMembership Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.educationExpenseButton);
		logger.pass("Clicked on Education Expense Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.hotelButton);
		logger.pass("Clicked on Hotel and Leisure Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.domesticVacationButton);
		logger.pass("Clicked on Domestic Vacation Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.giftButton);
		logger.pass("Clicked on Gifts Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.medicalButton);
		logger.pass("Clicked on Medical Button");
		expenseFlowNeg();
		dG.genericClick(driver, dG.otherButtonExpense);
		logger.pass("Clicked on Other Button");
		expenseFlowNeg();
		
		
	}
	
	public void expenseFlowNeg() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		fun.scrollToElement(driver.findElement(dG.expenseSaveAddMoreButton));
		dG.genericClick(driver, dG.expenseSaveAddMoreButton);
		logger.pass("Clicked on Save Add More Button");
		
      if(driver.findElement(dG.expenseNameErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.expenseNameErrorMsg).getText(), "Please enter expense name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.expenseNameErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Expense Name");
		}
		
          if(driver.findElement(dG.expenseValueErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.expenseValueErrorMsg).getText(), "Please enter expense amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.expenseValueErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Value");
		}
          
          if(driver.findElement(dG.expenseMemberErrorMsg).isDisplayed()) {
  			
  			Assert.assertEquals(driver.findElement(dG.expenseMemberErrorMsg).getText(), "Please select a member");
  			logger.pass("Error Message Displayed is"+driver.findElement(dG.expenseMemberErrorMsg).getText());
  		}
  		else {
  			logger.fail("Error Message not Displayed for Expense For");
  		}
		
          if(driver.findElement(dG.endDateErrorMsg).isDisplayed()) {
    			
    			Assert.assertEquals(driver.findElement(dG.endDateErrorMsg).getText(), "Please select date");
    			logger.pass("Error Message Displayed is"+driver.findElement(dG.endDateErrorMsg).getText());
    		}
    		else {
    			logger.fail("Error Message not Displayed for Expense End Date");
    		}
          
          dG.genericClick(driver, dG.expenseSlider);
          logger.pass("Clicked on Expense Slider");
          dG.genericClick(driver, dG.expenseSaveAddMoreButton);
  		logger.pass("Clicked on Save Add More Button");
          
          if(driver.findElement(dG.expenseStartDateErrorMsg).isDisplayed()) {
  			
  			Assert.assertEquals(driver.findElement(dG.expenseStartDateErrorMsg).getText(), "Please select start date");
  			logger.pass("Error Message Displayed is"+driver.findElement(dG.expenseStartDateErrorMsg).getText());
  		}
  		else {
  			logger.fail("Error Message not Displayed for Expense Start Date");
  		}
          
          if(driver.findElement(dG.uptoEndDateRecurErrMsg).isDisplayed()) {
    			
    			Assert.assertEquals(driver.findElement(dG.uptoEndDateRecurErrMsg).getText(), "Please select upto");
    			logger.pass("Error Message Displayed is"+driver.findElement(dG.uptoEndDateRecurErrMsg).getText());
    		}
    		else {
    			logger.fail("Error Message not Displayed for Expense End Date");
    		}
         dG.genericSendKeys(driver, dG.expenseNameText, datagatheringList5.get(53));
         logger.pass("Entered Name is" +datagatheringList5.get(53));
         
         if(driver.findElement(dG.expenseNameErrorMsg).isDisplayed()) {
 			
 			Assert.assertEquals(driver.findElement(dG.expenseNameErrorMsg).getText(), "Special characters not allowed");
 			logger.pass("Error Message Displayed is"+driver.findElement(dG.expenseNameErrorMsg).getText());
 			driver.findElement(dG.expenseNameText).clear();
 		}
 		else {
 			logger.fail("Error Message not Displayed for Invalid Expense Name");
 			driver.findElement(dG.expenseNameText).clear();
 		}
         dG.genericClick(driver, dG.expenseSlider);
         logger.pass("Clicked on Expense Slider");
          
		
	}
	
	
	public void incomeFlowNeg() throws InterruptedException {
		Thread.sleep(4000);
		if(driver.findElement(dG.houseRentButton).isDisplayed()) {
  			dG.genericClick(driver, dG.incomeTab);
  			Thread.sleep(2000);
  		}
		Thread.sleep(2000);
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save Add More Button");
		if(driver.findElement(dG.incomeNameErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.incomeNameErrorMsg).getText(), "Please enter income name");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incomeNameErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Name");
		}
		
          if(driver.findElement(dG.incomeValueErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.incomeValueErrorMsg).getText(), "Please enter valid income value");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incomeValueErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Value");
		}
          
          if(driver.findElement(dG.memberErrorMsg).isDisplayed()) {
  			
  			Assert.assertEquals(driver.findElement(dG.memberErrorMsg).getText(), "Please select a member");
  			logger.pass("Error Message Displayed is"+driver.findElement(dG.memberErrorMsg).getText());
  		}
  		else {
  			logger.fail("Error Message not Displayed for Income From");
  		}
		
          if(driver.findElement(dG.endDateErrorMsg).isDisplayed()) {
    			
    			Assert.assertEquals(driver.findElement(dG.endDateErrorMsg).getText(), "Please select date");
    			logger.pass("Error Message Displayed is"+driver.findElement(dG.endDateErrorMsg).getText());
    		}
    		else {
    			logger.fail("Error Message not Displayed for Income End Date");
    		}
          Thread.sleep(2000);
          if(driver.findElement(dG.houseRentButton).isDisplayed()) {
  			dG.genericClick(driver, dG.incomeTab);
  			Thread.sleep(2000);
  		}
          
		dG.genericClick(driver, dG.recurringSlider);
		logger.pass("Clicked on Slider");
		dG.genericClick(driver, dG.saveAddMoreButton);
		logger.pass("Clicked on Save Add More Button");
		
		if(driver.findElement(dG.houseRentButton).isDisplayed()) {
			dG.genericClick(driver, dG.incomeTab);
			Thread.sleep(2000);
			dG.genericClick(driver, dG.saveAddMoreButton);
			//logger.pass("Clicked on Save Add More Button");
		}
		
		if(driver.findElement(dG.incomeStartDateRecurErrMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.incomeStartDateRecurErrMsg).getText(), "Please select start date");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incomeStartDateRecurErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Start Date");
		}
		
         if(driver.findElement(dG.uptoEndDateRecurErrMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.uptoEndDateRecurErrMsg).getText(), "Please select upto");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.uptoEndDateRecurErrMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Upto Date");
		}
         Thread.sleep(3000);
         dG.genericClick(driver, dG.recurringSlider);
 		logger.pass("Clicked on Slider");
		
	}
	
	public void incomeInvaliddata() {
		
		
		dG.genericSendKeys(driver, dG.incomeNameText,datagatheringList5.get(42));
		logger.pass("Enter Name is  "+ datagatheringList5.get(42));
         if(driver.findElement(dG.incomeNameErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.incomeNameErrorMsg).getText(), "Special characters not allowed");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incomeNameErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Name");
		}
         dG.genericSendKeys(driver, dG.incomeValueText,datagatheringList5.get(43));
 		logger.pass("Enter Value is  "+ datagatheringList5.get(43));
		
          if(driver.findElement(dG.incomeValueErrorMsg).isDisplayed()) {
			
			Assert.assertEquals(driver.findElement(dG.incomeValueErrorMsg).getText(), "Please specify a valid amount");
			logger.pass("Error Message Displayed is"+driver.findElement(dG.incomeValueErrorMsg).getText());
		}
		else {
			logger.fail("Error Message not Displayed for Income Value");
		}
		
		
		
	}
	
	public void calender(String date,String month,String year) {
		Select s = new Select(driver.findElement(dG.calenderYear));
		s.selectByVisibleText(year);
		Select ss = new Select(driver.findElement(dG.calenderMonth));
		ss.selectByVisibleText(month);
		 //By date01 = By.xpath("(//a[text()='"+date+"'])[2]");
		 By date01 =By.xpath("//*[@id='ui-datepicker-div']//a[text()='"+date+"']");
		 driver.findElement(date01).click();
		
		
		
	}
	
}
