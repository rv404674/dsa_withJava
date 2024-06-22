package tuts;


// Resource - https://www.geeksforgeeks.org/synchronization-in-java/
public class synchronizatoinInJava {
    public static void main(String[] args) {
        // CRUX
        // synchronized keyword, makes sure that only one thread can access the critical section.
        // it is internally implemented using a Monitor.
        // only one thread can own a monitor at any given time.

        Sender sender = new Sender();
        Thread t1 = new Thread(new ThreadedThread("Hi", sender));
        Thread t2 = new Thread(new ThreadedThread("Bye", sender));

        // start the processing
        t1.start();
        t2.start();
    }
}

class Sender {
    public void send(String msg){
        System.out.println("Sending Msg: " + msg);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread interrupted");
        }

        System.out.println(msg + " Sent");
    }
}

// Appr1
// NOTE: synchronized on object.
class ThreadedThread implements Runnable {
    private String msg;
    Sender sender;

    public ThreadedThread(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public void run() {
        synchronized (sender){
            sender.send(msg);
        }
    }
}

// NOTE: Approach2
// synchronize the whole function.
class ThreadedThread2 implements Runnable {
    private String msg;
    Sender sender;

    public ThreadedThread2(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public synchronized void run() {
            sender.send(msg);
    }
}

// NOTE: Approach3
// use synchronize as part of the method.
class Sender2 {
    public void send(String msg){
        synchronized (this)
        {
            System.out.println("Sending :" + msg);

            try {
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println("Thread interruptedff :" + e);
            }
        }
    }
}


