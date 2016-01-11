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
					Integer.parseInt(request.getParameter("id")), request.getParameter("Action"));
			service.setAction_Criminelle(action_Criminelle);
		} else if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) == 0) {
			Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Action"));
			service.createAction_Criminelle(action_Criminelle);
		}

		request.setAttribute("Actions_Criminelles", service.getAllActions_Criminelles());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Actions_CriminellesGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action_CriminelleServices service = new Action_CriminelleServices();
		for (int i = 1; i < service.getnbAction_Criminelle() + 1; i++) {
			if (request.getParameter("Modifier" + i) != null) {
				request.setAttribute("Actions_Criminelles", service.getAction_Criminelle(i));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Actions_CriminellesPost.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("Supprimer" + i) != null) {
				Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite(i);
				service.DeleteAction_Criminelle(action_Criminelle);
				request.setAttribute("Actions_Criminelles", service.getAllActions_Criminelles());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Actions_CriminellesGet.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getParameter("Ajouter action criminelle") != null) {
			Action_CriminelleEntite actions_Criminelle = new Action_CriminelleEntite(0, "");
			request.setAttribute("Actions_Criminelles", actions_Criminelle);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Actions_CriminellesPost.jsp");
			rd.forward(request, response);
		}
	}
}