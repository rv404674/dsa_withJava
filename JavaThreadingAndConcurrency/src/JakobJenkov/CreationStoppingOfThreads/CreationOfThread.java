package JakobJenkov.CreationStoppingOfThreads;

public class CreationOfThread {
    public static void main(String[] args) {
        // NOTE: There are two ways to create a thread basically
        // 1. extend thread class
        // 2. implement runnable interface
        // NOTE: recommend is to implement runnable interface
        Thread thread1 = new ThreadImplementation();
        thread1.start();

        RunnableImplementation runnableImplementation = new RunnableImplementation();
        Thread thread2 = new Thread(runnableImplementation);
        thread2.start();

        // third way using lambda
        Runnable runnable = () -> {
            System.out.println("Lambda Thread started");
            System.out.println("Lambda Thread finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class ThreadImplementation extends Thread {
    public void run() {
        System.out.println("ThreadImplementation - Thread is starting");
        System.out.println("ThreadImplementation - Thread is exiting");
    }
}

class RunnableImplementation implements Runnable {
    @Override
    public void run() {
        System.out.println("RunnableImplementation - Thread is starting");
        System.out.println("RunnableImplementation - Thread is exiting");
    }
}
