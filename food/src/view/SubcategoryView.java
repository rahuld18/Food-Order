package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubcategoryView
 */
@WebServlet("/SubcategoryView")
public class SubcategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
/*HttpSession ses=request.getSession();
    	
    	try{
		@SuppressWarnings("deprecation")
		String s=(String)ses.getValue("LTIME").toString();
    	}catch(Exception e)
    	{
    		response.sendRedirect("AdminLogin");
    	}
*/
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/subcategory.js'></script>");
		out.println("<html>");
		out.println("<form action='SubcategorySubmit' method='post' enctype='multipart/form-data' >");
		out.println(" <table><caption> <b>Sub Category Entry</b></caption><br><br>");

	
		out.println("<tr><td> <b><i>Category Name: </b></i></td>  <td> <select name='catname' id='catname'></select> </td></tr>");
		out.println("<tr><td> <b><i>SubCategory Name: </b></i></td>  <td> <input type='text' name='scname'> </td></tr>");
		
		out.println("<tr><td> <b><i>Description: </b></i></td>  <td> <textarea rows=3 cols=45 name='scdescription'></textarea> </td></tr>");

		out.println("<tr><td> <b><i>Icon : </b></i></td>  <td> <input type='file' name='scicon'> </td></tr>");

		out.println("</table>");
		out.println("<br><br> <input type='submit'> <input type='reset' > ");
		
		
		out.println("</form>");
		out.println("</html>");
	

	}

}
