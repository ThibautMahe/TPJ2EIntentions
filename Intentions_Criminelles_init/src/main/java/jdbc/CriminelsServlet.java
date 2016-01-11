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
public class CriminelsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriminelServices service = new CriminelServices();
		if (request.getParameter("submit") != null)
			System.out.println("hello ");
		if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) != 0) {
			System.out.println("hello modif");
			CriminelEntite criminel = new CriminelEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Name"), Integer.parseInt(request.getParameter("Age")));
			service.setCriminel(criminel);
		} else if (request.getParameter("submit") != null && Integer.parseInt(request.getParameter("id")) == 0) {
			System.out.println("hello modif");
			CriminelEntite criminel = new CriminelEntite(Integer.parseInt(request.getParameter("id")),
					request.getParameter("Name"), Integer.parseInt(request.getParameter("Age")));
			service.createCriminel(criminel);
		}

		request.setAttribute("Criminels", service.getAllCriminels());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriminelServices service = new CriminelServices();

		for (int i = 1; i < service.getnbCriminel() + 1; i++) {
			if (request.getParameter("Modifier" + i) != null) {
				request.setAttribute("Criminels", service.getCriminel(i));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("Supprimer" + i) != null) {
				CriminelEntite criminel = new CriminelEntite(i);
				service.DeleteCriminel(criminel);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsGet.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getParameter("Ajouter criminel") != null) {
			CriminelEntite criminel = new CriminelEntite(0, "", 0);
			request.setAttribute("Criminels", criminel);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CriminelsPost.jsp");
			rd.forward(request, response);
		}
	}
}
