package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.TruongDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Truong;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/truong-them")
public class ThemTruongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TruongDAO truongDAO;
  
    public ThemTruongController() {
        super();
        truongDAO = new TruongDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/truong-them.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma_truong = request.getParameter("ma_truong");
		String ten_truong = request.getParameter("ten_truong");
		String dia_chi = request.getParameter("dia_chi");
		String so_dien_thoai = request.getParameter("so_dien_thoai");

		Truong data = new Truong(ma_truong, ten_truong, dia_chi, so_dien_thoai);
		try {
			if (data != null)
			truongDAO.insert(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("truong");
	}

}
