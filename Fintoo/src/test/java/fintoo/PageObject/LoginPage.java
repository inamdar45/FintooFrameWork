package fintoo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public Actions ac;
   public	By loginLink = By.xpath("//a[text()='Login']");
	public By emailMobTextBox = By.id("emailmobile");
	public By passwordTextBox = By.id("password");
	public By rememberCheckBox = By.id("rememberMe");
   public	By loginButton = By.name("login");
	public By logOutButton = By.xpath("//a[text()='Logout']");
	public By profileImg = By.xpath("//img[@src='../static/userflow/img/profile-picture.svg']");
	public By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	public By loginOTP   = By.xpath("//a[text()='Login with OTP']");
	public By registerNow   = By.xpath("//a[text()='Register Now']");
	public By sendOTPButton = By.xpath("//button[text()='Send OTP']");
public	By backArrow  =By.xpath("//a[@class='back-arrow']");
	public By labelOTPSend =By.xpath("//p[contains(text(),'The OTP')]");
  public	By errorMsg = By.id("error-msg");
  public  By loginWithPassword = By.xpath("//a[text()='Login With Password']");
  public By passwordErrorMsg = By.id("password-error");
  public By emailMobErrorMsg = By.id("emailmobile-error");
  public By taxNotification = By.id("zh_close");
  public By captchaText =By.id("captcha");
  public By fintooCard = By.xpath("//button[@ng-click='addItemToCartPlan(plan)']");
  public By fillDetails = By.xpath("//h3[text()='Your Profile']");
  public By fintooLogo = By.xpath("//div[@class='dashboard-navigation']//following::a[1]");
  public By fintooLogoDashboard = By.xpath("(//a[@class='logo'])[2]");
	public LoginPage(WebDriver driver) {
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

	public void loginLink() {
		driver.findElement(loginLink).click();
	}

	public void setEmailMob(String EmailMob) {
		//driver.findElement(emailMobTextBox).clear();
		driver.findElement(emailMobTextBox).sendKeys(EmailMob);

	}

	public void setPassword(String Password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(Password);

	}

	public void loginButton() {
		driver.findElement(loginButton).click();
	}

	public void logOutButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement aa = driver.findElement(profileImg);
		aa.click();
		Thread.sleep(3000);
		driver.findElement(logOutButton).click();

	}
	public WebElement webElement(By element) {
		WebElement webEle = driver.findElement(element);
		return webEle;}

}
