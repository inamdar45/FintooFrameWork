package fintoo.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.time.Duration;

import javax.imageio.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;

import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import fintoo.Testcases.BaseClass;



public class functions extends BaseClass{

	//public static WebDriver driver;
	public ArrayList<String> tabs;
	String otp;
	
	
	public functions(WebDriver driver) {
		functions.driver=driver;
	}
	
	public  static boolean waitTillElementisDisplayed(By element,long timeOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	
		return true;
	}
	
	public String isFileDownloaded() throws Exception {
	   /* final int SLEEP_TIME_MILLIS = 1000;
	  String  filePath= "//C:/Users/Hp/Downloads/minty";
	    File file = new File(filePath);
	    final int timeout = 60* SLEEP_TIME_MILLIS;
	    int timeElapsed = 0;
	    while (timeElapsed<timeout){
	        if (file.exists()) {
	            System.out.println(file.getName()+"  is present");
	            return true;
	        } else {
	            timeElapsed +=SLEEP_TIME_MILLIS;
	            Thread.sleep(SLEEP_TIME_MILLIS);
	        }
	    }
	    return false;*/
		
		String folderName = "//C:/Users/Hp/Downloads/"; // Give your folderName Downloads
		File[] listFiles = new File(folderName).listFiles();
		String fileName="null";
		for (int i = 0; i < listFiles.length; i++) {

		    if (listFiles[i].isFile()) {
		         fileName = listFiles[i].getName();
		        if (fileName.startsWith("Invoice")
		                && fileName.endsWith(".pdf")) {
		            System.out.println("found file" + " " + fileName);
		            
		        }
		    }
		}
		return fileName;
		
	}
	
     public void scrollToElement(WebElement element) throws InterruptedException, AWTException {
    	 Robot r = new Robot();
    	 
    	 while(!element.isDisplayed()) {
    		 r.keyPress(KeyEvent.VK_DOWN);
    		 r.keyRelease(KeyEvent.VK_DOWN);
    		 Thread.sleep(1000);
    	 }
     }
	
     public void scrollToElementUp(WebElement element) throws InterruptedException, AWTException {
    	 Robot r = new Robot();
    	 
    	 while(!element.isDisplayed()) {
    		 r.keyPress(KeyEvent.VK_UP);
    		 r.keyRelease(KeyEvent.VK_UP);
    		 Thread.sleep(1000);
    	 }
     }
     
     public void waitTillElementClickable(By element) {
    	 
    	 new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
     }
     
     public void waitTillElementVisible(By element) {
    	
    	 new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(element)));
     
    	
     }
     
     public ArrayList<String>  getDataList(String excelPath,String sheetName) throws IOException {
    	 ArrayList<String> datagatheringList5=new ArrayList<>();
    	 int rowsize = XLUtils.getRowCount(excelPath, sheetName);
 		int colsize = XLUtils.getCellCount(excelPath, sheetName, rowsize);
 		
 		for(int i=5;i<=rowsize;i++) {
 			for(int j=0;j<=colsize;j++) {
 		//	String	key=XLUtils.getCellData(excelPath, "Datagathering", 0, j);
 			
 			String abc=XLUtils.getCellData(excelPath, sheetName, i, j);
 			datagatheringList5.add(abc);
 		//	dGMap.put(key, value)
 			}
 		}
 		return datagatheringList5 ;
     }
     
     
     public  List<Map<String,String>> getTestDataInMap(String sheetPath,String sheetName) throws IOException{
    	 List<Map<String,String>> testDataAllRows=null;
    	 Map<String,String> testData=null;
    	 
    	 try {
    		 FileInputStream fileInputStream = new FileInputStream(sheetPath);
    		 Workbook wb = new XSSFWorkbook(fileInputStream);
    		 Sheet sheet = wb.getSheet(sheetName);
    		 int lastRowNo=sheet.getLastRowNum();
    		 int lastColumnNo= sheet.getRow(0).getLastCellNum();
    		 
    		 List list = new ArrayList();
    		 for (int i = 0; i <lastColumnNo; i++) {
    			 Row row=sheet.getRow(0);
    			  Cell cell=row.getCell(i);
    			String rowHeader= cell.toString().trim();
				list.add(rowHeader);
			}
    		 testDataAllRows = new ArrayList<Map<String,String>>();
    		 for (int j = 1; j <=lastRowNo; j++) {
    			 
    			 Row row = sheet.getRow(j);
    			 testData= new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);//treemap preserve's insertion order
    			 for (int k = 0; k < lastColumnNo; k++) {
					Cell cell=row.getCell(k);
			try{
				String cellValue=cell.toString().trim();
				testData.put((String) list.get(k), cellValue);}
			catch(Exception e) {
				
			}
					
				}
				testDataAllRows.add(testData);
			}
    		 
    	 }
    	 catch(FileNotFoundException e) {
    		 e.printStackTrace();
    	 }
    	 return testDataAllRows;
     }
     
     public  boolean isElementDisplayed(By element) {
    	 try {
    		 waitTillElementisDisplayed(element,10);
    	driver.findElement(element);
    	    	    	 }
    	 catch(Exception e) {
    		
    		 return false;
    	 }
    	 return true;
     }
     
     public void scrollByElement(By element) throws InterruptedException, AWTException {
    	 Robot r = new Robot();
    	 
    	 while(!isElementDisplayed(element)) {
    		 r.keyPress(KeyEvent.VK_DOWN);
    		 r.keyRelease(KeyEvent.VK_DOWN);
    		 Thread.sleep(1000);
    	 }
     }
     @SuppressWarnings("restriction")
	public void imageManipulation(String inputImgPath,String outPutImgPath) throws FileNotFoundException, IOException {
    	 File infile = new File(inputImgPath);
         File outfile = new File(outPutImgPath);

         ImageReader reader = ImageIO.getImageReadersByFormatName("png").next();
         reader.setInput(new FileImageInputStream(infile), true, false);
         IIOMetadata data = reader.getImageMetadata(0);
         BufferedImage image = reader.read(0);

         int w = 600, h = -1;
          Image rescaled = image.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING);
          BufferedImage output = toBufferedImage(rescaled, BufferedImage.TYPE_INT_RGB);

         Element tree = (Element) data.getAsTree("javax_imageio_jpeg_image_1.0");
         Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);
         for (int i = 0; i < jfif.getAttributes().getLength(); i++) {
             Node attribute = jfif.getAttributes().item(i);
             System.out.println(attribute.getNodeName() + "="
                     + attribute.getNodeValue());
         }
         FileOutputStream fos = new FileOutputStream(outfile);
         JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(fos);
         JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(output);
         jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
         jpegEncodeParam.setXDensity(300);
         jpegEncodeParam.setYDensity(300);
         jpegEncoder.encode(output, jpegEncodeParam);
         fos.close();
    	 
    	 
     }
     
     public static BufferedImage toBufferedImage(Image image, int type) {
         int w = image.getWidth(null);
         int h = image.getHeight(null);
         BufferedImage result = new BufferedImage(w, h, type);
         Graphics2D g = result.createGraphics();
         g.drawImage(image, 0, 0, null);
         g.dispose();
         return result;
     }
     
     public void getAutoRegisterYopmailId(WebDriver driver01,String userName) throws InterruptedException {
    	 
    	 String mailID = userName+RandomStringUtils.randomNumeric(4)+"@yopmail.com";
    	 driver01.findElement(By.xpath("//a[@href='/login/']")).click();
 		driver01.findElement(By.xpath("//a[@href='/register/']")).click();
 		driver01.findElement(By.id("firstname")).sendKeys(RandomStringUtils.randomAlphabetic(6));
 		driver01.findElement(By.id("email")).sendKeys(mailID);
 		driver01.findElement(By.id("mobile")).sendKeys("9"+RandomStringUtils.randomNumeric(9));
 		driver01.findElement(By.id("password")).sendKeys("Abc1234@gmail");
 		driver01.findElement(By.id("repassword")).sendKeys("Abc1234@gmail");
 		String value1 = driver01.findElement(By.id("captcha_code")).getAttribute("value");
 		Base64.Decoder decoder = Base64.getDecoder();
 		String captchaTxt = new String(decoder.decode(value1));
 		Thread.sleep(2000);
 		driver01.findElement(By.id("captcha")).sendKeys(captchaTxt);
 		driver01.findElement(By.id("chkterms")).click();
 		driver01.findElement(By.id("reg")).click();
 		Thread.sleep(5000);
 		driver01.findElement(By.id("otp_code")).sendKeys(readOTPFromYopMail(mailID, driver01));
 		driver01.findElement(By.xpath("//button[@value='Submit']")).click();
 		Thread.sleep(9000);
    	 
     }
     
     public String readOTPFromYopMail(String id,WebDriver d) {
     	// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
     	 //d.findElement(By.linkText("https://yopmail.com/")).sendKeys(selectLinkOpeninNewTab);
     	 ((JavascriptExecutor) d).executeScript("window.open()");
     	  tabs = new ArrayList<String>(d.getWindowHandles());
     	 d.switchTo().window(tabs.get(1)); 
     	 d.get("https://yopmail.com/");
     	 d.findElement(By.id("login")).clear();
     	 d.findElement(By.id("login")).sendKeys(id);
     	 d.findElement(By.xpath("//button[@class='md']")).click();
     	 String otpText;
     	 d.switchTo().frame(d.findElement(By.id("ifmail")));
     	 try {
     	 otpText= d.findElement(By.xpath("//p[contains(text(),' Your OTP')]")).getText();}
     	 catch(Exception e) {
     		  otpText= d.findElement(By.xpath("//*[@id=\"mail\"]/div/table/tbody/tr/td/div/table[1]/tbody/tr[3]/td/p[3]")).getText();
     	 }
     	   
     	String[] otpArray= otpText.split(" ");
     	
     	otp = otpArray[5];
     	d.close();
     	d.switchTo().window(tabs.get(0));
     	return otp;
     	 
      }
     
    public boolean fluentWait(WebDriver driver,By element,int timeoutMilliSec,int pollingTimeMilliSec) {
    	//Declare and initialise a fluent wait
    	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
    	//Specify the timout of the wait
    	wait.withTimeout(Duration.ofMillis(timeoutMilliSec));
    	//Sepcify polling time
    	wait.pollingEvery(Duration.ofMillis(pollingTimeMilliSec));
    	//Specify what exceptions to ignore
    	wait.ignoring(NoSuchElementException.class);

    	//This is how we specify the condition to wait on.
    	//This is what we will explore more in this chapter
    	WebElement abc = wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
  try {  if(abc.isDisplayed()) {
    	
    }
   }
  catch(Exception e) {
	  return false;
  }
  return true;
    
    }
}
