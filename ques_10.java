
import java.util.LinkedList;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_10 {
    private static final int buffer_size = 5;
    private Queue buffer = new LinkedList<>();
    
    
    class producer extends Thread{
        int value = 0;
        @Override
        public void run(){
            while(true){
                synchronized (buffer) {
                    if(buffer.size()==buffer_size){
                        try {
                            System.out.println("Buffer is full wait plz");
                            buffer.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        
                    }
                    
                    buffer.offer(value);
                    System.out.println("value :- "+value+" buffer size :- "+buffer.size());
                    value++;
                    
                    buffer.notifyAll();
                    
                    try {
                            Thread.sleep(500);
                             
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                }
            }
        }
        
    
    }
    
    class consumer extends Thread{
        int value = 0;
        @Override
        public void run(){
            while(true){
                synchronized (buffer) {
                    if(buffer.isEmpty()){
                        try {
                            System.out.println("Buffer is full wait plz");
                            buffer.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        
                    }
                    
                    int value =(int) buffer.poll();
                    System.out.println("value :- "+value+" buffer size :- "+buffer.size());
                    value++;
                    
                    buffer.notifyAll();
                    
                    try {
                            Thread.sleep(500);
                             
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                }
            }
        }
        
    
    }
    public static void main(String[] args) {
        ques_10 ex = new ques_10();
        producer pro = ex.new producer();
        consumer con = ex.new consumer();
        
        pro.start();
        con.start();
        
        try {
            pro.join();
            con.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        
    
    
}
