package UserController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOO.loginDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     	String username=request.getParameter("username");
		String password=request.getParameter("password");
		/*if(username.equals("rohan")&& password.equals("abc")){
			HttpSession session=request.getSession();
			session.setAttribute("user", username);//key value pair
			response.sendRedirect("welcome.jsp");
		}
		else{
			response.sendRedirect("login.jsp");
		}*/
	    loginDAO dao=new loginDAO();

		boolean result=dao.verifyUserCredential(username, password);
		if(result){
		
			HttpSession session=request.getSession();
			session.setAttribute("user", username);//key value pair
			response.sendRedirect("welcome.jsp");
			
		}
		else{
			response.sendRedirect("login.jsp");
			
		}
	}



}
