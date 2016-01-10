package jdbc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CriminelServices;

@WebServlet(name = "Intentions_Criminelles", urlPatterns = { "/Intentions_Criminelles" })
public class Intentions_CriminellesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CriminelServices service = new CriminelServices();

		request.setAttribute("Criminels", service.getAllIntentions());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Intentions_Criminelles.jsp");
		
		rd.forward(request, response);
	}

}
