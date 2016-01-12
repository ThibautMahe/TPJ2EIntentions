package jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.Intention_CriminelleEntite;
import DB.Entite.LieuEntite;
import Services.Action_CriminelleServices;
import Services.CriminelServices;
import Services.Intention_CriminelleServices;
import Services.LieuServices;

@WebServlet(urlPatterns = { "/Intentions_Criminelles" })
public class Intentions_CriminellesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Intention_CriminelleServices service = new Intention_CriminelleServices();
		CriminelServices criminelService = new CriminelServices();
		LieuServices lieuService = new LieuServices();
		Action_CriminelleServices action_CriminelleService = new Action_CriminelleServices();
		String link = "WEB-INF/views/Intentions_CriminellesGet.jsp";

		if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) != 0) {
			Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite(
					Integer.parseInt(request.getParameter("IntentionID")),
					action_CriminelleService
							.getAction_Criminelle(Integer.parseInt(request.getParameter("Action_CriminelleID"))),
					criminelService.getCriminel(Integer.parseInt(request.getParameter("CriminelID"))),
					lieuService.getLieu(Integer.parseInt(request.getParameter("LieuID"))));
			if(!service.setIntention_Criminelle(intention_Criminelle)) link = "WEB-INF/views/Intentions_CriminellesNoOk.jsp";
		} else if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) == 0) {
			Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite(
					Integer.parseInt(request.getParameter("IntentionID")),
					action_CriminelleService
							.getAction_Criminelle(Integer.parseInt(request.getParameter("Action_CriminelleID"))),
					criminelService.getCriminel(Integer.parseInt(request.getParameter("CriminelID"))),
					lieuService.getLieu(Integer.parseInt(request.getParameter("LieuID"))));
			if(!service.createIntention_Criminelle(intention_Criminelle)) link = "WEB-INF/views/Intentions_CriminellesNoOk.jsp";
		}

		request.setAttribute("Intentions_Criminelles", service.getAllIntentions_Criminelles());

		RequestDispatcher rd = request.getRequestDispatcher(link);
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Intention_CriminelleServices service = new Intention_CriminelleServices();
		CriminelServices criminelService = new CriminelServices();
		LieuServices lieuService = new LieuServices();
		Action_CriminelleServices action_CriminelleService = new Action_CriminelleServices();

		for (int i = 1; i < service.getnbIntention_Criminelle() + 1; i++) {
			if (request.getParameter("Modifier" + i) != null) {
				request.setAttribute("Intentions_Criminelles", service.getIntention_Criminelle(i));
				request.setAttribute("Actions_Criminelles", action_CriminelleService.getAllActions_Criminelles());
				request.setAttribute("Lieux", lieuService.getAllLieux());
				request.setAttribute("Criminels", criminelService.getAllCriminels());
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Intentions_CriminellesPost.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("Supprimer" + i) != null) {
				Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite(i);
				service.DeleteIntention_Criminelle(intention_Criminelle);
				request.setAttribute("Intentions_Criminelles", service.getAllIntentions_Criminelles());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LieuxGet.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getParameter("Ajouter intention criminelle") != null) {
			Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite(0);
			request.setAttribute("Intentions_Criminelles", intention_Criminelle);
			request.setAttribute("Actions_Criminelles", action_CriminelleService.getAllActions_Criminelles());
			request.setAttribute("Lieux", lieuService.getAllLieux());
			request.setAttribute("Criminels", criminelService.getAllCriminels());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Intentions_CriminellesPost.jsp");
			rd.forward(request, response);
		}
	}

}
