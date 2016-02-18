package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranTableDaoLocal;

public class PrepareTableConfigurationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CreateController.class);
	
	@EJB
	private RestoranTableDaoLocal restoranTableDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if ((request.getSession().getAttribute("manager")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			Restoran restoran = (Restoran)request.getSession().getAttribute("restoran");
			List<Integer> restoranTables = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
			List<RestoranTable> tableConfiguration = restoranTableDao.findRestoranTableConfiguration(restoran.getId());
			if (tableConfiguration.size() != 0) {
				for(RestoranTable t : tableConfiguration) {
					System.out.println("Table postion row " + t.getRow());
					System.out.println("Table position column " + t.getColumn());
					int position = t.getRow()*8 + t.getColumn();
					restoranTables.set(position, t.getOrdinal());
				}
				request.getSession().setAttribute("restoranTables", restoranTables);
				getServletContext().getRequestDispatcher("/showTableConfiguration.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("restoranTables", restoranTables);
				getServletContext().getRequestDispatcher("/tableConfiguration.jsp").forward(request, response);
			}
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
