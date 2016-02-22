package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ReservationDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranTableDaoLocal;

public class PrepareGuestHomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB
	private ReservationDaoLocal reservationDao;
	
	@EJB
	private RestoranTableDaoLocal reservationTableDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			releaseResevationsTables();
			
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			List<Reservation> reservations = reservationDao.getMyReservations(guest.getId());
			List<Reservation> expiredReservations = new ArrayList<Reservation>();
			for(Reservation r : reservations) {

				if((r.getDate().getTime() + r.getDuration() * 3600000) < new Date().getTime()) {
					expiredReservations.add(r);
				}
			}
			
			request.getSession().setAttribute("visitedRestorans", expiredReservations);
			List<Guest> friends = guestDao.getFriendsList(guest.getId());
			
			List<String> guestFriends = new ArrayList<String>(reservations.size());
			for(Reservation r : reservations){
				List<Guest> guests = reservationDao.getFriendByReservation(r.getId(), guest.getId());
				String temp = new String();
				for(Guest g : guests) {
					temp += g.getName() + " ";
				}
				guestFriends.add(temp);
			}
			
			request.getSession().setAttribute("guestFriends", guestFriends);
			request.getSession().setAttribute("friends", friends);
			
			List<RestoranTable> reservedTables = new ArrayList<RestoranTable>();
			request.getSession().setAttribute("reservedTables", reservedTables);
			
			getServletContext().getRequestDispatcher("/guestHome.jsp").forward(request, response);

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
	
	/**
	 * Releases reserved tables(sets it as free) if the reservation has expired
	 * This check is needed because server can be stopped after reservation commit,
	 * so in that case timer which is used for reservation table releasing after reservation
	 * expired doesn't exist anymore
	 */
	private void releaseResevationsTables() {
		List<Reservation> reservations = reservationDao.findAll();
		for(Reservation r : reservations) {
			long reservationEndTime = r.getDate().getTime() + r.getDuration() * 3600000;
			if (reservationEndTime < new Date().getTime()) {
				for(RestoranTable t : r.getTables()) {
					if(t.getIsReserved()) {
						t.setIsReserved(false);
						reservationTableDao.merge(t);
					}
				}
			}
		}
	}
}
