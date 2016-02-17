package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class UpdateRestoranController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(LoginController.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String name = null;
			String description = null;

			if ((request.getSession().getAttribute("admin")) == null && (request.getSession().getAttribute("manager")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			if ((request.getParameter("restoranName") != null) && (!"".equals(request.getParameter("restoranName")))) {
				name = request.getParameter("restoranName");
			}

			if ((request.getParameter("restoranDescription") != null) && (!"".equals(request.getParameter("restoranDescription")))) {
				description = request.getParameter("restoranDescription");
			}
			
			Restoran restoran = (Restoran)request.getSession().getAttribute("restoran");
			
			if (restoran == null) {
				response.sendRedirect(response.encodeURL("./manager_home.jsp"));
				return;
			}
			
			if(name != null)
				restoran.setName(name);
			
			if(description != null)
				restoran.setDescription(description);
			
			restoranDao.merge(restoran);
			
			if ((request.getSession().getAttribute("admin")) != null ) {
				getServletContext().getRequestDispatcher("/ReadAdminRestoraniController").forward(request, response);
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("restoran", restoran);
			
				getServletContext().getRequestDispatcher("/manager_home.jsp").forward(request, response);
			}
			return;
			
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
