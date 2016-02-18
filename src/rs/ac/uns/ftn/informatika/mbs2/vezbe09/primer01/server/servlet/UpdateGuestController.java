package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;




public class UpdateGuestController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(UpdateGuestController.class);

	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB
	private ManagerDaoLocal managerDao;
	

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			//String managerId = null;
			String name = null;
			String lastName = null;
			String password = null;
			String email = null;
			String adress = null;
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
		    	return;
		    }
			
			//managerId = request.getParameter("id");
			
			if ((request.getParameter("name")!=null)&&(!"".equals(request.getParameter("name")))){
				name = request.getParameter("name");
			}
			
			if ((request.getParameter("lastName")!=null)&&(!"".equals(request.getParameter("lastName")))){
				lastName = request.getParameter("lastName");
			}
			
			if ((request.getParameter("password")!=null)&&(!"".equals(request.getParameter("password")))){
				password = request.getParameter("password");
			}
			
			if ((request.getParameter("email")!=null)&&(!"".equals(request.getParameter("email")))){
				email = request.getParameter("email");
			}
			
			if ((request.getParameter("adress")!=null)&&(!"".equals(request.getParameter("adress")))){
				adress = request.getParameter("adress");
			}
						
			
			Guest guest = (Guest)request.getSession().getAttribute("guest");	
			
			if (guest == null) {
				response.sendRedirect(response.encodeURL("./guestHome.jsp"));
				return;
			}
				
				if (name != null)
					guest.setName(name);
				
				if (lastName != null)
					guest.setLastName(lastName);
				
				if(password !=null)
					guest.setPassword(password);
				
				if(email !=null)
					guest.setEmail(email);
				
				if(adress != null)
					guest.setAdress(adress);
				
				
				guestDao.merge(guest);
			
			
			getServletContext().getRequestDispatcher("/guestProfile.jsp").forward(request, response);
		
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
