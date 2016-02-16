package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GorivoDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenjacDaoLocal;

public class PrepareCreateRestoranController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(PrepareCreateRestoranController.class);

	@EJB
	private MenjacDaoLocal menjacDao;

	@EJB
	private GorivoDaoLocal gorivoDao;
	
	@EJB
	private DishDaoLocal dishDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			request.setAttribute("menjaci", menjacDao.findAll());
			request.setAttribute("goriva", gorivoDao.findAll());
			request.getSession().setAttribute("jela", dishDao.findAll());

			getServletContext().getRequestDispatcher("/createRestoran.jsp").forward(request, response);

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
