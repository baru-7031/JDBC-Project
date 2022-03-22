
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static Connection con;
    
    public static Connection getConnection() throws SQLException{
        
        try{
        
        if(con == null)
        {
            
            Class.forName("com.jdbc.cj.mysql.Driver");
            
            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1/student?useSSL=false","root","root");
            
            
            
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return con;
        
    }
    
}
