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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rate;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RateDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class RateRestoranController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private RateDaoLocal rateDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restoranName = request.getParameter("restoran");
		System.out.println("Restoran " + restoranName);
		Integer value = Integer.parseInt(request.getParameter("rate"));
		System.out.println(" Rate is: " +value);
		
		try {
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			Restoran restoran = (Restoran)request.getSession().getAttribute("visitedRestoran");
			List<Rate> rates = rateDao.findAll();
			boolean exists = false;
			for(Rate r : rates){
				if(r.getGuest().getId().intValue() == guest.getId().intValue() &&
						r.getRestoran().getId().intValue() == restoran.getId().intValue()) {
					r.setValue(value);
					rateDao.merge(r);
					exists = true;
				}
			}
			if(!exists) {
				Rate rate = new Rate();
				rate.setGuest(guest);
				rate.setRestoran(restoran);
				rate.setValue(value);
				rateDao.persist(rate);
			}
			
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
