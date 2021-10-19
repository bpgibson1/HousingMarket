package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Seller;

/**
 * Servlet implementation class SellerNavigationServlet
 */
@WebServlet("/sellerNavigationServlet")
public class SellerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerNavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellerHelper sh = new SellerHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/ViewSellersServlet";
		
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("sellerId"));
				Seller sellerToDelete = sh.searchForSellerById(tempId);
				sh.removeSeller(sellerToDelete);
			} catch (NumberFormatException e) {
				System.out.println("forgot to select an item");
			}
			
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("sellerId"));
				Seller sellerToEdit = sh.searchForSellerById(tempId);
				request.setAttribute("sellerToEdit", sellerToEdit);
				path = "/edit-seller.jsp";
			} catch (NumberFormatException e) {
				System.out.println("forgot to select an item");
			}
			
		} else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
