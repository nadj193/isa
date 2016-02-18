package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AddRestoranTableController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CreateController.class);
	
	private int counter;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if ((request.getSession().getAttribute("manager")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String row = null;
			String column = null;
			row = request.getParameter("row");
			column = request.getParameter("column");
			
			System.out.println("Row " + row);
			System.out.println("Column " + column);
			
			int tableRow = Integer.parseInt(row) - 1;
			int tableColumn = Integer.parseInt(column) -1;
			int position = (tableRow) * 8 + tableColumn;
			
			@SuppressWarnings("unchecked")
			List<Integer> restoranTables = (List<Integer>)request.getSession().getAttribute("restoranTables");
			counter = 0;
			for (Integer i : restoranTables) {
				if (i != -1){
					counter++;
				}
			}
			
			if (restoranTables.get(position) == -1) {
				restoranTables.set(position, ++counter);
			}
			request.getSession().setAttribute("restoranTables", restoranTables);
			
			System.out.println("Redni broj stola " + counter);
			System.out.println("Pozicija stola " + position);
			getServletContext().getRequestDispatcher("/tableConfiguration.jsp").forward(request, response);
			
			/*PrintWriter out = response.getWriter();
			JSONObject jsonReply = new JSONObject();
			response.setStatus(HttpServletResponse.SC_OK);
			jsonReply.put("ordinal", 10);
			jsonReply.put("successfully", true);
			out.print(jsonReply);*/
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
