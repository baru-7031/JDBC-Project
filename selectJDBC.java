//Select Query : 
//Resultset is not working now : 
import java.sql.*;
import java.io.*;

class selectJDBC
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




			if (con.isClosed()) {

				System.out.println("Connection Closed");
				
			}
			else
			{
				System.out.println("Connection Connected...\n\n");


				String query = "select * from students";

				Statement stmt = con.createStatement();

				ResultSet set = stmt.executeQuery(query);

				while(set.next())
				{
					int id = set.getInt(1);
					String name = set.getString(2);
					String city = set.getString(3);

					System.out.println(id + " : " + name + " : " + city);
				}

			

				con.close();

			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}