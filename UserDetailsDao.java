package DAOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.User;




public class UserDetailsDao {
	public ResultSet getDetails() {
		//ArrayList<User> detailset=new ArrayList<User>();
		
		String url="jdbc:mysql://localhost:3306/user";
		String db_User="root";
		String db_Password="sham++";
		PreparedStatement ptmt;
		Connection con;
		String sql="select * from users";
		
try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_User,db_Password);
			ptmt=con.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			return rs;
			
}catch(Exception e){
			e.printStackTrace();
		
	}
		return null;


	
	
	}

}