package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class UpdateManagerController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(UpdateController.class);

	
	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private ManagerDaoLocal managerDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			//String managerId = null;
			String name = null;
			String lastName = null;
			String password = null;
			String email = null;
			Integer restoranId = null;
			
			if ((request.getSession().getAttribute("admin")) == null) {
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
						
			if ((request.getParameter("restoran")!=null) && (!"".equals(request.getParameter("restoran")))){
				restoranId = new Integer(request.getParameter("restoran"));
			}
			
	
		
				
			Manager manager = (Manager)request.getSession().getAttribute("manager");
			
			if (manager == null) {
				response.sendRedirect(response.encodeURL("./adminhome.jsp"));
				return;
			}
				
				if (name != null)
					manager.setName(name);
				
				if (lastName != null)
					manager.setLastName(lastName);
				
				if(password !=null)
					manager.setPassword(password);
				
				if(email !=null)
					manager.setEmail(email);			
				
				if (restoranId != null)
					manager.setRestoran(restoranDao.findById(restoranId));
				
				
				managerDao.merge(manager);
			
			
			getServletContext().getRequestDispatcher("/ReadAdminMenagersController").forward(request, response);
		
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
