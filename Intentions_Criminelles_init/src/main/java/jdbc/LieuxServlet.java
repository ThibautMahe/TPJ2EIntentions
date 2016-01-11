package jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.LieuEntite;
import Services.LieuServices;

@WebServlet(name = "Lieux", urlPatterns = { "/Intentions_Criminelles/Lieux" })
public class LieuxServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LieuxGet.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LieuServices service = new LieuServices();

		LieuEntite Lieu = new LieuEntite(request.getParameter("Lieu"));
				
		service.setLieu(Lieu);

		request.setAttribute("Lieu", service.getAllLieux());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Lieux.jsp");
		rd.forward(request, response);
	}
}