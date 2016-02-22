package utils;

import java.io.PrintWriter;

import javax.ws.rs.core.Response;

public class MessageServletUtil {
	
	private static MessageServletUtil instance =null;
	
	public static MessageServletUtil getInstance(){
		if(instance == null) {
			return new MessageServletUtil();
		} else {
			return instance;
		}
	}
	
	public void SetMessage(String message, String redirectLocation , PrintWriter pout) {
		
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<script>");
		
		pout.println("alert(\"\\"+message+"\")");
		pout.println("window.location.href = \"\\" +redirectLocation+ "\"");

		pout.println("</script>");
		pout.println("</body>");
		pout.println("</html>");
	
	}

}
