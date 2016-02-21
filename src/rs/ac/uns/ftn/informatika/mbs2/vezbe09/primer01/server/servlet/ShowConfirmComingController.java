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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ReservationDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ShowConfirmComingController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ShowConfirmComingController.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private ReservationDaoLocal reservationDao;
	
	@EJB
	private GuestDaoLocal guestDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			

			String restoranId = null;
			restoranId = request.getParameter("restoranId");
			
			
			String mojId = null;
			mojId = request.getParameter("friendId");
			String reservationIdStr = request.getParameter("reservationId");
			String friendsCallString = request.getParameter("friendsCallString");
			Restoran restoran = restoranDao.findById(Integer.parseInt(restoranId));
			Reservation reservation = reservationDao.findById(Integer.parseInt(reservationIdStr));
			Guest guest = guestDao.findById(Integer.parseInt(mojId));
			
			request.getSession().setAttribute("restoran", restoran);
			request.getSession().setAttribute("friendsCallString", friendsCallString);
			request.getSession().setAttribute("duration", reservation.getDuration().toString());
			request.getSession().setAttribute("dateandtime", reservation.getDate().toString());		
			request.getSession().setAttribute("reservation", reservation);
			request.getSession().setAttribute("confirmationGuest", guest);

			getServletContext().getRequestDispatcher("/friendConfirmationComing.jsp").forward(request, response);
			
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
