package multithreading;

// try to use Runnable everywhere as you are not trying to change threads behaviour (which is the usecase while extending)
class Thread5 implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Running Thread5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread6 implements Runnable {
    public void run() {
        System.out.println("Running Thread6");
    }
}

public class JoiningThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread5());
        Thread t2 = new Thread(new Thread6());

        t1.start();
        try {
            t1.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // NOTE: because of the join above t2 will only start only after t1 has finished.
        t2.start();

    }
}
