package jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.CriminelEntite;
import Services.CriminelServices;

@WebServlet(urlPatterns = { "/Intentions_Criminelles/Criminels" })
public class CriminelsServlet  extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CriminellesGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriminelServices service = new CriminelServices();

		CriminelEntite Criminel = new CriminelEntite(request.getParameter("Name"),Integer.parseInt(request.getParameter("Age")));
		
		service.setCriminel(Criminel);
		
		request.setAttribute("Criminels", service.getAllCriminels());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CriminellesPost.jsp");
		rd.forward(request, response);
	}
}
