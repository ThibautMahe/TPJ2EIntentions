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
public class Actions_CriminellesServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action_CriminelleServices service = new Action_CriminelleServices();
		if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) != 0) {
			Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite(
					Integer.parseInt(request.getParameter("id")), request.getParameter("Name"));
			service.setAction_Criminelle(action_Criminelle);
		} else if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) == 0) {
			Action_CriminelleEntite criminel = new Action_CriminelleEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Name"));
			service.createAction_Criminelle(criminel);
		}

		request.setAttribute("Criminels", service.getAllActions_Criminelles());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action_CriminelleServices service = new Action_CriminelleServices();

		for (int i = 1; i < service.getnbAction_Criminelle() + 1; i++) {
			if (request.getParameter("Modifier" + i) != null) {
				request.setAttribute("Criminels", service.getAction_Criminelle(i));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("Supprimer" + i) != null) {
				Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite(i);
				service.DeleteAction_Criminelle(action_Criminelle);
				request.setAttribute("Criminels", service.getAllActions_Criminelles());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getParameter("Ajouter criminel") != null) {
			Action_CriminelleEntite criminel = new Action_CriminelleEntite(0, "");
			request.setAttribute("Criminels", criminel);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
			rd.forward(request, response);
		}
	}
}