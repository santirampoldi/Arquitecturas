package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	private String message;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		message = "Hello World";
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Hello World Servlet</title></head>");
		writer.println("<body>" + request.getRequestURL() + " "+request.getRequestURI()+" "+request.getQueryString() + "</body>");
		writer.println("</html>");
		writer.close();
	}

	public void destroy() {
	}
}
