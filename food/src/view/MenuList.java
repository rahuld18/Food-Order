package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CategoryController;

/**
 * Servlet implementation class MenuList
 */
@WebServlet("/MenuList")
public class MenuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuList() {
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
			
			ResultSet rs=CategoryController.displayAll();
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			
			out.println("<th><b>Choose Category</b></th>");
			do{
				out.println("<tr><td>"+rs.getString(2)+"</td> <td><img width =600  src=/food/cimages/"+rs.getString(3)+"></td><td><a href=MenuSubcategory?cid="+rs.getString(1)+">click here</a> </td></tr>");
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
					
					System.out.println("menu list "+e);	
				}
	}

}
