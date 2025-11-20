/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_8 {
    static class multiThreading implements Runnable{
        private String Thread_name;
        private int start,end;
        
        public multiThreading(String name , int start , int end){
            this.Thread_name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start ; i <= end ; i++){
                System.out.println(Thread_name+":"+i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread "+Thread_name+"completed");
        }
        
    
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new multiThreading("thread-1",1,10));
        Thread t2 = new Thread(new multiThreading("thread-2",11,20));
        Thread t3 = new Thread(new multiThreading("thread-3",21,30));
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("All thread completed");
        
    }
    
}
