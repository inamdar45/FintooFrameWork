package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinancialPlanningPage {
 public WebDriver driver;
  public By startPlanButton = By.id("start_plan");
  public By expertAdvisoryButton =By.xpath("//span[text()='Expert Advisory']");
  public By startButton = By.id("start");
  //Fill in your details Locators
  public By formName = By.id("form-namefinancial");
  public By formEmailId = By.id("form-emailfinancial");
  public By formMobNum = By.id("form-mobilefinancial");
  public By formDropdown = By.xpath("//span[text()='Select Expert*']");
  public By submitButton = By.xpath("(//button[text()='Submit'])[1]");
  public By agreeCheckBox = By.id("agreenda");
  public By proceedButton = By.xpath("//input[@type='button']");
  public By popOkButtonNDA = By.xpath("//section[@id='showNDAcompletionToast']//div[1]//ul//button");
  public By agreeFPCheckBox = By.id("agreefp");
  public By popOkButtonFP = By.xpath("//section[@id='showDGcompletionToast']//div[1]//ul//button");
  
  
	public FinancialPlanningPage(WebDriver driver) {
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
}
