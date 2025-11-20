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

/**
 *
 * @author TEST
 */
public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/learn";
        Connection conn = DriverManager.getConnection(url, "root", "");
        Scanner sc = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("Enter Choice :");
            System.out.println("1. Insert");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    String in = "insert into book_info(boo_id,boo_title,boo_price) values(?,?,?)";
                    PreparedStatement pr = conn.prepareStatement(in);
                    System.out.println("Insert Id :");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    pr.setInt(1, bid);
                    System.out.println("Insert Title :");
                    String bt = sc.nextLine();
                    pr.setString(2, bt);
                    System.out.println("Insert Price :");
                    int bp = sc.nextInt();
                    pr.setInt(3, bp);
                    pr.executeUpdate();
                    break;
                case 2:
//                Lets view
                    Statement st = conn.createStatement();
                    ResultSet show = st.executeQuery("select * from book_info ");
                    while (show.next()) {
                        System.out.print(show.getInt("boo_id") + "  ");
                        System.out.print(show.getString("boo_title") + " ");
                        System.out.println(show.getString("boo_price"));
                    }
                    break;
                case 3:
                    System.out.println("Enter Id :");
                    int id = sc.nextInt();
                    System.out.println("Enter Title :");
                    sc.nextLine();
                    String boot = sc.nextLine();
                    String up = "update book_info set boo_title = '" + boot + "' where boo_id = " + id;
                    System.out.println(up);
                    pr = conn.prepareStatement(up);
                    pr.executeUpdate();
                    break;
                case 4:
                    String de = "delete from book_info where boo_id = ?";
                    pr = conn.prepareStatement(de);
                    System.out.println("Insert Id :");
                    bid = sc.nextInt();
                    pr.setInt(1, bid);
                    pr.executeUpdate();
                default:
                    exit();
            }
        } while (select<5);
    }
}
