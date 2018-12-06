package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.CategoryController;

import model.Category;

/**
 * Servlet implementation class FinalEditDeleteCategory
 */


@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

@WebServlet("/FinalEditDeleteCategory")
public class FinalEditDeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PrintWriter out=response.getWriter();
		out.println("<html>");
		try{
			Category c=new Category();
		
			String btn=request.getParameter("btn");
			if("Edit".equalsIgnoreCase(btn))
				{
				c.setCategoryid(Integer.parseInt(request.getParameter("cid")));
				c.setCategoryname(request.getParameter("cname"));
				CategoryController.editCategory(c);
				
				}
			 else if("Delete".equalsIgnoreCase(btn))
	    	 {  int cid=Integer.parseInt(request.getParameter("cid"));
	    	    CategoryController.deleteCategory(cid);
	    		 
	    		 }
	    	 else if("Edit picture".equalsIgnoreCase(btn))
	    	 {  int cid=Integer.parseInt(request.getParameter("cid"));
	    	 Part P=request.getPart("cicon");
	         FileUpload F=new FileUpload(P,"C:/Users/rahul/workspace/food/WebContent/cimages");
	      
	         CategoryController.editIcon(cid,F.filename);
	 		 
	 		 } 
			
			response.sendRedirect("CategoryList");
			
		}
		catch(Exception e)
		{
			out.println("FinalEditDelete() "+e);
			
			
		} out.print("</html>");
		
		
	}

}
