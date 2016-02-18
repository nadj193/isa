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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranTableDaoLocal;

public class SaveRestoranTableConfiguration extends HttpServlet {

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
			
			@SuppressWarnings("unchecked")
			List<Integer> restoranTables = (List<Integer>)request.getSession().getAttribute("restoranTables");
			Restoran restoran = (Restoran)request.getSession().getAttribute("restoran");
			
			int position = 0;
			int tableOrdinal = 1;
			for(Integer i : restoranTables) {
				if (i != -1) {
					int row = position/8;
					int column = position%8;
					RestoranTable table = new RestoranTable();
					table.setRow(row);
					table.setColumn(column);
					table.setOrdinal(tableOrdinal);
					table.setRestoran(restoran);
					restoranTableDao.persist(table);
					tableOrdinal++;
				}
				position++;
			}
			
			request.getSession().setAttribute("restoran", restoran);
			getServletContext().getRequestDispatcher("/manager_home.jsp").forward(request, response);
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
