package synchronizedBasics;

/**
 * class A {
 * synchronized methodX()
 * synchronized methodY()
 * }
 *
 * NOTE: if T1 gets in methodX(), T2 wont be able to get in methodY().
 * THe sychronization here still works on object level.
 * When T1 gets in methodX(), the whole object would be blocked from doing any further operation.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Now lets you have a payment service
 * PaymenService {
 *     sychronize sendMoney()
 *     synchronized recieveMoney()
 * }
 *
 * If U1 -> U2 (sending 200 rs to U2), this will block the whole object.
 * in meanwhile if U6 <- U3(U6 was recieving money from U3), this wont run, as the object is blocked by U1.
 *
 * Hence concurrency will take a hit.
 * Use locks here.
 */

class A {
    public synchronized void methodX() {
        System.out.println(Thread.currentThread().getName() + " entered methodX");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " leanving methodX");
    }

    public synchronized void methodY() {
        System.out.println(Thread.currentThread().getName()+ "entered methodY");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "leaving methodY");
    }
}

public class SynchronizedBlocksBasics {

    public static void main(String[] args) {
        // TODO: Approach 1.of running.
        A obj = new A();

        Runnable task1 = () -> {
            obj.methodX();
        };

        Runnable task2 = () -> {
            obj.methodY();
        };

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();


        // TODO: Approach 2
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(task1);
        executorService.submit(task2);

    }


}
