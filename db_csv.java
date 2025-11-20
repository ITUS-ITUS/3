
import com.mysql.cj.protocol.Resultset;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class db_csv {
    private static final String csv_file = "/Users/home/Desktop/demo.csv";
    public static void main(String[] args){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","");
            Statement stmt = conn.createStatement();
            FileWriter fw = new FileWriter(csv_file)){
            
            
            ResultSet rs = stmt.executeQuery("select * from home_new");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int size = rs.getInt("size");
                int price = rs.getInt("price");
                
                String data = id+" "+size+" "+price+"\n";
                
                fw.write(data);
                
            
            }
                    
            
        } catch (Exception e) {
        }
    }
    
}
