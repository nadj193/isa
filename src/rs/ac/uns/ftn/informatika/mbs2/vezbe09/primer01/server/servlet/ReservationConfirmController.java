package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ReservationDaoLocal;

public class ReservationConfirmController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ReservationConfirmController.class);
	
	@EJB
	private ReservationDaoLocal reservationDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {		
			Reservation reservation = (Reservation)request.getSession().getAttribute("reservation");
			Guest guest = (Guest)request.getSession().getAttribute("confirmationGuest");
			
			reservation.addGuest(guest);
			reservationDao.merge(reservation);
			
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
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
