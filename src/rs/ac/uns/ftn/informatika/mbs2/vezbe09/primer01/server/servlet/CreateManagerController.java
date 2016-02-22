package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import utils.MessageServletUtil;

public class CreateManagerController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CreateManagerController.class);

	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private ManagerDaoLocal managerDao;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null;
		String lastName = null;
		String email = null;
		String password = null;
		Integer restoranId = null; 
		PrintWriter pout = response.getWriter();

		
		if ((request.getSession().getAttribute("admin")) == null) {
			response.sendRedirect(response.encodeURL("./login.jsp"));
			return;
		}

		if ((request.getParameter("name") != null) && (!"".equals(request.getParameter("name")))) {
			name = request.getParameter("name");
		}

		if ((request.getParameter("lastName") != null) && (!"".equals(request.getParameter("lastName")))) {
			lastName = request.getParameter("lastName");
		}
		
		if ((request.getParameter("email") != null) && (!"".equals(request.getParameter("email")))) {
			email = request.getParameter("email");
		}

		if ((request.getParameter("password") != null) && (!"".equals(request.getParameter("password")))) {
			password = request.getParameter("password");
		}
		
		if ((request.getParameter("restoran") != null) && (!"".equals(request.getParameter("restoran")))) {
			restoranId = new Integer(request.getParameter("restoran"));
		}
		
		try {
				
			if(managerDao.findManagerByEmail(email) != null ) {
				String message = "User with email: " +email+" already exist, please enter other email."  ;
				String redirectLocation = "./createManager.jsp";
				MessageServletUtil.getInstance().SetMessage(message, redirectLocation, pout);
			}
			
			
			/*Manager manager = new Manager();
			
			if(name != null)
				manager.setName(name);
			
			if(lastName != null)
				manager.setLastName(lastName);
			
			if(email != null)
				manager.setEmail(email);
			
			if(password != null)
				manager.setPassword(password);
			
			if (restoranId != null)
				manager.setRestoran(restoranDao.findById(restoranId));
			
			//System.out.println(manager.toString());
			
			managerDao.persist(manager);

			getServletContext().getRequestDispatcher("/ReadAdminMenagersController").forward(request, response);
			return;
			*/
			
	//	} catch (ServletException e) {
	//		log.error(e);
	//		throw e;
		}catch (EJBException e1){
			if (e1.getCause().getClass().equals(NoResultException.class)) {
				Manager manager = new Manager();
				
				if(name != null)
					manager.setName(name);
				
				if(lastName != null)
					manager.setLastName(lastName);
				
				if(email != null)
					manager.setEmail(email);
				
				if(password != null)
					manager.setPassword(password);
				
				if (restoranId != null)
					manager.setRestoran(restoranDao.findById(restoranId));
				
				//System.out.println(manager.toString());
				
				managerDao.persist(manager);

				getServletContext().getRequestDispatcher("/ReadAdminMenagersController").forward(request, response);
				return;
				
			} 
		
		//}catch (IOException e) {
		//	log.error(e);
		//	throw e;
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
