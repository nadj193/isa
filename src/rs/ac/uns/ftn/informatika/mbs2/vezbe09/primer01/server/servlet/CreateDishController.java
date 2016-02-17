package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.DishDaoLocal;

public class CreateDishController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CreateController.class);
	
	@EJB
	private DishDaoLocal dishDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String name = null;
			String description = null;
			String price = null;

			if ((request.getSession().getAttribute("manager")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			if ((request.getParameter("dishName") != null) && (!"".equals(request.getParameter("dishName")))) {
				name = request.getParameter("dishName");
			}

			if ((request.getParameter("dishDescription") != null) && (!"".equals(request.getParameter("dishDescription")))) {
				description = request.getParameter("dishDescription");
			}
			
			if ((request.getParameter("dishPrice") != null) && (!"".equals(request.getParameter("dishPrice")))) {
				price = request.getParameter("dishPrice");
			}

			Dish dish = new Dish();
			Restoran restoran = (Restoran)request.getSession().getAttribute("restoran");
			
			if(name != null)
				dish.setName(name);
			
			if(description != null)
				dish.setDescription(description);
			
			if(price != null)
				dish.setPrice(Float.valueOf(price));
			
			if (restoran != null)
				dish.setRestoran(restoran);
			
			dishDao.persist(dish);
			
			request.getSession().setAttribute("restoranMenu", dishDao.findRestoranMenu(restoran.getId()));
			
			getServletContext().getRequestDispatcher("/restoranMenu.jsp").forward(request, response);
			return;
			
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
