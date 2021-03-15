package UserController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAOO.UserDetailsDao;
import Model.User;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserDetailsDao dao=new UserDetailsDao();
	ResultSet rs=dao.getDetails();
	User user;
	ArrayList<User> array=new ArrayList<User>();
	try{
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			array.add(user);
			
		}
		request.setAttribute("userlist",array);
		response.sendRedirect("admin.jsp");
		
	}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
}
		
		
		
		
		
		
		
		/*UserDetailsDao dao=new UserDetailsDao();
		ResultSet rs=dao.getDetails();
		User user;
		ArrayList<User> array=new ArrayList<User>();
		try{
			while(rs.next()){
				System.out.println(rs.getInt(1)+""+rs.getString(2));
				user=new User();
				array.add(user);
				
			}
			
			
			request.setAttribute("user",array);
			response.sendRedirect("admin.jsp");
			
		}catch(SQLException e){
			e.printStackTrace();
		}*/
		
		
		
		
		
		
	


