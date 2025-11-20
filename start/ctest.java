/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import sun.security.util.Length;

/**
 *
 * @author TEST
 */
public class ctest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String link = "jdbc:mysql://localhost:3306/learn";
        Connection kon = DriverManager.getConnection(link, "root","");
        Scanner sc = new Scanner(System.in);
        int ys = 0;
        do{
           System.out.println("1. Insert");
           System.out.println("2. Update");
           System.out.println("3. Delete");
           System.out.println("4. Show");
           System.out.println("Enter Your choice :");
           ys = sc.nextInt();
           switch(ys){
               case 1:System.out.println("Insert");
                    String in = "insert into emp_tbl(emp_id,emp_name,emp_design) values(?,?,?)";
                    PreparedStatement ps = kon.prepareStatement(in);
                    System.out.println("Insert Id :");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    ps.setInt(1, eid);
                    System.out.println("Insert Name :");
                    String nam = sc.nextLine();
                    ps.setString(2,nam);
                    System.out.println("Insert Designation :");
                    String desi = sc.nextLine();
                    ps.setString(3,desi);
                    ps.executeUpdate();
                    break;
               case 2:System.out.println("Update");
                    System.out.println("Enter Id :");
                    String upid = sc.next();
                    System.out.println("Enter Name :");
                    sc.nextLine();
                    String upnam = sc.nextLine();
                    System.out.println("Enter Designation :");
                    String updesi = sc.nextLine();
                    String up = "update emp_tbl set emp_name = '" + upnam +"' , emp_design = '" + updesi + "' where emp_id = " + upid;
                    ps = kon.prepareStatement(up);
                    ps.executeUpdate();
                    break;
               case 3:System.out.println("Delete");
                    System.out.println("Enter Id :");
                    int did = sc.nextInt();
                    String del = "delete from emp_tbl where emp_id = " + did;
                    ps = kon.prepareStatement(del);
                    ps.executeUpdate();
                    break;
               case 4:System.out.println("Show");
                    Statement st = kon.createStatement();
                    ResultSet show = st.executeQuery("select * from emp_tbl");
                    while(show.next()){
                        System.out.print(show.getInt("emp_id") + " | ");
                        System.out.print(show.getString("emp_name") + " | ");
                        System.out.println(show.getString("emp_design"));
                    }
                    
               default:System.out.println("0 to exit..");
//               exit();
           }
       }while(ys<5);
        
    }


}
