package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubcategoryController;

/**
 * Servlet implementation class MenuSubcategory
 */
@WebServlet("/MenuSubcategory")
public class MenuSubcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSubcategory() {
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
			
			ResultSet rs=SubcategoryController.displayByCategory(Integer.parseInt(request.getParameter("cid")));
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b> Choose SubCategory:</b></th> </tr>");
			
			do{
			out.println("<tr>  <td><b>"+rs.getString(3)+"</b></td>  <td><img width =600  src=/food/subimages/"+rs.getString(5)+"></td><td><a href=MenuItems?sid="+rs.getString(1)+">Click Here</a> </td></tr>");
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
				
				System.out.println(" Menu subcategory list "+e);	
			}

	
	}

}
