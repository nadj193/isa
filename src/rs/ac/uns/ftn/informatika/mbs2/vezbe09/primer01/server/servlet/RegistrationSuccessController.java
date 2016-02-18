package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;


public class RegistrationSuccessController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private static Logger log = Logger.getLogger(RegistrationSuccessController.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin admin = (Admin)request.getSession().getAttribute("user");
		System.out.println("Ime novog usera je: " +admin.getName());
		System.out.println("prezime novog usera je: " +admin.getLastName());
		System.out.println("Email novog usera je: " +admin.getEmail());
		System.out.println("Password novog usera je: " +admin.getPassword());
		
		//TODO
		//dodaj novog korisnika u bazu!!!
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
