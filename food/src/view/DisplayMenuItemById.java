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
 * Servlet implementation class DisplayMenuItemById
 */
@WebServlet("/DisplayMenuItemById")
public class DisplayMenuItemById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMenuItemById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		 try{
			    ResultSet rs=ItemController.displayById(Integer.parseInt(request.getParameter("iid")));
			    	 if(rs.next())
			    	 {
			    		 out.println("<html>");
			    			
			    		 out.println("<table>");

			    		 out.println("<tr><td><table>");
			    		 
			    		 
			    		 out.println("<b><br><br>Item Name:</b> "+rs.getString(2));

			    		 out.println("<br><br><br><b>Price:</b> "+rs.getString(3));

			    		 out.println("<br><br><br><b>Description:</b> "+rs.getString(4));
			    		 
			    			
			    		 out.println("</table>");

			    		 out.println("</td><td><table>");
			    		 
			    		 out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=/food/itemimages/"+rs.getString(7)+"   height=400 /><br><br>");

			    		 out.println("</td></table>");
			    		 

			    		 out.println("<br><br><a href='AddToCart?iid="+rs.getString(1)+"'>Add to cart</a>");
			    		 
			    		 out.println("</html>");
			    			
			    			
			    		}

			    				    	 else
			    				    	 {out.print("Not Found....");
			    				    		 }

			    	}catch(Exception e)
			    			  {
			    		 System.out.println("display menu "+e);
			    		
			    			  }
	}

}
