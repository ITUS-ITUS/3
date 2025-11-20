
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class mr {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri","root","")) {
            System.out.println("conected");
            //procedure
            CallableStatement cstmt = conn.prepareCall("{CALL getName(?,?)}");
            cstmt.setInt(1,2);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.execute();
            String student_name = cstmt.getString(2);
            System.out.println("name is "+student_name);
                    
            
            CallableStatement fstmt = conn.prepareCall("{ ?=CALL getfuncName(?)}");
            fstmt.registerOutParameter(1,Types.VARCHAR);
            fstmt.setInt(2, 2);
            fstmt.execute();
            String Stude_name = fstmt.getString(1);
            System.out.println("name is:-"+Stude_name);
                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
