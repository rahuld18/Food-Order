package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		out.println("<form action='UserSubmit' method='post' >");
		out.println("<table><caption><b><i>User  Registration</i></b></caption>");
		out.println("<tr> <td><b><i> Name:</i></b></td> <td><input type='text' name='name' placeholder='Enter FullName'></td> </tr>");
		
		
		out.println("<tr><td><b><i>Mobile Number:</b></i></td><td><input type='text' name='mno' placeholder='Enter mobile no'></td></tr>");
		out.println("<tr><td><b><i>Email:</b></i></td><td><input type='email' name='email'></td></tr>");
		out.println("<tr><td><b><i>Password:</b></i></td><td><input type='password' name='pass'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit'> <input type='reset'>");
		out.println("</form></html>");
		out.flush();
		
	}

}
