package Assignment;

public class q9bankings {
    static class BankAccount{
    private double balance;
            
    
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    //public synchronized → only one thread at a time can execute this method on a given
    //Why synchronized? - > Multiple threads are accessing and modifying the same balance variable.
    //only one thread at a time is allowed to be inside this method
    public synchronized boolean withdraw(double amount,String threadName){
        if(balance >= amount){
            System.out.println(threadName+"withdrawing"+amount);
            balance-=amount;
            System.out.println(threadName+"withdrawal successful.balance :" +balance);
            return true;
        }else{
            System.out.println(threadName+"withdrawal failed.Insufficient balance :"+balance);
            return false;
        }
    }
    public synchronized void deposit(double amount,String threadName){
        System.out.println(threadName+"depositing"+amount);
        balance += amount;
        System.out.println(threadName+"deposit successful.balance :" + balance);
    }
    public synchronized double getBalance(){
        return balance;
    }
    }    
    static class BankingThread extends Thread{
        private BankAccount account;
        private String operation;
        private double amount;
        
        public BankingThread(BankAccount account,String operation,double amount,String name){
        super(name);
        this.account = account;
        this.operation = operation;
        this.amount = amount;
        }
        
        @Override
        public void run(){
            if("withdraw".equals(operation)){
                account.withdraw(amount,getName());
                }else if("deposit".equals(operation)){
                account.deposit(amount,getName());
        }
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        BankingThread[] threads = {
            new BankingThread(account,"withdraw",200,"Customer-1"),
            new BankingThread(account,"deposit",300,"Customer-2"),
            new BankingThread(account,"withdraw",150,"Customer-3"),
            new BankingThread(account,"withdraw",800,"Customer-4"),
            new BankingThread(account,"deposit",100,"Customer-5")
        };
        for(BankingThread thread : threads){
            thread.start();
        }
        for(BankingThread thread : threads){
            try{
                //join() → main thread waits for each child thread to finish.
                //So the program does not print final balance until all operations are done.
            
                thread.join(); 
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Final balance"+account.getBalance());
    }
    }
