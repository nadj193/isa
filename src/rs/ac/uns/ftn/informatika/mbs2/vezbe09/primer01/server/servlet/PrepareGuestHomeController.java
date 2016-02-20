package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ReservationDaoLocal;

public class PrepareGuestHomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB
	private ReservationDaoLocal reservationDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			//TODO reservation list should be fetched for logged user
			List<Reservation> reservations = reservationDao.findAll();
			
			request.getSession().setAttribute("visitedRestorans", reservations);
			List<Guest> friends = guestDao.getFriendsList(guest.getId());
			String guestFriends = new String();
			for(Guest g : friends) {
				System.out.println("Friend " + g.getName());
				guestFriends += g.getName() + " ";
			}
			System.out.println(guestFriends);
			request.getSession().setAttribute("guestFriends", guestFriends);
			
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
}
