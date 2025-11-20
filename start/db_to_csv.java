/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author TEST
 */
public class db_to_csv {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        File fil = new File("E://free.csv");
        FileWriter fw = new FileWriter(fil);

//        fil.createNewFile();
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn", "root", "");
        Statement st = conn.createStatement();
        ResultSet show = st.executeQuery("select * from emp_tbl");
        while (show.next()) {
            int a = show.getInt("emp_id");
            String b = show.getString("emp_name");
            String c = show.getString("emp_design");
            String data = a+" "+b+" "+c+"\n";
            fw.write(data);
        }
        fw.close();
    }

}
