//JDBC CRUD Operation Project

import java.sql.*;
import java.util.Scanner;

class CRUD
{
	public static void main(String[] args) 
	{
		
		try{	

			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Enter username and passqord to Connection with mySQL
			String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";

			System.out.print("Enter Database Username : ");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();

			System.out.print("Enter Database password : ");
			String password = sc.nextLine();

			Connection con = DriverManager.getConnection(url,username,password);

			if (con.isClosed()) {
				System.out.println("Connection Closed");
			}else{
				System.out.println("Connection Connected...");			
			}


		}catch(Exception e){
			System.out.println(e);
		}

	}
}