/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.*;

/**
 *
 * @author TEST
 */
public class q12properandfiles implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String nam;
    private String address;
    private double grade;

    public q12properandfiles() {}

    public q12properandfiles(int id, String nam, String address, double grade) {
        this.id = id;
        this.nam = nam;
        this.address = address;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

//    private void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.defaultWriteObject();
//        System.out.println("Grade Property Excluded from serialization");
//    }
//
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        ois.defaultReadObject();
//        this.grade = 0.0;
//        System.out.println("Grade Property Excluded from serialization");
//    }

    @Override
    public String toString() {
        return "Student(id :" + id + ",name :" + nam + ",address :" + address + ",grade :" + grade + ")";
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        q12properandfiles st = new q12properandfiles(1,"Khyani sahil","132 main st",95.5);
        System.out.println("Original Student :"+st);
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"))){
                oos.writeObject(st);
                
                System.out.println("Student Object Serialized Successfully");
            }
           
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"))){
                q12properandfiles empl = (q12properandfiles) ois.readObject();
                System.out.println("Deserialization Employee : "+empl);
            } catch (ClassNotFoundException ex) {
                System.out.println("Exception was occured..");
                ex.printStackTrace();           
            }
    }
}
