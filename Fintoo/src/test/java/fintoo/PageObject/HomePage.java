package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	By aboutUsLink = By.xpath("(//a[text()='About Us'])[1]");
	By services = By.xpath("(//a[text()='Services'])[1]");
  public By advisoryLink = By.xpath("(//a[text()='Advisory'])[1]");
	public By services_FP = By.xpath("(//a[text()='Financial Planning'])[1]");
	By services_RP = By.xpath("(//a[text()='Retirement Planning'])[1]");
	By services_TP = By.xpath("(//a[text()='Tax Planning'])[1]");
	By services_IP = By.xpath("(//a[text()='Investment Planning'])[1]");
	By ITR_Filing = By.xpath("(//a[text()='ITR Filing'])[1]");
	By fileYourITR = By.xpath("(//a[text()='File Your ITR'])[1]");
	By knowYourStatus = By.xpath("(//a[text()='Know Your Status'])[1]");
	By contactUs = By.xpath("(//a[text()='Contact Us'])[1]");
	By loginLink = By.xpath("(//a[text()='Login'])[1]");
	By imageFP = By.className("option option-1");
	By imageRP = By.className("option option-2");
	By imageTP = By.className("option option-3");
	By imageIP = By.className("option option-4");
	By knowMore = By.xpath("//li[test()='Know More']");
	By privacyPolicy=By.xpath("//a[text()='Privacy Policy']");
	By termsConditions=By.xpath("//a[text()='Terms & Conditions']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public boolean genericClick(WebDriver driver, By elementToBeClicked)
	{

	    try{

	     driver.findElement(elementToBeClicked).click();

	     return true;
	}
	catch(Exception e){

	     return false;
	}

	}
	
	public boolean genericSendKeys(WebDriver driver, By elementToBeClicked,String text)
	{

	    try{
             driver.findElement(elementToBeClicked).clear();
	     driver.findElement(elementToBeClicked).sendKeys(text);

	     return true;
	}
	catch(Exception e){

	     return false;
	}

	}


	public void clickServices() {
		driver.findElement(services).click();
	}

	public void clickServices_FP() {
		driver.findElement(services_FP).click();
		
	}

	public void clickServices_RP() {
		driver.findElement(services_RP).click();
		
	}

	public void clickServices_TP() {
		driver.findElement(services_TP).click();
		
	}

	public void clickServices_IP() {
		driver.findElement(services_IP).click();
		
	}

	public void clickITRFiling() {
		driver.findElement(ITR_Filing).click();
		
	}

	public void clickfileYourITR() {
		driver.findElement(fileYourITR).click();
		
	}

	public void clickknowYourStatus() {
		driver.findElement(knowYourStatus).click();
	}

	public void clickcontactUs() {
		driver.findElement(contactUs).click();
	}

	public void clickloginLink() {
		driver.findElement(loginLink).click();
	}

	public void clickKnowMore() {
		driver.findElement(knowMore).click();
	}

	public void clickImageFP() {
		driver.findElement(imageFP).click();

	}

	public void clickImageRP() {
		driver.findElement(imageRP).click();
	}

	public void clickImageTP() {
		driver.findElement(imageTP).click();
	}

	public void clickImageIP() {
		driver.findElement(imageIP).click();
	}
	
	public void clickAboutUs() {
		driver.findElement(aboutUsLink).click();
	}

}
