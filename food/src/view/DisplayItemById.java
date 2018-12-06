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
 * Servlet implementation class DisplayItemById
 */
@WebServlet("/DisplayItemById")
public class DisplayItemById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayItemById() {
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
			    ResultSet rs=ItemController.displayById(Integer.parseInt(request.getParameter("cid")));
			    	 if(rs.next())
			    	 {
		
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/categorysubcategory.js'></script>");
		out.println("<html>");
		
		
		out.println("<form action='ItemSubmit' method='post' enctype='multipart/form-data' ><table>");
		out.println(" <tr><td><table><caption> <b>Item Entry</b></caption><br><br>");

		
out.println("<tr><td> <b><i>Category:["+rs.getString(5)+"] </b></i></td>  <td> <select name='pcategory' id='pcategory'> </select> </td></tr>");
		

		out.println("<tr><td> <b><i>Sub Category: ["+rs.getString(6)+"]</b></i></td>  <td> <select name='psubcategory' id='psubcategory'> <option>-subcategory-</option></select> </td></tr>");
		
		out.println("<tr><td> <b><i>Item Name: </b></i></td>  <td> <input type='text' name='name' value="+rs.getString(2)+"> </td></tr>");

		out.println("<tr><td> <b><i>Price: </b></i></td>  <td> <input type='text' name='price' value="+rs.getString(3)+"> </td></tr>");
		out.println("<tr><td> <b><i>Description: </b></i></td>  <td> <textarea rows=3 cols=45 name='scdescription' value="+rs.getString(4)+"></textarea> </td></tr>");

		//out.println("<tr><td> <b><i>Photograph : </b></i></td>  <td> <input type='file' name='ph'> </td></tr>");
	
		
		
		
		
		out.println("</table>");
		out.println("<br><br><input type='submit' value='Edit'  name='btn'> <input type='submit' value='Delete'  name='btn'> ");
		
		out.println("</td> <td>");
		out.println("<img src=/food/itemimages/"+rs.getString(7)+"  width=200 height=200 /><br><br>");
		out.println("<input type='file' name='cicon'><br><br>");
		out.println("<input type='submit' value='Edit Picture' name='btn'></td></tr></table>");
		
		out.println("</form>");
		out.println("</html>");

		
		
	}

			    	 else
			    	 {out.print("Not Found....");
			    		 }

}catch(Exception e)
		  {
	 System.out.println("display category "+e);
	
		  }
			}

}
