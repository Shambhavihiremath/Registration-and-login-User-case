package DAOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import Model.User;

public class dao {
	public  boolean registeruser(User user){
		System.out.println("Running dao:: registerUser");
		String url="jdbc:mysql://localhost:3306/user";
		String db_User="root";
		String Password="sham++";
		Connection con;
		PreparedStatement psmt;
		String sql="insert into users values(?,?,?,?,?)";

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_User,Password);
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, user.getId());
			psmt.setString(2, user.getUsername());
			psmt.setString(3, user.getPassword());
			psmt.setInt(4, user.getPhone());
			psmt.setString(5, user.getAddress());
			int result=psmt.executeUpdate();
			if(result>0)
				return true;
				
		

			}
		
			catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("Start of dao::registerUser");
			return false;
		}
	}
