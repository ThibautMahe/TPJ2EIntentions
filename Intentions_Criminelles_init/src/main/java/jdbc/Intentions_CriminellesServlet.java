package jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.CriminelEntite;
import Services.CriminelServices;

@WebServlet(name = "Intentions_Criminelles", urlPatterns = { "/Intentions_Criminelles" })
public class Intentions_CriminellesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Intentions Criminelles</title></head>");
		writer.println("<body><h1>Intentions Criminelles</h1>");
		writer.println("<form method='post'>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>Name:</td>");
		writer.println("<td><input Name='Name'/></td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>Age:</td>");
		writer.println("<td><input Name='Age'/></td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<tr>");
		writer.println("<td>&nbsp;</td>");
		writer.println("<td><input type='reset'/>" + "<input type='submit'/></td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriminelServices service = new CriminelServices();

		CriminelEntite Criminel = new CriminelEntite(request.getParameter("Name"),Integer.parseInt(request.getParameter("Age")));
		
		service.setCriminel(Criminel);
		
		request.setAttribute("Criminels", service.getAllCriminels());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Intentions_Criminelles.jsp");
		rd.forward(request, response);
	}

}
