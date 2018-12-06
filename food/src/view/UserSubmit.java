package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.UserController;
import model.User;



/**
 * Servlet implementation class UserSubmit
 */
@WebServlet("/UserSubmit")
public class UserSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		User U=new User();
		U.setName(request.getParameter("name"));
		U.setMno(request.getParameter("mno"));
		U.setEmail(request.getParameter("email"));
		U.setPassword(request.getParameter("pass"));
		
		 boolean st=UserController.addNewUser(U);
			out.println("<html>");
			if(st)
			{
				
				out.println("User inserted <a href='UserRegister'>Add more category</a>");
				
			}
			  else
		       {out.println("Fail to Submit user..<br><a href='UserView'>Add More category</a>");}
		       out.println("</html>");  
		       out.flush();       

	}

}
