package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemView
 */
@WebServlet("/ItemView")
public class ItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/categorysubcategory.js'></script>");
		out.println("<html>");
		
		
		out.println("<form action='ItemSubmit' method='post' enctype='multipart/form-data' >");
		out.println(" <table><caption> <b>Item Entry</b></caption><br><br>");

		
out.println("<tr><td> <b><i>Category: </b></i></td>  <td> <select name='pcategory' id='pcategory'> </select> </td></tr>");
		

		out.println("<tr><td> <b><i>Sub Category: </b></i></td>  <td> <select name='psubcategory' id='psubcategory'> <option>-subcategory-</option></select> </td></tr>");
		
		out.println("<tr><td> <b><i>Item Name: </b></i></td>  <td> <input type='text' name='name'> </td></tr>");

		out.println("<tr><td> <b><i>Price: </b></i></td>  <td> <input type='text' name='price'> </td></tr>");
		out.println("<tr><td> <b><i>Description: </b></i></td>  <td> <textarea rows=3 cols=45 name='scdescription'></textarea> </td></tr>");

		out.println("<tr><td> <b><i>Photograph : </b></i></td>  <td> <input type='file' name='ph'> </td></tr>");
		out.println("</table>");
		out.println("<br><br> <input type='submit'> <input type='reset' > ");
		
		
		out.println("</form>");
		out.println("</html>");
	}

	
}
