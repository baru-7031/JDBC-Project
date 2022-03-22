//PreparedStatement by User input : 
import java.sql.*;
import java.io.*;

class dynamicInsertJDBC 
{
	public static void main(String[] args) 
	{
		try
		{
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//sql Connection
			String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
			String username = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url,username,password);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



			if (con.isClosed()) {

				System.out.println("Connection Closed");
				
			}
			else
			{
				System.out.println("Connection Connected...\n\n");


				String q = "insert into students(studentName,studentCity) values (?,?)";

				System.out.print("Enter Student name : ");
				String name = br.readLine();
				System.out.print("Enter Student city name : ");
				String city = br.readLine();


				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setString(1, name);
				pstmt.setString(2, city);

				pstmt.executeUpdate();

				System.out.println("inserted...");

				con.close();

			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}