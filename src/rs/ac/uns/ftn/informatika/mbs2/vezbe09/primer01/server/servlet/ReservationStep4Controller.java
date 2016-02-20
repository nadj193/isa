package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class ReservationStep4Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ReservationStep4Controller.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;

	@EJB
	private GuestDaoLocal guestDao;
	
	@Resource(name="Mail")
	Session session;

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
			//ArrayList<Integer> checkedFriends = (ArrayList<Integer>)request.getSession().getAttribute("checkedFriends");
			//for (Integer i : checkedFriends) {
			//	System.out.println("Checked " + i);
			//}
			
			//dateandtime je oblika -->  2016-02-22T14:32 pa cu da zamenim T sa  space-om,
			// ako bude trebalo mogu i da splitujem pa da dobijem posebno vreme a posebno datum
			//dateAndTime = dateAndTime.replace("T", " ");
			
			System.out.println("Ime restortana je : " +restoranName);
			System.out.println("Date and time je: " +dateAndTime);
			System.out.println("Duration je: " +duration);
			System.out.println("Id restorana je: " +restoranId);
			System.out.println("Check je: " +check);
			
			Restoran restoran = (Restoran) request.getSession().getAttribute("restoran");
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			
			
			
			Integer id = Integer.parseInt(restoranId);
			
			request.getSession().setAttribute("restoran", (Restoran)restoranDao.findById(id));
			request.getSession().setAttribute("dateandtime", dateAndTime);
			request.getSession().setAttribute("duration", duration);
			
			System.out.println("-------------------------");
			String[] results = request.getParameterValues("check");
			
			
			ArrayList<Guest> friendsCallList = new ArrayList<Guest>();
			for(int i=0;i<results.length;i++)
			{
				System.out.println("Idijevi su :" +results[i]);
				friendsCallList.add((Guest)guestDao.findById(Integer.parseInt(results[i])));
				
			}
			
			request.getSession().setAttribute("friendsCallList",friendsCallList);
			
			
			
			
			
			System.out.println("sriprema za slanje mejla.");
			/*for(int i=0;i<friendsCallList.size();i++) {
			javax.mail.Message msg = new MimeMessage(session);
			try {
				System.out.println("Saljemo mejl");
				msg.setFrom(new InternetAddress("iprojekat@gmail.com"));
				msg.setRecipients(RecipientType.TO, InternetAddress.parse(friendsCallList.get(i).getEmail()));
				msg.setSubject("Confirmation restoran call");
				msg.setText("Your friend "+ guest.getName() + " call you in restoran " + restoran.getName());
				msg.setContent("<p>Ovo je automatska poruka namenjena za potvrdu posete restoranu. "
		         		+ "Kliknite na link da biste odgovorili na poziv.</p>"
		         		+ "<a href='http://localhost:8080/Vezbe09/ShowConfirmComingController?id="+UUID.randomUUID().toString()+"'>Confirm your arrival</a>",
	                     "text/html" );
				msg.setSentDate(new Date());
				
				Transport.send(msg);
				System.out.println("Poslali mejl");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			System.out.println("MESSAGE BEAN: Mail was sent successfully.");
			}*/
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
