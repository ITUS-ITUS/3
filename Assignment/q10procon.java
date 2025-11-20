/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author TEST
 */
public class q10procon {
    private static final int BUFFER_SIZE = 5;
    private Queue buffer = new LinkedList<>();
    
    class Producer extends Thread{
        @Override 
        public void run(){
            int value = 0;
            while(true){
                synchronized(buffer){
                    while(buffer.size() == BUFFER_SIZE){
                        try{
                            System.out.println("Buffer is full.Producer waiting...");
                            buffer.wait();
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    
                    buffer.offer(value);
                    System.out.println("Produced :"+value+"| Buffer Size :"+buffer.size());
                    value++;
                    
                    buffer.notifyAll();
                    
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
    class Consumer extends Thread{
        @Override 
        public void run(){
            while(true){
                synchronized(buffer){
                    while(buffer.isEmpty()){
                        try{
                            System.out.println("Buffer is empty. Consumer is Waiting... ");
                            buffer.wait();
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    
                     int value = (int) buffer.poll();
                    System.out.println("Consumed :"+value+"| Buffer Size :"+buffer.size());
                    
                    buffer.notifyAll();
                    
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        q10procon ex = new  q10procon();
        
        Producer pro = ex.new Producer();
        Consumer con = ex.new Consumer();
        
        pro.start();
        con.start();
        
        try{
        pro.join();
        con.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
