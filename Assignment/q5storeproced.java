/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author TEST
 */
public class q5storeproced {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mayuri","root","")){
            CallableStatement procst = con.prepareCall("{CALL GetEmployeeCount(?,?)}");
            procst.setInt(1, 4); // IN parameter stud_id (for example id=1)
            procst.registerOutParameter(2, Types.VARCHAR); 
            procst.execute();
            String count = procst.getString(2);
            System.out.println("Employee Count :"+count);
            
            CallableStatement funcst = con.prepareCall("{?= CALL CaculateBonus(?)}");
            funcst.registerOutParameter(1, Types.VARCHAR);
            funcst.setInt(2,4);
            funcst.execute();
            String studentName = funcst.getString(1);
            System.out.println("Student Name: " + studentName);
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
