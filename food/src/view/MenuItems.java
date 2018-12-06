package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ItemController;


/**
 * Servlet implementation class MenuItems
 */
@WebServlet("/MenuItems")
public class MenuItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		try{
			PrintWriter out=response.getWriter();
			ResultSet rs=ItemController.displayBySubcategory(Integer.parseInt(request.getParameter("sid")));
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b> Choose Items and get Details:</b></th> </tr>");
			
			do{
			out.println("<tr>  <td><b>"+rs.getString(2)+" <br><br><a href='#'>Add to Cart</a><br><br></b></td>  <td><img width =600  src=/food/itemimages/"+rs.getString(5)+"></td><td><a href='DisplayMenuItemById?iid="+rs.getString(1)+"'>More Details about Product </td></tr>");
			}while(rs.next());

			out.println("</table>");
			}
			else
	 	   {
	 		   out.println("No Record Found..."); 
	 	   }
			out.println("</html>");
			}catch(Exception e)
			{
				
				System.out.println(" Menu Item list "+e);	
			}


	}

}
