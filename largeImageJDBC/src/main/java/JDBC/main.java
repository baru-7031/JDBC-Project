
package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;

public class main {
    public static void main(String[] args) {
        
        try{
            
            Connection c = ConnectionProvider.getConnection();
            
            String q= "insert into image(pic) values (?)";
            PreparedStatement pstmt = c.prepareStatement(q);
            
            JFileChooser jfc = new JFileChooser();
            
            jfc.showOpenDialog(null);
            
            jfc.getSelectedFile();
            
            FileInputStream fis = new FileInputStream();
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
