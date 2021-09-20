package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import fintoo.Utilities.functions;

public class ChatBot{
    public WebDriver driver;
    public By firstNameElement =By.id("name");
    public By emailAddressElement =By.id("email");
    //public By emailAddressElement =By.xpath("//input[@name='mailid']");
    public By mobileElement =By.id("mobile");
    public By chatSubmit=By.id("chat_popup_btn");
    public By chatInputElement=By.id("chat-input");
    public By sipButton = By.xpath("//a[text()='SIP']");
    
	public ChatBot(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean genericClick(WebDriver driver, By elementToBeClicked)
	{ functions fun = new functions(driver);

	   try{
	//	fun.waitTillElementVisible(elementToBeClicked);
	     driver.findElement(elementToBeClicked).click();

	     return true;
	}
	catch(Exception e){

	     return false;
	}

	}
	
	public boolean genericSendKeys(WebDriver driver, By elementToBeClicked,String text)
	{ functions fun = new functions(driver);

	 //   try{
		fun.waitTillElementVisible(elementToBeClicked);
             driver.findElement(elementToBeClicked).clear();
	     driver.findElement(elementToBeClicked).sendKeys(text);

	     return true;
//	}
/*	catch(Exception e){

	     return false;
	}*/

	}
}
