package queues.basics;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
    /**
     * Queue is a FIFO based DS.
     * Queue can be implemented throught multiple ways in Java.
     * https://www.digitalocean.com/community/tutorials/java-queue#queue-remove-operation
     *
     * Most Commonly Used are through LinkedList and PriorityQueue.
     * NOTE: For linkedinList based implementation
     * Offer - O(1), Peak - O(1), Poll - O(1), Remove - O(1), Size - O(1), DS - Array
     * Offer is adding in Queue.
     * Peak - returning head without popping.
     * Poll/Remove - Returning head with popping.
     * (for an empty q, poll will return null and remove will return NoSuchElementException
     *
     */

    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>();
        // or offer
        queue.add("one");
        queue.add("two");
        queue.add("three");

        System.out.println("Queue Size " + queue.size());
        // poll returns head of the Queue and will pop the head as well.
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue);
        // peek will return head without popping the head.
        System.out.println(queue.peek());
        System.out.println(queue);


    }

}
