package JakobJenkov.CreationStoppingOfThreads;

/**
 * Wait - The thread that calls wait() will enter a waiting state until another thread calls notify() or notifyAll() on the same object.
 * Notify - Wakes one of the waiting thread waiting on the same object.
 * Join - Current's thread execution will be paused, until the thread on which join() was called has finished its execution.
 */

// NOTE: Demo with producer consumer problem
/**
 * Producer - if the bufffer is full, make it wait. If the buffer has anything, notif they consumer
 * Consumer - if the buffer is empty, wait.
 */

class Buffer {
    private int[] buffer;
    private final int size;
    private int count;

    public Buffer(int size){
        this.size = size;
        buffer = new int[size];
        this.count = 0;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while(count == size){
            // Buffer is full, wait for the consumer to consume
            wait();
        }

        buffer[count] = item;
        count++;
        System.out.println("Produced to the Buffer: " + item);

        // notify the consumer that the item is available
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while(count == 0){
            // wait if the buffer is empty
            wait();
        }

        int item = buffer[count-1];
        count--;
        System.out.println("Consumer by the consumer: " + item);

        // notify the producer that the space is available
        notify();
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for(int i=1; i<=5; i++){
                buffer.produce(i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }


    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            try {
                buffer.consume();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



public class NotifyAndWaitUsingProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(10);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        consumerThread.start();
        producerThread.start();

        // main() will wait for producerThread() to finish its execution.
        producerThread.join();
        consumerThread.join();

    }
}
