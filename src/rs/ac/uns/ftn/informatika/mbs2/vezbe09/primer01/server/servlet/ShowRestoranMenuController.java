package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ShowRestoranMenuController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ShowRestoranMenuController.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private DishDaoLocal dishDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String restoranid = request.getParameter("restoranId");
			Integer id = Integer.parseInt(restoranid);
			
			request.getSession().setAttribute("restoranMenu", dishDao.findRestoranMenu(id));

			getServletContext().getRequestDispatcher("/guestRestoranMenu.jsp").forward(request, response);
			
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
