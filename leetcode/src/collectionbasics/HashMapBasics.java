package collectionbasics;

import java.util.*;

public class HashMapBasics {

    /*
    NOTE:
    HashMap vs HashTable
    1. HashMap is non synchronized (i.e it is not thread safe).
    If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally.

    2. HashMap is fast. and it can have only one null key value and many null values.
    3. It has an initial cap of 16, with load factor of 0.75
    Implementation - It uses a LinkedList DS internally.

    HashTable
    1. Threadsafe, slow and can't have any null value.
     */
    public static void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Rahul");
        hashMap.put(2, "Sachin");
        hashMap.put(3, "Sumedha");

        Iterator hmIterator =  hashMap.entrySet().iterator();
        // Approach1: To iterate
        while(hmIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            int num = (int) mapElement.getKey();
            System.out.println(num + " " + mapElement.getValue());
        }

        // Approach2: for each loop
        for(Map.Entry mapElement: hashMap.entrySet()){
            String key = (String) mapElement.getValue();
            int value = (int) mapElement.getKey();
            System.out.println(key + " " + value);
        }

        // Approach3: easiset of all
        System.out.println("Approach 3");
        hashMap.forEach((k,v) ->
                System.out.println(k + " " + v)
        );

    }
}
