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
 * Servlet implementation class AddHouseServlet
 */
@WebServlet("/addHouseServlet")
public class AddHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddHouseServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = request.getParameter("address");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));
		LocalDate marketDate = LocalDate.parse(request.getParameter("marketDate"));
		
		House ri = new House(address, zipcode, sellingPrice, marketDate);
		HouseHelper doa = new HouseHelper();
		doa.insertHouse(ri);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
