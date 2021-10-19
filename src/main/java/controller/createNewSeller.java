package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import model.Seller;

/**
 * Servlet implementation class createNewSeller
 */
@WebServlet("/createNewSeller")
public class createNewSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewSeller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HouseHelper rh = new HouseHelper();
		String first = request.getParameter("sellerFirstName");
		String last = request.getParameter("sellerLastName");
		
		String[] selectedHouses = request.getParameterValues("allHousesToAdd");
		List<House> selectedHousesInList = new ArrayList<House>();
		
		if(selectedHouses != null && selectedHouses.length > 0) {
			for(int i = 0; i < selectedHouses.length; i++) {
				House c = rh.searchForHouseById(Integer.parseInt(selectedHouses[i]));
				selectedHousesInList.add(c);
			}
		}
		
		Seller cb = new Seller(first, last);
		cb.setListOfHouses(selectedHousesInList);
		
		SellerHelper cbh = new SellerHelper();
		cbh.insertSeller(cb);
		
		System.out.println("Success! Cook Book added");
		System.out.println(cb.toString());
		
		getServletContext().getRequestDispatcher("/viewSellersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
