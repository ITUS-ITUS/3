
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_6 {
    public static void transfer_amount(int fromAccount, int toAccount , double amount) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","")){
            conn.setAutoCommit(false);
            try {
                PreparedStatement fstmt = conn.prepareStatement("update bank set amount = amount - ? where id = ?");
                fstmt.setDouble(1,amount);
                fstmt.setInt(2, fromAccount);
                int from_affected = fstmt.executeUpdate();
                System.out.println("wew"+from_affected);
                
                PreparedStatement tstmt = conn.prepareStatement("update bank set amount = amount + ? where id = ?");
                tstmt.setDouble(1,amount);
                tstmt.setInt(2, toAccount);
                int to_affected = tstmt.executeUpdate();
                System.out.println(to_affected);
                
                if(from_affected > 0 && to_affected > 0){
                    conn.commit();
                    System.out.println("transaction completed!!!");
                }else{
                    conn.rollback();
                    System.out.println("transaction failed!!!");
                }
                
            } catch (Exception e) {
                conn.rollback();
                System.out.println("transaction failed"+e.getMessage());
            }
            
        } catch (Exception e) {
                conn.rollback();
                System.out.println("transaction failed"+e.getMessage());
        }
        
    }
    
    
    public static void main(String[] args) {
        transfer_amount(2,3,20000);
    }
    
}
