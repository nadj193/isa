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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;

public class AddFriendController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private GuestDaoLocal guestDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(" id je: " +id);
		
		try {
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			Guest friend = (Guest)guestDao.findById(id);
			

			guest.addFriend(friend);
			guestDao.merge(guest);
			
			
			List<Guest> potencialFriend= guestDao.findPotencialFriends(guest.getId());
			request.getSession().setAttribute("potencialFriends", potencialFriend);
			

			List<Guest> friendList = guestDao.getFriendsList(guest.getId());

			request.getSession().setAttribute("friends", friendList);
			
			getServletContext().getRequestDispatcher("/addFriends.jsp").forward(request, response);

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
