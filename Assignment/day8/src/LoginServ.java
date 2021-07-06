
import mypack.LoginBean;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBean lb=new LoginBean();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		Boolean result=lb.check(username, password);
		if(result)
		{
			request.setAttribute("un", username);
			RequestDispatcher rd =request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd =request.getRequestDispatcher("Fail.jsp");
			rd.forward(request, response);
		}
	}

}
