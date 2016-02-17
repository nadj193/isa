package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class PrepareUpdateRestoranController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(PrepareUpdateController.class);


	@EJB
	private RestoranDaoLocal restoranDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			request.getSession().setAttribute("restorani", restoranDao.findAll());

			String restoranId = request.getParameter("restoranId");

			if ((restoranId != null) && (!restoranId.equals(""))) {
				request.getSession().setAttribute("restoran", restoranDao.findById(Integer.parseInt(restoranId)));
				getServletContext().getRequestDispatcher("/update_restoran.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/adminRestoran.jsp").forward(request, response);
			}
			
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
