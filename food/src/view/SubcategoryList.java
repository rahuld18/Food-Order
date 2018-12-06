package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SubcategoryController;

/**
 * Servlet implementation class SubcategoryList
 */
@WebServlet("/SubcategoryList")
public class SubcategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
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
	*/	try{
			PrintWriter out=response.getWriter();
			
			ResultSet rs=SubcategoryController.displayAll();
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b>SubCategory id:</b></th> <th><b>subCategory name</b></th> <th><b>subCategory Description</b></th> <th><b>SubCategory Icon</b> <th><b>Update</b></th> </tr>");
			
			do{
			out.println("<tr> <td><b>"+rs.getString(1)+"</b></td> <td><b>"+rs.getString(3)+"</b></td> <td><b>"+rs.getString(4)+"</b></td> </td> <td><img width =30 height=30 src=/food/subimages/"+rs.getString(5)+"></td><td><a href=DisplaySubcategoryById?sid="+rs.getString(1)+">Edit/delete</a> </td></tr>");
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
				
				System.out.println("category list "+e);	
			}
	}

}
