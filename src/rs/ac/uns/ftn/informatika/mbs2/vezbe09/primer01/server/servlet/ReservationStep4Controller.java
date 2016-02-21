package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ReservationDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranTableDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.TestLocal;
import utils.DateTimeUtil;

public class ReservationStep4Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ReservationStep4Controller.class);
	
	@EJB
	private RestoranDaoLocal restoranDao;

	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB 
	private TestLocal testLocal;
	
	@EJB
	private ReservationDaoLocal reservationDao;
	
	
	@EJB
	private RestoranTableDaoLocal restoranTableDao;
	
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
			
			Restoran restoran = (Restoran) request.getSession().getAttribute("restoran");
			Guest guest = (Guest) request.getSession().getAttribute("guest");
			@SuppressWarnings("unchecked")
			List<RestoranTable> reservedTables = (List<RestoranTable>)request.getSession().getAttribute("reservedTables");
			
			
			Integer id = Integer.parseInt(restoranId);
			
			request.getSession().setAttribute("restoran", (Restoran)restoranDao.findById(id));
			request.getSession().setAttribute("dateandtime", dateAndTime);
			request.getSession().setAttribute("duration", duration);
			
			
			Reservation reservation =new Reservation();
			reservation.setDate(DateTimeUtil.getInstance().getDate(dateAndTime));
			reservation.setDuration(Integer.parseInt(duration));
			reservation.addGuest(guest);
			
			reservationDao.persist(reservation);
			for(RestoranTable table : reservedTables) {
				restoranTableDao.merge(table);
				reservation.addTable(table);
			}
			reservationDao.merge(reservation);
			
			Integer reservationId = reservation.getId();
			
			//run timer to release reserved tables when reservation ends
			runTimer(reservation);
			if(check!=null) {
			
				String[] results = request.getParameterValues("check");
				
				
				ArrayList<Guest> friendsCallList = new ArrayList<Guest>();
				for(int i=0;i<results.length;i++)
				{
					friendsCallList.add((Guest)guestDao.findById(Integer.parseInt(results[i])));
					
				}
				
				request.getSession().setAttribute("friendsCallList",friendsCallList);
				String friendsCallString = new String();
				for(int i=0;i<friendsCallList.size();i++)
				{
					friendsCallString += " "+friendsCallList.get(i).getName() + ",";
				}
				
				//ukloni razmak sa pocetka i zarez na kraju stringa
				if (friendsCallString.length() > 0 && friendsCallString.charAt(friendsCallString.length()-1)==',') {
					friendsCallString = friendsCallString.substring(0, friendsCallString.length()-1);
					friendsCallString = friendsCallString.substring(1);
				    }
				
				request.getSession().setAttribute("friendsCallString",friendsCallString);
				
				
				for(int i=0;i<friendsCallList.size();i++) {
				javax.mail.Message msg = new MimeMessage(session);
				try {
					testLocal.test();
					msg.setFrom(new InternetAddress("iprojekat@gmail.com"));
					msg.setRecipients(RecipientType.TO, InternetAddress.parse(friendsCallList.get(i).getEmail()));
					msg.setSubject("Confirmation restoran call");
					msg.setText("Your friend "+ guest.getName() + " call you in restoran " + restoran.getName());
					msg.setContent("<p>Ovo je automatska poruka namenjena za potvrdu posete restoranu. "
			         		+ "Kliknite na link da biste odgovorili na poziv.</p>"
			         		+ "<a href='http://localhost:8080/Vezbe09/ShowConfirmComingController?friendsCallString="+friendsCallString+"&reservationId="+reservationId+"&restoranId="+restoranId+"&friendId="+friendsCallList.get(i).getId()+"&id="+UUID.randomUUID().toString()+"'>Confirm your arrival</a>",
		                     "text/html" );
					msg.setSentDate(new Date());
					
					Transport.send(msg);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("MESSAGE BEAN: Mail was sent successfully.");
				}
			
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
	
	private void runTimer(final Reservation reservation) {
		Timer timer = new Timer();
		long reservationEndTime = reservation.getDate().getTime() + reservation.getDuration() * 3600000;
		long timerTime = reservationEndTime - new Date().getTime();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				for(RestoranTable t : reservation.getTables()) {
					t.setIsReserved(false);
					restoranTableDao.merge(t);
				}
			}
		};
		timer.schedule(timerTask, timerTime);
	}
}
