package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;

/**
 * Servlet implementation class HouseNavigationServlet
 */
@WebServlet("/houseNavigationServlet")
public class HouseNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HouseHelper doa = new HouseHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllHousesServlet";
		
		
		if(act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("houseId"));
				House houseToDelete = doa.searchForHouseById(tempId);
				doa.removeHouse(houseToDelete);
			} catch (NumberFormatException e) {
				System.out.println("forgot to select an item");
			}
			
		} else if(act.equals("edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("houseId"));
				House houseToEdit = doa.searchForHouseById(tempId);
				request.setAttribute("houseToEdit", houseToEdit);
				path = "/edit-house.jsp";
			} catch (NumberFormatException e) {
				System.out.println("forgot to select an item");
			}
			
		} else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
