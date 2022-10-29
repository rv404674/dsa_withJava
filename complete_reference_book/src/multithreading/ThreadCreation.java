package multithreading;

// NOTE: run() - you will define code that constitues a new thred.
// After a new thread is created it wont start running until start() method is called

// Creation1
// extend Thread class in java
class Thread1 extends Thread {
    public void run(){
        System.out.println("Creating using Thread class");
        try {
            for (int i=0;i<5;i++){
                System.out.println("Child Thread" + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            System.out.println("Child interrupted");
        }

        System.out.println("Exiting Thread");
    }

}

// Creation2
// using runnable in java
class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Creating thread using Runnable interface");
    }
}

// Book Using Runnable
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("child thread" + t);
    }

    // this is the entry point for second thread
    public void run() {
        System.out.println("Runnable using book definition");
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();

        // Remember this. try to use runnable everywhere
        Thread t1 = new Thread(new Thread2());
        t1.start();

        NewThread newThread = new NewThread();
        newThread.run();
    }
}
