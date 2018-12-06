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
 * Servlet implementation class SubcategorySubmit
 */
@WebServlet("/SubcategorySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)


public class SubcategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategorySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Subcategory s=new Subcategory();
		PrintWriter out=response.getWriter();
		s.setCategoryid(Integer.parseInt(request.getParameter("catname")));
		s.setSubcategoryname(request.getParameter("scname"));
		s.setSubcategorydescrition(request.getParameter("scdescription"));
	    Part P1=request.getPart("scicon");
	    FileUpload F=new FileUpload(P1,"C:/Users/rahul/workspace/food/WebContent/subimages");
	    
	    s.setSubcategoryicon(F.filename);
	    boolean st=SubcategoryController.addNewSubcategory(s);
		out.println("<html>");
		if(st)
		{
			
			out.println("subcategory inserted <a href='SubcategoryView'>Add more category</a>");
			
		}
		  else
	       {out.println("Fail to Submit subcategory..<br><a href='SubcategoryView'>Add More category</a>");}
	       out.println("</html>");  
	       out.flush();    
		
		
	}

}
