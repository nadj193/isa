package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.AdminDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GuestDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7345471861052209628L;
	
	private static Logger log = Logger.getLogger(LoginController.class);

	@EJB
	private RestoranDaoLocal restoranDao;
	
	@EJB
	private AdminDaoLocal adminDao;
	
	@EJB
	private ManagerDaoLocal managerDao;
	
	@EJB
	private GuestDaoLocal guestDao;
	
	@EJB DishDaoLocal dishDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String korisnickoIme = request.getParameter("email");
		String lozinka = request.getParameter("password");
		try {
			
			System.out.println("email je : " +korisnickoIme);
			System.out.println("pass je: " +lozinka);
			
			//PrintWriter out = response.getWriter();
			//out.println ("<html><body><script>alert('Hello World!');</script></body></html>");
			
			if ((korisnickoIme == null) || (korisnickoIme.equals("")) || (lozinka == null) || (lozinka.equals(""))) {
				response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
				return;
			}
			
			Admin admin = adminDao.findAdmin(korisnickoIme, lozinka);
			//Korisnik korisnik = korisnikDao.findKorisnikSaKorisnickimImenomILozinkom(korisnickoIme, lozinka);
			
			if(admin != null){
				System.out.println("ADMIN LOG USAO");
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", admin);
				log.info("Admin " + admin.getName() + " se prijavio.");
				getServletContext().getRequestDispatcher("/ReadAdminHomeController").forward(request, response);
				//response.sendRedirect(response.encodeRedirectURL("./adminhome.jsp"));
				
			}
			/*if (korisnik != null) {	
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", korisnik);
				log.info("Korisnik " + korisnik.getKorisnickoImeKorisnika() + " se prijavio.");
				getServletContext().getRequestDispatcher("/ReadController").forward(request, response);
			}*/
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				try {
					Manager manager = managerDao.findManager(korisnickoIme, lozinka);
					if(manager != null) {	
						System.out.println("MANAGER LOG USAO");
						HttpSession session = request.getSession(true);
						session.setAttribute("manager", manager);
						session.setAttribute("restoran", manager.getRestoran());
						session.setAttribute("restoranMenu", dishDao.findRestoranMenu(manager.getRestoran().getId()));
						log.info("Manager " + manager.getName() + " se prijavio.");
						getServletContext().getRequestDispatcher("/manager_home.jsp").forward(request, response);
					}
				} catch (EJBException exp) {
					if (e.getCause().getClass().equals(NoResultException.class)) {
						try {
							Guest guest = guestDao.findGuest(korisnickoIme, lozinka);
							if(guest != null) {	
								System.out.println("GUEST LOG USAO");
								HttpSession session = request.getSession(true);
								session.setAttribute("guest", guest);
								log.info("Guest " + guest.getName() + " se prijavio.");
								request.getSession().setAttribute("restorani", restoranDao.findAll());
								getServletContext().getRequestDispatcher("/PrepareGuestHomeController").forward(request, response);
							}
						} catch (EJBException exp1) {
							if (exp1.getCause().getClass().equals(NoResultException.class)) {
								
								PrintWriter pout = response.getWriter();
								pout.println("<html>");
								pout.println("<head>");
								pout.println("</head>");
								pout.println("<body>");
								pout.println("<script>");
								pout.println("alert(\"Niste dobro uneli email i sifru,ne postoji user.\")");
								pout.println("window.location.href = \"./login.jsp\"");
								pout.println("</script>");
								//pout.println("<br>" + request.getParameter("ime"));
								//pout.println("<br>" + request.getParameterNames());
								pout.println("</body>");
								pout.println("</html>");

								//response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
							}
						}
					}
				}
			}
		}catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
