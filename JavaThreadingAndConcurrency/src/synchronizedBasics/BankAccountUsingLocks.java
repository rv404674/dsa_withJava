package synchronizedBasics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FIXME: Read the SynchronizedBlockBasics file before.
 * Locks let you have fine grained blocking in comparison to synchronized keywords.
 * Concurrency would take a hit if you will use synchronized.
 *
 * Executors vs normal Thread.
 */
class BankAccountService {
    private double balance;
    private final Lock depositLock;
    private final Lock withdrawLock;

    public BankAccountService() {
        this.depositLock = new ReentrantLock();
        this.withdrawLock = new ReentrantLock();
        this.balance = 0.0;
    }

    public void deposit(double amount){
        depositLock.lock();
        try {
            balance += amount;
            System.out.println("Deposited " + amount + ", new Balance" + balance);
        } finally {
            depositLock.unlock();
        }
    }

    public void withdraw(double amount){
        withdrawLock.lock();
        try {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", new balance: " + balance);
        } finally {
            withdrawLock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountUsingLocks {
    public static void main(String[] args) throws InterruptedException {
        BankAccountService bankAccountService = new BankAccountService();

        Runnable depositTask = () -> {
            for(int i=0; i<10; i++){
                bankAccountService.deposit(100);
            }
        };

        Runnable withdrawTask = () -> {
            for(int i=0; i<10; i++){
                bankAccountService.withdraw(50);
            }
        };

        // 2 for depositing, 2 for withdrawing.
        // FIXME: as executors are high level construct, you can start and stop them.
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//        executorService.submit(depositTask);
//        executorService.submit(depositTask);
//        System.out.println("Balance: " + bankAccountService.getBalance());
//
//
//        executorService.submit(withdrawTask);
//        executorService.submit(withdrawTask);
//        System.out.println("Balance: " + bankAccountService.getBalance());


        Thread depositThread1 = new Thread(depositTask, "depositT1");
        Thread depositThread2 = new Thread(depositTask, "depositT2");
        depositThread1.start();
        depositThread2.start();
        depositThread1.join();
        depositThread2.join();
        System.out.println("Balance: " + bankAccountService.getBalance());

        Thread withDrawThread1 = new Thread(withdrawTask);
        Thread withDrawThread2 = new Thread(withdrawTask);
        withDrawThread1.start();
        withDrawThread2.start();
        withDrawThread1.join();
        withDrawThread2.join();
        System.out.println("Balance: " + bankAccountService.getBalance());
    }
}


