package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;


@Stateless
@Local(TestLocal.class)
@Remote(Test.class)
public class TestBean implements Test {
	
	@Resource(name="JmsConnectionFactory")
	private ConnectionFactory qcf;

	@Resource(name="PaymentQueue")
	private Queue paymentQueue;

	public void test() {
		
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		
		try {
			// Creates a connection
			connection = qcf.createConnection();

            // Creates a session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Creates a message producer from the Session to the Topic or Queue
            producer = session.createProducer(paymentQueue);

            // Creates an object message
            ObjectMessage object = session.createObjectMessage();
		    
            // Tells the producer to send the object message
            producer.send(object);
            
            // Closes the producer
            producer.close();
            
            // Closes the session
            session.close();
            
            // Closes the connection
            connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
