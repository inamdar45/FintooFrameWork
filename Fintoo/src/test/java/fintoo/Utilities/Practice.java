package fintoo.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Practice {
	//String hostName = "smtp.gmail.com";
	String hostName = "smtp.yopmail.com";
	//String username = "ai23008@gmail.com";
	String username ="random10@yopmail.com";
	String password = "Ai23008@gmail";
	int messageCount;
	int unreadMsgCount;
	String emailSubject,searchText,otp;
	public ArrayList<String> tabs;
	javax.mail.Message emailMessage;

	public Practice() {
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    

	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	       
	        store.connect(hostName, username, password);
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	        emailMessage = emailInbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();
	  	 	int  emailUnReaded=  emailInbox.getUnreadMessageCount();
 
 
	     //   Pattern linkPattern = Pattern.compile("href="(.*)\"Fintoo"); // here you need to define regex as per you need
//	        Pattern linkPattern = Pattern.compile("[a-z0-9]*\\d[a-z0-9]");
//	        Matcher pageMatcher =
//	                linkPattern.matcher(emailMessage.getContent().toString());
//
//	        while (pageMatcher.find()) {
//	            System.out.println("Found OTP " + pageMatcher.group(1));
//	        }
//	        emailMessage.setFlag(Flags.Flag.SEEN, true);
//	        emailInbox.close(true);
//	        store.close();
 for(int i=messageCount; i>(messageCount-emailUnReaded); i--)

 {

     emailMessage = emailInbox.getMessage(i);

     emailSubject = emailMessage.getSubject();

     if(emailSubject.contains("Fintoo"))

     {

         System.out.println("OTP mail found");

         String line;

         StringBuffer buffer = new StringBuffer();

         BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));

         while ((line = reader.readLine()) != null) {

             buffer.append(line);
            // System.out.println(buffer.toString());

         }

         String messageContent="Your OTP verification code is";

         String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
         System.out.println(result);

       String  searchText = result.substring(messageContent.length(), messageContent.length()+6);

       //  System.out.println("OTP found is : "+ searchText);

         emailMessage.setFlag(Flags.Flag.SEEN, true);

         break;

     }

     emailMessage.setFlag(Flags.Flag.SEEN, true);

 }

 emailInbox.close(true);

 store.close();




	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
	    
	    
	}
	

	
     public static void main(String[] args) {
		Practice p = new Practice();
	}
     
     public String readOTPGmail() {
    	 Properties sysProps = System.getProperties();
 	    sysProps.setProperty("mail.store.protocol", "imaps");

 	    try {
 	        Session session = Session.getInstance(sysProps, null);
 	        Store store = session.getStore();
 	        store.connect(hostName, username, password);
 	        Folder emailInbox = store.getFolder("INBOX");
 	        emailInbox.open(Folder.READ_WRITE);
 	        messageCount = emailInbox.getMessageCount();
 	        System.out.println("Total Message Count: " + messageCount);
 	        unreadMsgCount = emailInbox.getNewMessageCount();
 	        System.out.println("Unread Emails count:" + unreadMsgCount);
 	        emailMessage = emailInbox.getMessage(messageCount);
 	        emailSubject = emailMessage.getSubject();
 	  	 	int  emailUnReaded=  emailInbox.getUnreadMessageCount();
  
  
 	     //   Pattern linkPattern = Pattern.compile("href="(.*)\"Fintoo"); // here you need to define regex as per you need
 	       /* Pattern linkPattern = Pattern.compile("[a-z0-9]*\\d[a-z0-9]");
 	        Matcher pageMatcher =
 	                linkPattern.matcher(emailMessage.getContent().toString());

 	        while (pageMatcher.find()) {
 	            System.out.println("Found OTP " + pageMatcher.group(1));
 	        }
 	        emailMessage.setFlag(Flags.Flag.SEEN, true);
 	        emailInbox.close(true);
 	        store.close();*/
  for(int i=messageCount; i>(messageCount-emailUnReaded); i--)

  {

      emailMessage = emailInbox.getMessage(i);

      emailSubject = emailMessage.getSubject();

      if(emailSubject.contains("Fintoo"))

      {

          System.out.println("OTP mail found");

          String line;

          StringBuffer buffer = new StringBuffer();

          BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));

          while ((line = reader.readLine()) != null) {

              buffer.append(line);
             // System.out.println(buffer.toString());

          }

          String messageContent="Your OTP verification code is";

          String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
          System.out.println(result);

         searchText = result.substring(messageContent.length(), messageContent.length()+6);
       //  String[] otpArray=  searchText.split(" ");
         // otp=otpArray[5];

        //  System.out.println("OTP found is : "+ searchText);

          emailMessage.setFlag(Flags.Flag.SEEN, true);

          break;

      }

      emailMessage.setFlag(Flags.Flag.SEEN, true);

  }

  emailInbox.close(true);

  store.close();
  




 	    } catch (Exception mex) {
 	        mex.printStackTrace();
 	    }
 	   return searchText.trim();
    	 
     }
     
     public void createYOPmail(String id,WebDriver d) {
    	 
    	 d.get("https://yopmail.com/");
    	 d.findElement(By.id("login")).sendKeys(id);
    	 d.findElement(By.xpath("//button[@class='md']")).click();
    	// d.close();
    	 
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


}
