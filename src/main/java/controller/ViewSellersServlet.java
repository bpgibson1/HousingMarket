package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Seller;

/**
 * Servlet implementation class ViewSellersServlet
 */
@WebServlet("/viewSellersServlet")
public class ViewSellersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSellersServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Seller> sellers = sh.showAllSellers();
		
		request.setAttribute("allSellers", sellers);
		
		String path;
		
		if (sellers.isEmpty()) {
			request.setAttribute("allSellers", " ");
			path = "/index.html";
		} else {
			path = "/seller-list.jsp";
		}
		
		for(Seller a : sellers) {
			System.out.println(a.toString());
		}
		
		 getServletContext().getRequestDispatcher(path).forward(request, response);
    	
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
