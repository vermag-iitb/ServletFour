// Description:
// ------------
// The reason why 'count' not resetting on page refresh is, every new request calls only Servlet.service(), 
// and other variables and methods are intact.
 
// Only when server restarts/browser minimized-maximized, etc. only then Servlet object is created afresh.


package Four;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;

//@WebServlet("/counter")
public class CounterServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public CounterServlet() {
        super();
    }
    int count = 0;
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
    	try
        {
            count++;
            
    		response.setContentType("text/HTML");
    		// Default MIME type - "text/HTML"
            PrintWriter pw = response.getWriter();
            pw.println("<html><body bgcolor=green text=yellow><h1>");
            pw.println("This page has been accessed <b><i>"+count+"</i></b> times");
            pw.println("</h1></body></html>");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
	}
}
