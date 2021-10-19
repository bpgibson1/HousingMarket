package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;

/**
 * Servlet implementation class EditHouseServlet
 */
@WebServlet("/editHouseServlet")
public class EditHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HouseHelper doa = new HouseHelper();
		
		String address = request.getParameter("address");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));
		LocalDate marketDate = LocalDate.parse(request.getParameter("marketDate"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		House houseToUpdate = doa.searchForHouseById(tempId);
		houseToUpdate.setAddress(address);
		houseToUpdate.setZipcode(zipcode);
		houseToUpdate.setSellingPrice(sellingPrice);
		houseToUpdate.setMarketDate(marketDate);
		
		doa.updateHouse(houseToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllHousesServlet").forward(request, response);
	}

}
