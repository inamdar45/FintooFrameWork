package fintoo.Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import fintoo.PageObject.Billing;
import fintoo.PageObject.DashBoard;
import fintoo.PageObject.DataGathering;
import fintoo.PageObject.LoginPage;
import fintoo.Utilities.Reporting;
import fintoo.Utilities.XLUtils;
import fintoo.Utilities.functions;

public class family_try extends BaseClass {
static functions fun = new functions(driver);
DataGathering dG = new DataGathering(driver);
static String excelPath = readconfig.getExcelPath();
LoginPage lp = new LoginPage(driver);
Reporting r = new Reporting();
DashBoard dB= new DashBoard(driver);
Billing bill =new Billing(driver);
//DataGathering dG = new DataGathering(driver);
//functions fun = new functions(driver);

//String excelPath = readconfig.getExcelPath();
TC_DataGathering_008 tc = new TC_DataGathering_008();
public static int increment;
public static int incrementDG;
public static int rownum;
//int breakCount=0;

public static void main(String[] args) throws IOException {
	 
	incrementDG=0;
	 rownum = XLUtils.getRowCount(excelPath, "Login");
	int colnum = XLUtils.getCellCount(excelPath, "Login", rownum);
	int rowsizeDG = XLUtils.getRowCount(excelPath, "Datagathering");
	int colsizeDG = XLUtils.getCellCount(excelPath, "Datagathering", rowsizeDG);
	
	for( increment=1;increment<=rownum;increment++) {
		
		for(int k=incrementDG+2;k<=rowsizeDG;k++) {
			
		/*	for(int y=incrementDG+2;y<=rowsizeDG+1;y++) {
				int breakCount=0;
				for(int z=0;z<=colsizeDG;z++) {
					String cellValue=XLUtils.getCellData(excelPath, "Datagathering", y, z);
					if(!(cellValue==null)) {
						incrementDG++;
						break;
					}
					else {
						breakCount++;
					}
				}
				if(breakCount-1==colsizeDG) {
					incrementDG++;
					break;
				}
			}*/
			Map<String, String> data01 = fun.getTestDataInMap(excelPath, "Datagathering").get(k);
			String firstNam=data01.get("FirstName");
			if(firstNam==null) {
				incrementDG++;
			}
			else {
				break;
			}
		}
		
		
	XmlSuite suite = new XmlSuite();
	suite.setName("TmpSuite");
	 
	XmlTest test = new XmlTest(suite);
	test.setName("TmpTest");
	List<XmlClass> classes = new ArrayList<XmlClass>();
	
	classes.add(new XmlClass("fintoo.Testcases.TC_DataGathering_008"));
	test.setXmlClasses(classes) ;
	
	List<XmlSuite> suites = new ArrayList<XmlSuite>();
	suites.add(suite);
	TestNG tng = new TestNG();
	tng.setXmlSuites(suites);
	tng.run();
	//System.out.println("Executed");
	}


	
}

	public void familyMember() throws InterruptedException, IOException, AWTException {
	tc.dataGathering01();
	tc.incomeExpensePositive();
	
}
	
	public void calender01(String date) {
		String[] goalEndDate = date.split("-");
		String date01= goalEndDate[0];
		String month =goalEndDate[1];
		month=	month.substring(0, 3);
		String year =goalEndDate[2];

		Select s = new Select(driver.findElement(dG.calenderYear));
		s.selectByVisibleText(year);
		Select ss = new Select(driver.findElement(dG.calenderMonth));
		ss.selectByVisibleText(month);
		//By date01 = By.xpath("(//a[text()='"+date+"'])[2]");
		By date02 =By.xpath("//*[@id='ui-datepicker-div']//a[text()='"+date01+"']");
		driver.findElement(date02).click();
		logger.pass("Selected Date is"+" "+date);
	}
}
