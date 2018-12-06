package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/CategoryView")
public class CategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<form action='CategorySubmit' method='post' enctype='multipart/form-data' >");
		out.println(" <table><caption> <b>Category Entry</b></caption><br><br>");

	
		out.println("<tr><td> <b><i>Category Name: </b></i></td>  <td> <input type='text' name='cname'> </td></tr>");

		out.println("<tr><td> <b><i>Icon : </b></i></td>  <td> <input type='file' name='cicon'> </td></tr>");

		out.println("</table>");
		out.println("<br><br> <input type='submit'> <input type='reset' > ");
		
		
		out.println("</form>");
		out.println("</html>");

	}

}
