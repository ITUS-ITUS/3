/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author TEST
 */
public class q8multithreads {
    static class NumberPrinter implements Runnable{
        private String threadName;
        private int start,end;
        
        public NumberPrinter(String name,int start,int end){
            this.threadName = name;
            this.start = start;
            this.end = end;
        }
        @Override
        public void run(){
            for(int i = start;i <= end;i++){
                System.out.println(threadName+":"+i);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(threadName+"completed");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new NumberPrinter("Thread-1",1,10));
        Thread thread2 = new Thread(new NumberPrinter("Thread-2",11,20));
        Thread thread3 = new Thread(new NumberPrinter("Thread-3",21,30));
        //all three threads start running in parallel.
        thread1.start();
        thread2.start();
        thread3.start();
        
        try{
            thread1.join(); //main thread blocks (stops) until thread1 is done
            thread2.join(); //main thread blocks (stops) until thread2 is done
            thread3.join(); //main thread blocks (stops) until thread3 is done
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ALL Threads are Completed!");
    }
}
