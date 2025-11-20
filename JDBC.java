
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class JDBC {
    
    public static void insertRecord(Connection conn , Scanner sc) {
       
       System.out.println("Enter id");
       int stud_id =  sc.nextInt();
       System.out.println("Enter name");
       sc.nextLine();
       String stud_name = sc.nextLine();
       
       String sql = "insert into pratice_jdbc(id,name) values(?,?)";
       
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, stud_id);
            pstmt.setString(2, stud_name);
            
            int rows = pstmt.executeUpdate();
            if (rows>0) {
                System.out.println("inserted!!!"+rows);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    public static void updateRecord(Connection conn , Scanner sc) {
       
       System.out.println("Enter id to update");
       int stud_id =  sc.nextInt();
       System.out.println("Enter updated name");
       sc.nextLine();
       String stud_name = sc.nextLine();
       
       String sql = "update pratice_jdbc set name = ? where id  = ?";
       
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, stud_name);
            pstmt.setInt(2, stud_id);
            
            
            int rows = pstmt.executeUpdate();
            if (rows>0) {
                System.out.println("updated!!!"+rows);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
     
    public static void deleteRecord(Connection conn , Scanner sc) {
       
       System.out.println("Enter id to delete");
       int stud_id =  sc.nextInt();
       
       
       String sql = "delete from pratice_jdbc where id = ?";
       
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, stud_id);
            
            
            int rows = pstmt.executeUpdate();
            if (rows>0) {
                System.out.println("deleted!!!"+rows);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    public static void displayRecord(Connection conn) {

       
       String sql = "Select * from pratice_jdbc";
       
       
        try (Statement smt = conn.createStatement()){
            ResultSet rs = smt.executeQuery(sql);
            System.out.println("student record!!");
            while(rs.next()){
                System.out.println("id:-"+rs.getInt("id")+"\nname:-"+rs.getString("name"));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","")){
            
            Scanner sc = new Scanner(System.in);
            
            while(true){
                System.out.println("1. insert");
                System.out.println("2. update");
                System.out.println("3. delete");
                System.out.println("4. display");
                System.out.println("5. exit");
                System.out.println("Enter a Choice");
                int choice = sc.nextInt();
                
                switch (choice) {
                    
                    case 1: insertRecord(conn,sc);break;
                    case 2: updateRecord(conn,sc);break;
                    case 3: deleteRecord(conn,sc);break;
                    case 4: displayRecord(conn);break;
                    case 5: System.out.println("Exit");return;
                          
                    default:
                        System.out.println("Enter valid choice!!");
                }
                
            }
            
            
        } catch (Exception e) {
        }
    }
    
}
