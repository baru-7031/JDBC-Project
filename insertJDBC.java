import java.sql.*;


class insertJDBC
{
	public static void main(String[] args) 
	{
		try
		{
		//Load Driver:
		Class.forName("com.mysql.cj.jdbc.Driver");


		//Create Connection:
		String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
		String username = "root";
		String password = "root";

		//get Connection
		Connection con = DriverManager.getConnection(url,username,password);

		if (con.isClosed()) 
		{
			System.out.println("Connection Close");
		}else
		{
			System.out.println("Connection Created");
		}

		//q variable to store QUERY
		String q = "Create table students(studentId int(20) primary key auto_increment, studentName varchar(200) not null, studentCity varchar(400))";

		//Create Statement it can help to update QUERY
		Statement stmt = con.createStatement();

		stmt.executeUpdate(q);

		System.out.println("Table Created in database");

		con.close();



		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}