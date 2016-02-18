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
			
		Admin admin = (Admin)request.getSession().getAttribute("user");
		
		String name = null;
		String lastName = null;
		String email = null;
		String password = null;
		
		if ((admin.getName() != null) && (!"".equals(admin.getName()))) {
			name = admin.getName();
		}

		if ((admin.getLastName() != null) && (!"".equals(admin.getLastName()))) {
			lastName = admin.getLastName();
		}
		
		if ((admin.getEmail() != null) && (!"".equals(admin.getEmail()))) {
			email = admin.getEmail();
		}

		if ((admin.getPassword() != null) && (!"".equals(admin.getPassword()))) {
			password = admin.getPassword();
		}
		
		
		Guest guest = new Guest();
		
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
