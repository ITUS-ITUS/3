/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;


import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//How to save an object to a file and then read it back in Java using serialization."

public class q11serialization implements Serializable{
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;
        private double salary;
        
        public q11serialization() {}
        
        public q11serialization(int id, String nam, double salary){
            this.id = id;
            this.name = nam;
            this.salary = salary;
        }
        
        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id = id;
        }
        
        
        public String getNam(){
            return name;
        }
        
        public void setNam(String nam){
            this.name = nam;
        }
        
        
        public double getSalary(){
            return salary;
        }
        
        public void setSalary(double salary){
            this.salary = salary;
        }
        
        @Override
        public String toString(){
            return "Employee(id :"+id+",name :"+name+" ,salary :"+salary+")";
        }
        
        public static void main(String[] args) throws FileNotFoundException, IOException {
            
            q11serialization emp = new q11serialization(102,"Mayuri",90000.0);
            
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getNam());
            System.out.println("Salary: " + emp.getSalary());

            // Using setters
            emp.setSalary(95000.0);
            emp.setNam("Mayuri Patel");

            System.out.println("Updated Employee: " + emp);
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empl.ser"))){
                oos.writeObject(emp);
                System.out.println("Employee Object Serialized Successfully");
            }
            
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empl.ser"))){
                q11serialization empl = (q11serialization) ois.readObject();
                System.out.println("Deserialization Employee : "+empl);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();           
            }
        }
        
        
}
