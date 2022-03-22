import java.sql.*;

class firstJDBC
{
	public static void main(String args[])
	{
		//Exception hand for any error:
		try
		{
			//Load Driver:
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Create Connection:

			//Create connection variables:
			String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
			String username = "root";
			String password = "root";

			//sql DriverManager Connection establishment
			Connection con = DriverManager.getConnection(url,username,password);


			//connection connected or not
			if (con.isClosed()) {
				System.out.println("Connection not connected...");
				
			}else
			{
				System.out.println("Connection Connected....");
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}