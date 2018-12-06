package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		out.println("<form action='UserCheckLogin' method='post' >");
		out.println("<table><caption><b>User Login</b></caption>");
		out.println("<tr><td><b>User Id/Email id: </b></td><br><td><input type='text' name='uid'></td></tr>");
		out.println("<tr><td><b>Password: </b></td><br><td><input type='password' name='pwd'></td></tr>");
		
		out.println("</table>");
		out.println("<input type=submit value='Log In'>");
		out.println("</html>");
		out.flush();
		
		

	
	}

}
