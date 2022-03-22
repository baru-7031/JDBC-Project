//PreparedStatement Insert : 

import java.sql.*;

class preparedJDBC
{
	public static void main(String[] args) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
			String username = "root";
			String password = "root";

			Connection con=DriverManager.getConnection(url,username,password);

			if (con.isClosed()) {
				System.out.println("Connection Closed");
			}
			else{

				System.out.println("Connection Connected...");

				String q = "insert into students(studentName,studentCity) values (?,?)";

				PreparedStatement pstmt = con.prepareStatement(q);

				pstmt.setString(1, "Danish");
				pstmt.setString(2, "Kharagpur");

				pstmt.executeUpdate();

				System.out.println("inseted...");

				con.close();
			}

		


		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}