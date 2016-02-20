package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;


public class RegistrationSuccessController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(RegistrationSuccessController.class);
	
	@EJB
	private GuestDaoLocal guestDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		//Guest guest = (Guest)request.getSession().getAttribute("user");
		
		String name = null;
		String lastName = null;
		String email = null;
		String password = null;
		
		name= request.getParameter("name");
		lastName= request.getParameter("lastName");
		email= request.getParameter("email");
		password= request.getParameter("password");
		
		System.out.println("Ime je : " +name);
		System.out.println("lastName je : " +lastName);
		System.out.println("email je : " +email);
		System.out.println("password je : " +password);
		
		Guest guest = new Guest();
		
		/*if ((guest.getName() != null) && (!"".equals(guest.getName()))) {
			name = guest.getName();
		}

		if ((guest.getLastName() != null) && (!"".equals(guest.getLastName()))) {
			lastName = guest.getLastName();
		}
		
		if ((guest.getEmail() != null) && (!"".equals(guest.getEmail()))) {
			email = guest.getEmail();
		}

		if ((guest.getPassword() != null) && (!"".equals(guest.getPassword()))) {
			password = guest.getPassword();
		}
		*/
		
		//Guest newGuest = new Guest();
		
		if(name != null)
			guest.setName(name);
		
		if(lastName != null)
			guest.setLastName(lastName);
		
		if(email != null)
			guest.setEmail(email);
		
		if(password != null)
			guest.setPassword(password);
		
		guestDao.persist(guest);
		
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		return;
		
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
