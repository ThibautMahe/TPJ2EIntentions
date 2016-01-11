package jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.Action_CriminelleEntite;
import Services.Action_CriminelleServices;

@WebServlet(urlPatterns = { "/Intentions_Criminelles/Actions_Criminelles" })
public class Actions_CriminellesServlet  extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Actions_CriminellesGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action_CriminelleServices service = new Action_CriminelleServices();

		Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite(request.getParameter("Action"));
				
		service.setAction_Criminelle(action_Criminelle);

		request.setAttribute("Action", service.getAllActions_Criminelles());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Actions_CriminellesPost.jsp");
		rd.forward(request, response);
	}
}