package controller;

import java.io.IOException;
import java.util.List;

import dao.TruongDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Truong;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/truong")
public class TruongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TruongDAO truongDAO;
	
    public TruongController() {
        super();
        truongDAO = new TruongDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Truong> list = truongDAO.selectAll();
		request.setAttribute("list", list);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/truong.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
