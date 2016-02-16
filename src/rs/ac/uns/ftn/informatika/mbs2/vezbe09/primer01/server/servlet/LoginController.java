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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.AdminDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.KorisnikDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7345471861052209628L;
	
	private static Logger log = Logger.getLogger(LoginController.class);

	@EJB
	private KorisnikDaoLocal korisnikDao;
	
	@EJB
	private AdminDaoLocal adminDao;
	
	@EJB
	private ManagerDaoLocal managerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			
			String korisnickoIme = request.getParameter("email");
			String lozinka = request.getParameter("password");
			
			
			System.out.println("email je : " +korisnickoIme);
			System.out.println("pass je: " +lozinka);
			
			if ((korisnickoIme == null) || (korisnickoIme.equals("")) || (lozinka == null) || (lozinka.equals(""))) {
				response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
				return;
			}
			
			Admin admin = adminDao.findAdmin(korisnickoIme, lozinka);
			Manager manager = managerDao.findManager(korisnickoIme, lozinka);
			//Korisnik korisnik = korisnikDao.findKorisnikSaKorisnickimImenomILozinkom(korisnickoIme, lozinka);
			
			if(admin != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", admin);
				log.info("Admin " + admin.getName() + " se prijavio.");
				getServletContext().getRequestDispatcher("/ReadRestoranController").forward(request, response);
				//response.sendRedirect(response.encodeRedirectURL("./adminhome.jsp"));
				
			}
			else if(manager != null) {	
				HttpSession session = request.getSession(true);
				session.setAttribute("manager", manager);
				session.setAttribute("restoran", manager.getRestoran());
				log.info("Manager " + manager.getName() + " se prijavio.");
				getServletContext().getRequestDispatcher("/manager_home.jsp").forward(request, response);
			} else {
				System.out.println("asfsafsaas");
				out.println ("<html><body><script>alert('Hello World!');</script></body></html>");
			}
			
			/*if (korisnik != null) {	
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", korisnik);
				log.info("Korisnik " + korisnik.getKorisnickoImeKorisnika() + " se prijavio.");
				getServletContext().getRequestDispatcher("/ReadController").forward(request, response);
			}*/
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				System.out.println("asfsafsaas");
				out.println ("<html><body><script>alert('Hello World!');</script></body></html>");
				response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
			} else {
				throw e;
			}
		}/* catch (ServletException e) {
			log.error(e);
			throw e;
		} */catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
