package jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.LieuEntite;
import Services.LieuServices;

@WebServlet(urlPatterns = { "/Intentions_Criminelles/Lieux" })
public class LieuxServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LieuServices service = new LieuServices();
		if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) != 0) {
			LieuEntite lieu = new LieuEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Name"));
			service.setLieu(lieu);
		} else if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) == 0) {
			LieuEntite lieu = new LieuEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Name"));
			service.createLieu(lieu);
		}

		request.setAttribute("Criminels", service.getAllLieux());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LieuServices service = new LieuServices();

		for (int i = 1; i < service.getnbLieu() + 1; i++) {
			if (request.getParameter("Modifier" + i) != null) {
				request.setAttribute("Criminels", service.getLieu(i));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("Supprimer" + i) != null) {
				LieuEntite lieu = new LieuEntite(i);
				service.DeleteLieu(lieu);
				request.setAttribute("Criminels", service.getAllLieux());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getParameter("Ajouter criminel") != null) {
			LieuEntite lieu = new LieuEntite(0, "");
			request.setAttribute("Lieux", lieu);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
			rd.forward(request, response);
		}
	}
}