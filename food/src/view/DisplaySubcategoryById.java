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
 * Servlet implementation class DisplaySubcategoryById
 */
@WebServlet("/DisplaySubcategoryById")
public class DisplaySubcategoryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySubcategoryById() {
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
			    ResultSet rs=SubcategoryController.displayById(Integer.parseInt(request.getParameter("sid")));
			    if(rs.next())
		    	 {
	
	out.println("<html>");
	out.println("<form action='FinalEditDeleteSubcategory' method='post' enctype='multipart/form-data' >");
	out.println("<table><tr><td>");
	out.println(" <table><caption> <b>SubCategory Entry</b></caption><br><br>");

	out.println("<tr><td> <b><i>SubCategory ID : </b></i></td>  <td> <input type='text' name='sid' value='"+rs.getString(1)+"'> </td></tr>");

	out.println("<tr><td> <b><i>SubCategory Name: </b></i></td>  <td> <input type='text' name='sname' value='"+rs.getString(2)+"'> </td></tr>");
	out.println("<tr><td> <b><i>SubCategory Description: </b></i></td>  <td> <input type='text' name='sdescription' value='"+rs.getString(3)+"'> </td></tr>");
    

	out.println("</table>");
	out.println("<br><br><input type='submit' value='Edit' name='btn'> <input type='submit' value='Delete' name='btn'> ");
	
	out.println("</td> <td>");
	out.println("<img src=/MM/eimages/"+rs.getString(4)+"  width=200 height=200 ><br><br>");
	out.println("<input type='file' name='scicon'><br><br>");
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
