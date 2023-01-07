package controller;

import java.io.IOException;
import java.util.List;

import dao.NganhDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Nganh;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/sinh-vien")
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NganhDAO dao;
	
    public SinhVienController() {
        super();
        dao = new NganhDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Nganh> list = dao.selectAll();
		request.setAttribute("list", list);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/nganh.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
