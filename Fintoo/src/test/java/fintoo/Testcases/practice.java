package fintoo.Testcases;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.hc.core5.http.Message;

public class practice {
	String hostName = "smtp.gmail.com";
	String username = "ai23008@gmail.com";
	String password = "Ai23008@gmail";
	int messageCount;
	int unreadMsgCount;
	String emailSubject;
	javax.mail.Message emailMessage;

	public practice() {
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
 String subject =emailSubject.toString();
 if(subject.contains("Fintoo")) {
	 System.out.println(subject);
 }
	       // Pattern linkPattern = Pattern.compile("href=\"(.*)\"Fintoo"); // here you need to define regex as per you need
	        Pattern linkPattern = Pattern.compile("[a-z0-9]*\\d[a-z0-9]");
	        Matcher pageMatcher =
	                linkPattern.matcher(emailMessage.getContent().toString());

	        while (pageMatcher.find()) {
	            System.out.println("Found OTP " + pageMatcher.group(1));
	        }
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
	}
	

	
}
