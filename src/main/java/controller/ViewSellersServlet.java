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
@WebServlet("/ViewSellersServlet")
public class ViewSellersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSellersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellerHelper sh = new SellerHelper();
		
		List<Seller> sellers = sh.showAllSellers();
		request.setAttribute("allHouses", sellers);
		
		String path;
		
		if (sellers.isEmpty()) {
			path = "/index.html";
		} else {
			path = "/seller-list.jsp";
		}
		
		 getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
