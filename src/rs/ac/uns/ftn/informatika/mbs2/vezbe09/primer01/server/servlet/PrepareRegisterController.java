package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.TestLocal;


public class PrepareRegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(PrepareRegisterController.class);
	
	@Resource(name="Mail")
	Session session;
	
	@EJB 
	private TestLocal testLocal;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatpassword");
		
		
		if(!password.equals(repeatPassword))
		{
			getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
		}
		else
		{
	
		
		javax.mail.Message msg = new MimeMessage(session);
		try {
			testLocal.test();
			msg.setFrom(new InternetAddress("iprojekat@gmail.com"));
			msg.setRecipients(RecipientType.TO, InternetAddress.parse("nadjdavor@gmail.com"));
			msg.setSubject("Registracija");
			msg.setText("Registrovao se korisnik novi!!Jeee");
			msg.setContent("<p>Ovo je automatska poruka namenjena za registraciju na sajt Restorana. "
	         		+ "Kliknite na link da biste zavrsili registraciju.</p>"
	         		+ "<a href='http://localhost:8080/Vezbe09/RegistrationSuccessController?name="+name+"&lastName="+lastName+"&email="+email+"&password="+password+"'>Registrujte se</a>",
                     "text/html" );
			msg.setSentDate(new Date());
			
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("MESSAGE BEAN: Mail was sent successfully.");
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
