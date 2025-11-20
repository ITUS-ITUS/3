/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TEST
 */
public class q7metadata {
        public static void displaytblmeta(String tableN) throws SQLException{
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","")){
                DatabaseMetaData dbMD = con.getMetaData();
                ResultSet columns = dbMD.getColumns(null, null, tableN, null);
                System.out.println("MetaData for Table :"+tableN);
                System.out.println("=============================================================");
                System.out.printf("%-20s %-15s %-10s %-8s %-8s %n","COLUMN_NAME","DATA_TYPE","TYPE_NAME","SIZE","NULLABLE");
                System.out.println("---------------------------");
                
                while(columns.next()){
                    String columnName = columns.getString("COLUMN_NAME");
                    int dataType = columns.getInt("DATA_TYPE");
                    String typeName = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    String nullable = columns.getString("IS_NULLABLE");
                    System.out.printf("%-20s %-15s %-10s %-8s %-8s %n",columnName,dataType,typeName,columnSize,nullable);
                }
            }catch(SQLException e){
                        e.printStackTrace();
                        }
        }
        public static void main(String[] args) throws SQLException {
        displaytblmeta("bank");
    }
    }


