package jdbc;
import java.sql.*;

import java.io.*;
public class Storeimage1 {
	public static void main(String[] args){
		
		String filePath="C:\\abhi13\\pexels-photo-1198802.jpeg";
		
		try 
		{
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306 /test","root","12345");
		
		
		String sql = "INSERT INTO person(name,image) values(?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "abhishek");
		InputStream inputStream= new FileInputStream(new File(filePath));
		statement.setBlob(2,inputStream);
		int row = statement.executeUpdate();
		if(row > 0){
		System.out.println("a contact was inserted with photo image.");
		}
		conn.close();
		}
		catch(SQLException ex){
		ex.printStackTrace();
		}
		catch(IOException ex){
		ex.printStackTrace();
		 }
		}

}
