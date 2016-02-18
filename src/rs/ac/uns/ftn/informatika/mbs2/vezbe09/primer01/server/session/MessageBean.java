package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



@MessageDriven(
		activationConfig = {
			@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
			@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
			@ActivationConfigProperty(propertyName = "destination", propertyValue = "PaymentQueue") 
		}
	)

public class MessageBean implements MessageListener{
	
	@Resource(name="Mail")
	Session session;
	
	public MessageBean(){ 
		
	}

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
		try {
	        if (message instanceof ObjectMessage) {
	            ObjectMessage obj = (ObjectMessage) message;           
	            sendMessage();
	        } else {
	            System.out.println("MESSAGE BEAN: Message of wrong type: " + message.getClass().getName());
	        }
	    } catch (Throwable te) {
	        te.printStackTrace();
	    }
		
	}
	
	public void sendMessage() throws AddressException, MessagingException {
		
		// Constructs the message 
				javax.mail.Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("iprojekat@gmail.com"));
				msg.setRecipients(RecipientType.TO, InternetAddress.parse("nadjdavor@gmail.com"));
				msg.setSubject("Potvrda el.placanja");
				msg.setText("Registrovao se korisnik novi!!Jeee");
				msg.setSentDate(new Date());
				
				// Sends the message
				Transport.send(msg);

				System.out.println("MESSAGE BEAN: Mail was sent successfully.");
		
	}

}
