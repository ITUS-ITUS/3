
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_7 {
    public static void getmetadata(String tableN) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","")) {
            DatabaseMetaData dbmt = conn.getMetaData();
            ResultSet columns =  dbmt.getColumns(null, null, tableN, null);
            
            System.out.println("metadata for table :"+tableN);
            System.out.println("===============");
            System.out.printf("%-20s %-16s %-12s %-8s %-8s %n", "COLUMN_NAME","DATA_TYPE","TYPE_NAME","SIZE" ,"NULLABLE");
            System.out.println("===============");
            
            while (columns.next()){
                String columnName = columns.getString("COLUMN_NAME");
                int dataType = columns.getInt("DATA_TYPE");
                String typeName = columns.getString("TYPE_NAME");
                int size = columns.getInt("COLUMN_SIZE");
                String nullable = columns.getString("IS_NULLABLE");
                System.out.printf("%-20s %-16s %-12s %-8s %-4s %n", columnName,dataType,typeName,size ,nullable);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public static void main(String[] args) {
        getmetadata("bank");
    }
    
}
