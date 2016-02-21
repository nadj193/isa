package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;

public class AddReservationTableController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private static Logger log = Logger.getLogger(CreateController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String row = null;
			String column = null;
			row = request.getParameter("row");
			column = request.getParameter("column");
			
			System.out.println("Row " + row);
			System.out.println("Column " + column);
			
			int tableRow = Integer.parseInt(row) - 1;
			int tableColumn = Integer.parseInt(column) -1;
			int position = (tableRow) * 8 + tableColumn;
			
			Restoran restoran = (Restoran)request.getSession().getAttribute("restoran");
			@SuppressWarnings("unchecked")
			List<RestoranTable> reservationTables = (List<RestoranTable>)request.getSession().getAttribute("reservationTables");
			@SuppressWarnings("unchecked")
			List<RestoranTable> reservedTables = (List<RestoranTable>)request.getSession().getAttribute("reservedTables");
			
			Iterator<RestoranTable> iter = restoran.getTableConfiguration().iterator();
			while(iter.hasNext()) {
				RestoranTable table = iter.next();
				int tablePosition = table.getRow()*8+table.getColumn();
				if (tablePosition == position) {
					table.setIsReserved(true);
					reservationTables.set(position, table);
					reservedTables.add(table);
				}
			}
			
			request.getSession().setAttribute("reservationTables", reservationTables);
			request.getSession().setAttribute("reservedTables", reservedTables);
			request.getSession().setAttribute("restoran", restoran);
			getServletContext().getRequestDispatcher("/guestReservation2.jsp").forward(request, response);
			
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
