/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
public class ques_9 {
    static class Bankingclass {
        private int balance;
        public  Bankingclass(int initial_amount){
            this.balance = initial_amount;
        }
        
        public synchronized boolean withdraw(int amount , String thread_name){
            if(balance >= amount){
                balance -= amount;
                System.out.println(thread_name +":"+amount);
                return true;
            }
            else{
                System.out.println("not enough balance");
                return false;
            }
        }
        
        public synchronized void deposit(int amount , String thread_name){
            balance += amount;
            System.out.println(thread_name +":"+amount);
            
        }
        
        public synchronized int get_balance(){
            return balance;
    
        }
        
    }
    
    static class bankingThread extends Thread{
        private String operation;
        private int amount ;
        private Bankingclass account;
        
        public bankingThread(Bankingclass account , String operation , int amount , String name){
            super(name);
            this.account = account;
            this.operation = operation;
            this.amount = amount;
        }
        @Override
        public void run(){
            if("withdraw".equals(operation)){
                account.withdraw(amount, getName());
            }else{
                account.deposit(amount, getName());
            }
        
        }
        
    }
    
    public static void main(String[] args) {
        Bankingclass account = new Bankingclass(1000);
        bankingThread[] threads = {
            new bankingThread(account,"withdraw",400,"thread-1"),
            new bankingThread(account,"deposit",500,"thread-2")
        };
        
        for(bankingThread thread : threads){
            thread.start();
        }
        for(bankingThread thread : threads){
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("total balance"+account.get_balance());   
    }
}
