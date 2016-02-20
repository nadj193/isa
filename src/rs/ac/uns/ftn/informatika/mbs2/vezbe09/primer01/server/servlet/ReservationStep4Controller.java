package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ReservationStep4Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ReservationStep4Controller.class);
	
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
			String check = request.getParameter("check");
			ArrayList<Integer> checkedFriends = (ArrayList<Integer>)request.getSession().getAttribute("checkedFriends");
			for (Integer i : checkedFriends) {
				System.out.println("Checked " + i);
			}
			
			//dateandtime je oblika -->  2016-02-22T14:32 pa cu da zamenim T sa  space-om,
			// ako bude trebalo mogu i da splitujem pa da dobijem posebno vreme a posebno datum
			//dateAndTime = dateAndTime.replace("T", " ");
			
			System.out.println("Ime restortana je : " +restoranName);
			System.out.println("Date and time je: " +dateAndTime);
			System.out.println("Duration je: " +duration);
			System.out.println("Id restorana je: " +restoranId);
			System.out.println("Check je: " +check);
			
			
			
			Integer id = Integer.parseInt(restoranId);
			
			request.getSession().setAttribute("restoran", (Restoran)restoranDao.findById(id));
			request.getSession().setAttribute("dateandtime", dateAndTime);
			request.getSession().setAttribute("duration", duration);
			
			System.out.println("-------------------------");
			String[] results = request.getParameterValues("check");
			
			for(int i=0;i<results.length;i++)
			{
				System.out.println("Idijevi su :" +results[i]);
			}
			
			
			

			getServletContext().getRequestDispatcher("/guestReservation3.jsp").forward(request, response);
			
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
