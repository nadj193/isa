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
		

		testLocal.test();
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
		
		/*Guest guest = new Guest();
		guest.setName(name);
		guest.setLastName(lastName);
		guest.setEmail(email);
		guest.setPassword(password);
		
		request.getSession().setAttribute("user", guest);
		*/
		
		javax.mail.Message msg = new MimeMessage(session);
		try {
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
		
		/*
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}


			String voziloId = request.getParameter("voziloId");

			if ((voziloId != null) && (!voziloId.equals(""))) {
				request.setAttribute("vozilo", voziloDao.findById(Integer.parseInt(voziloId)));
				getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
			}
			
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
		*/
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
