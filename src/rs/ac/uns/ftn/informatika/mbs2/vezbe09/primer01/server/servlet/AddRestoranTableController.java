package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AddRestoranTableController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CreateController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if ((request.getSession().getAttribute("manager")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String row = null;
			String column = null;
			row = request.getParameter("row");
			column = request.getParameter("column");
			
			System.out.println("Row " + row);
			System.out.println("Column " + column);
			
			getServletContext().getRequestDispatcher("/tableConfiguration.jsp").forward(request, response);	
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
