
import java.io.BufferedReader;
import java.io.FileReader;
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
public class csv_to_db {

    private static final String csvfile = "/Users/home/Downloads/java/data/house.csv";

    public static void main(String[] args) {

        String line;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayuri", "root", ""); BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

            System.out.println("connected successfully!!!");
            
            String sql = "insert into home_new(id,size, price) values(?,?,?)";
            PreparedStatement pr = conn.prepareStatement(sql);
            
            br.readLine();
            
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                
                int id =  Integer.parseInt(data[0].trim());
                int size =  Integer.parseInt(data[1].trim());
                int price =  Integer.parseInt(data[2].trim());
                
                pr.setInt(1, id);
                pr.setInt(2, size);
                pr.setInt(3, price);
                
                pr.executeUpdate();
            }
            System.out.println("csv successfully inserted into db");

        } catch (Exception e) {
        }

    }

}
