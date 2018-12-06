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


import controller.SubcategoryController;
import model.Subcategory;

/**
 * Servlet implementation class FinalEditDeleteSubcategory
 */

@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)


@WebServlet("/FinalEditDeleteSubcategory")
public class FinalEditDeleteSubcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteSubcategory() {
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
			
			Subcategory s=new Subcategory();
			String btn=request.getParameter("btn");
			System.out.println(btn);
			if("Edit".equalsIgnoreCase(btn))
				{
				s.setSubcategoryid(Integer.parseInt(request.getParameter("sid")));

				s.setSubcategoryname(request.getParameter("sname"));

				s.setSubcategorydescrition(request.getParameter("sdescription"));
				SubcategoryController.editCategory(s);
				
				
				}
			 else if("Delete".equalsIgnoreCase(btn))
	    	 {  int sid=Integer.parseInt(request.getParameter("sid"));
	    	    SubcategoryController.deleteCategory(sid);
	    		 
	    		 }
	    	 else if("Edit picture".equalsIgnoreCase(btn))
	    	 {  int sid=Integer.parseInt(request.getParameter("sid"));
	    	 Part P=request.getPart("scicon");
	         FileUpload F=new FileUpload(P,"C:/Users/rahul/workspace/food/WebContent/subimages");
	      
	         SubcategoryController.editIcon(sid,F.filename);
	 		 
	 		 } 
			
			
			
			
			response.sendRedirect("SubcategoryList");
			
		}
		catch(Exception e)
		{
			out.println("FinalEditDelete() "+e);
			
			
		} out.print("</html>");
		
		
	}
		
		
		
	}


