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
 * Servlet implementation class ItemList
 */
@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemList() {
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
			
			ResultSet rs=ItemController.displayAll();
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b>Item id:</b></th> <th><b>Item name</b></th> <th><b>description</b></th><th><b>price</b></th><th><b>category and<br> subcategory</b></th> <th><b>Photograph</b></th> <th><b>Update</b></th> </tr>");
			
			do{
			out.println("<tr> <td><b>"+rs.getString(1)+"</b></td> <td><b>"+rs.getString(2)+"</b></td><td><b>"+rs.getString(3)+"</b></td><td><b>"+rs.getString(4)+"</b></td><td><b>category="+rs.getString(6)+"<br>subcategory="+rs.getString(7)+"</b></td> </td> <td><img width =30 height=30 src=/food/itemimages/"+rs.getString(5)+"></td><td><a href=DisplayItemById?cid="+rs.getString(1)+">Edit/delete</a> </td></tr>");
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
				
				System.out.println("Issue list "+e);	
			}	
	
	}

}
