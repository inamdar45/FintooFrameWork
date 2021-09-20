package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	public WebDriver driver;
	public By mobileNumberErrorMsg =By.id("mobile-error");
	public By mobileNumberTxtField =By.id("mobile");
	public By emailErrorMsg =By.id("email-error");
	public By emailTxtField =By.id("email");
	public By passwordErrorMsg =By.id("password-error");
	public By passwordTxtField =By.id("password");
	public By confirmPasswordErrorMsg =By.id("repassword-error");
	public By confirmPasswordTxtField =By.id("repassword");
	public By checkBox =By.id("chkterms");
	public By tcErrorMsg =By.id("faa_span");
	public By registerButton =By.id("reg");
	public By passwordErrorMsg16 =By.xpath("//h6[text()='Please enter no more than 16 characters.']");
	public By otpSentTo = By.xpath("//div[@class='bottom-container']");
	
	
	public RegistrationPage(WebDriver driver) {
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
