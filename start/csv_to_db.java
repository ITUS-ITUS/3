/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author TEST
 */
public class csv_to_db {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        File fil = new File("E://free.csv");
//        fil.createNewFile();
        FileReader fr = new FileReader(fil);
        Scanner sc = new Scanner(fil);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String link = "jdbc:mysql://localhost:3306/learn";
        Connection conn = DriverManager.    .getConnection(link,"root","");
        String in = "insert into emp_tbl values(?,?,?)"; 
        PreparedStatement pr = conn.prepareStatement(in);
        while(sc.hasNext()){
            Scanner sc2 = new Scanner(sc.nextLine());
            sc2.useDelimiter(";");
            int id = sc2.nextInt();
            String name = sc2.next();
            String design = sc2.next();
            System.out.println("id:"+id+"Name"+name+"design"+design);
            pr.setInt(1, id);
            pr.setString(2,name);
            pr.setString(3, design);
            pr.executeUpdate(); 
        }
    }
}
