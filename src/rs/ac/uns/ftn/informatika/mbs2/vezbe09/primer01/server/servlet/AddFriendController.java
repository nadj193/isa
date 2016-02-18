package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;

public class AddFriendController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(AddFriendController.class);
	
	@EJB
	private DishDaoLocal dishDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Usao u ADDFRIEND");
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
