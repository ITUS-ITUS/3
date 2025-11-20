
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_1 {
    public static void main(String[] args) {
        String filepath = "/Users/home/Downloads/java/data/iris.arff";
        int linecount = 0;
        int wordcount = 0;
        int charactercount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=br.readLine())!=null){
                linecount++;
                charactercount += line.length();
                String[] words = line.trim().split("\\s+");
                
                if(!line.trim().isEmpty()){
                    wordcount += words.length;
                }
            }
            
            System.out.println("line count"+linecount);
            System.out.println("word count"+wordcount);
            System.out.println("character count"+charactercount);
            
        } catch (Exception e) {
        }
    }
    
}
