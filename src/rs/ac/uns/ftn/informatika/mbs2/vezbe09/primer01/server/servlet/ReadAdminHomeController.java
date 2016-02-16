package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ReadAdminHomeController extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ReadAdminHomeController.class);

	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private ManagerDaoLocal managerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			System.out.println("Usao u read restoran!!");
		    List<Restoran> restList = restoranDao.findAll();
		    for(int i=0;i<restList.size();i++)
		    {
		    	System.out.println(restList.get(i).getName());
		    }
		    
		    request.getSession().setAttribute("manageri", managerDao.findAll());
			request.getSession().setAttribute("restorani", restoranDao.findAll());
			
			getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
		
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
