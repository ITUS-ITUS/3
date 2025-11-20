/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author TEST
 */
public class q6commitrollback {
    public static void transferAmount(int fromAccount,int toAccount,double amount) throws SQLException {
        try(Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""))        {
            con.setAutoCommit(false);
            try{
                PreparedStatement dst = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_id = ?");
                dst.setDouble(1, amount);
                dst.setInt(2, fromAccount);
                int drows = dst.executeUpdate();
                
                PreparedStatement cst = con.prepareStatement("UPDATE accounts SET balance = balance + ? where account_id = ?");
                cst.setDouble(1, amount);
                cst.setInt(2, toAccount);
                int crows =cst.executeUpdate();
                
                if (drows > 0 && crows > 0){
                    con.commit();
                    System.out.println("Transaction successfull");
                }else{
                    con.rollback();
                    System.out.println("Transaction Failed - rolled back ");
                }
            }catch(SQLException e){
                con.rollback();
                System.out.println("Transaction rolled back due to error :"+e.getMessage());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        transferAmount(1001,1002,500);
    }
}
