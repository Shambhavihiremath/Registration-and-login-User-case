package DAOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class loginDAO {
public  boolean verifyUserCredential(String username,String password) {
	
	String url="jdbc:mysql://localhost:3306/user";
	String db_User="root";
	String db_password="sham++";
	Connection con;
	PreparedStatement psmt;
	String sql="select * from users where username=? and password=?";
	

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,db_User,db_password);
		psmt=con.prepareStatement(sql);
		psmt.setString(1,username);
		psmt.setString(2, password);
		ResultSet rs=psmt.executeQuery();
		if(rs.next()){
			return true;
		}
		} catch(Exception e){
		e.printStackTrace();
	}
	return false;
}
}
