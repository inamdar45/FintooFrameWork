package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Billing {
  public WebDriver driver;
    By downloadInvoice=By.xpath("//a[text()='Download invoice']");
public	By goToDataGathering=By.xpath("//a[text()='Go-To Data-gathering']");
	By paymentSucesstext=By.xpath("//p[@class='f-bold']");
	By totalMRP=By.xpath("//p[text()='Total MRP']/following::p[1]");
	By gst=By.xpath("//p[text()='GST']/following::p[1]");
	By totalAmountPaid=By.xpath("//p[text()='Total paid amount']/following::p[1]");
	By dashBoardIcon=By.xpath("//a[@class='dashboard-icon']");
	By NotificationBell=By.xpath("//a[@class='notification']");
	By onlinePaymentLabel = By.xpath("//span[text()='Online payment ']");
	public By billingButton =By.xpath("//span[text()='Billing']");

	
	public Billing(WebDriver driver) {
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
	
	public String paymentsucess() {
		String billData= driver.findElement(paymentSucesstext).getText();
		return billData;
	}
	
	public String totalMRP() {
		String mrp= driver.findElement(totalMRP).getText().replace("₹","");
		return mrp;
	}
	
	public String totalGST() {
		String gst_amount= driver.findElement(gst).getText().replace("₹","");
		return gst_amount;
	}
	
	public String totalPaidAmount() {
		String amount_Paid= driver.findElement(totalAmountPaid).getText().replace("₹","");
		return amount_Paid;
	}
	
	public String onLinePayLabel() {
		String landingPage = driver.findElement(onlinePaymentLabel).getText();	
		return landingPage;
	}

}
