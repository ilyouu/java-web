package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.NganhDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Nganh;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/sinh-vien-them")
public class ThemSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NganhDAO dao;
  
    public ThemSinhVienController() {
        super();
        dao = new NganhDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/nganh-them.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma_nganh = request.getParameter("ma_nganh");
		String ten_nganh = request.getParameter("ten_nganh");
		String loai_nganh = request.getParameter("loai_nganh");

		Nganh data = new Nganh(ma_nganh, ten_nganh, loai_nganh);
		try {
			if (data != null)
			dao.insert(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("nganh");
	}

}
