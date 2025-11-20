/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author TEST
 */
public class wordco {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        File fil = new File("/Users/home/Downloads/java/data/iris.arff");
//        fil.createNewFile();
        FileReader fr = new FileReader(fil);
        Scanner sc = new Scanner(fil);
        Class.forName("com.mysql.cj.jdbc.Driver");
        int lc = 0;
        while(sc.hasNext()){
            Scanner sc2 = new Scanner(sc.nextLine());
            sc2.useDelimiter(" ");
            lc+=1;            
        }
        System.out.println("No of Lines :"+lc);
    }
}
