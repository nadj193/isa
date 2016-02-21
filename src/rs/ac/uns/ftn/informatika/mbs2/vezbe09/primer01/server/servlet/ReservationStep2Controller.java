package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ReservationStep2Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ReservationStep2Controller.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String restoranName = request.getParameter("name");
			String dateAndTime = request.getParameter("dateandtime");
			String duration = request.getParameter("duration");
			String restoranId = request.getParameter("restoranId");
			
			//dateandtime je oblika -->  2016-02-22T14:32 pa cu da zamenim T sa  space-om,
			// ako bude trebalo mogu i da splitujem pa da dobijem posebno vreme a posebno datum
			dateAndTime = dateAndTime.replace("T", " ");
			dateAndTime = dateAndTime +":00";
			
			System.out.println("Ime restortana je : " +restoranName);
			System.out.println("Date and time je: " +dateAndTime);
			System.out.println("Duration je: " +duration);
			System.out.println("Id restorana je: " +restoranId);
			
			
			
			Integer id = Integer.parseInt(restoranId);
			Restoran restoran = restoranDao.findById(id);
			request.getSession().setAttribute("restoran", restoran);
			request.getSession().setAttribute("dateandtime", dateAndTime);
			request.getSession().setAttribute("duration", duration);
			List<RestoranTable> reservationTables = new ArrayList<RestoranTable>();
			for(int i = 0; i < 40; i++) {
				reservationTables.add(null);
			}
			for(RestoranTable t : restoran.getTableConfiguration()){
				int position = t.getRow()*8+t.getColumn();
				reservationTables.set(position, t);
			}
			
			request.getSession().setAttribute("reservationTables", reservationTables);
			getServletContext().getRequestDispatcher("/guestReservation2.jsp").forward(request, response);
			
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
