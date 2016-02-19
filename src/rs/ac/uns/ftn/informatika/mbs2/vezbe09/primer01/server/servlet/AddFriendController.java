package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;

public class AddFriendController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private GuestDaoLocal guestDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Usao u ADDFRIEND");
		//String id = request.getParameter("id");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(" id je: " +id);
		
		try {
			
			if ((request.getSession().getAttribute("guest")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			System.out.println("IDEMO");
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			System.out.println("Ime ulogovanog je: " + guest.getName()+",a id je: " +guest.getId());
			Guest friend = (Guest)guestDao.findById(id);
			System.out.println("Ime dodatog prijatelja je: " + friend.getName()+",a id je: " +friend.getId());
			
			/*Guest friend = new Guest();
			friend.setName(friend2.getName());
			friend.setLastName(friend2.getLastName());
			friend.setAdress(friend2.getAdress());
			friend.setPassword(friend2.getPassword());
			friend.setEmail(friend2.getEmail());
			*/
			System.err.println("dodajemo prijatelja za ulogovanog");
			guest.addFriend(friend);
			System.out.println("**************");
			guestDao.merge(guest);
			System.out.println("dodao");
			System.out.println("dodajemo ulogovanog za prijatelja friendu");
			friend.addFriend(guest);
			guestDao.merge(friend);
			System.out.println("dodao");
			
			System.out.println("pravimo nove pootencijalne prijatelje");
			List<Guest> potencialFriend= guestDao.findPotencialFriends(guest.getId());
			System.out.println("napravili");
			System.out.println("stavljamo na sesiju");
			request.getSession().setAttribute("potencialFriends", potencialFriend);
			System.out.println("stavili");
			
			System.out.println("pravimo novu listu prijatelja");
			List<Guest> friendList = guestDao.getFriendsList(guest.getId());
			System.out.println("napravili listu prijatelja");
			System.out.println("stavljamo listu prijatelja na sesiju");
			request.getSession().setAttribute("friends", friendList);
			System.out.println("stavili");
			
			
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
