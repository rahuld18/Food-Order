package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.CategoryController;

import model.Category;

/**
 * Servlet implementation class CategorySubmit
 */
@WebServlet("/CategorySubmit")

@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class CategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	Category cat=new Category();
	PrintWriter out=response.getWriter();
	cat.setCategoryname(request.getParameter("cname"));
	  
    Part P1=request.getPart("cicon");
    FileUpload F=new FileUpload(P1,"C:/Users/rahul/workspace/food/WebContent/cimages");
    cat.setCategoryicon(F.filename);
    boolean st=CategoryController.addNewCategory(cat);
	out.println("<html>");
	if(st)
	{
		
		out.println("category inserted <a href='CategoryView'>Add more category</a>");
		
	}
	  else
       {out.println("Fail to Submit category..<br><a href='CategoryView'>Add More category</a>");}
       out.println("</html>");  
       out.flush();       

	
	
	}

}
