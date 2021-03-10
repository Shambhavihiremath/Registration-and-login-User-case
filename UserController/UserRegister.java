package UserController;

import java.io.IOException;

import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOO.dao;
import Model.User;


/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao daooo;
		String 	username=request.getParameter("username");
		String password=request.getParameter("password");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String Address=request.getParameter("address");
		
		Random random=new Random();//for creating random id
		int userId=random.nextInt(999);
		

		User newUser=new User(userId,username,password,phone,Address);//properties given to new user
		daooo=new dao();
		boolean result= daooo.registeruser(newUser);
		
	
		if(result){
			System.out.println("success");
		response.sendRedirect("welcome.jsp");
		}
			else{
				System.out.println("error");
		response.sendRedirect("error.jsp");
		}
	}

	
	}

	


