
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_11 implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int salary; 
    
    public ques_11(){}
    
    public ques_11(int id , String name , int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getSalary(){
        return salary;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return " id:- "+id+" name :- "+name+" salary :- "+salary;
    }
    
    public static void main(String[] args) {
        ques_11 emp = new ques_11(1,"Mayuri",2500);
        System.out.println(emp);
        
        
        
        emp.setID(2);
        emp.setName("radhika");
        emp.setSalary(3000);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empl.ser"))){
            oos.writeObject(emp);
            
            System.out.println(emp);
            System.out.println("employee updated successfully!!!");
            System.out.println("employee object serialized successfully!!!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("empl.ser"))){
            ques_11 empl = (ques_11) oos.readObject();
            System.out.println("employee object deserialized successfully!!!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    
}
