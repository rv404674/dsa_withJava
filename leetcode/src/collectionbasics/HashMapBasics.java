package collectionbasics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

        // NOTE: Important
        // Context - https://stackoverflow.com/questions/934775/changing-value-after-its-placed-in-hashmap-changes-whats-inside-hashmap
        // NOTE: java uses pass by ref for non primitive types.
        // when you add a user/list to the hm, you dont store the actual user, you store the pointer to the user
        // so when you follow that pointer and make changes using it, it will reflect in the hm as well.
        HashMap<Integer, User> userHashMap = new HashMap<>();
        userHashMap.put(12, new User("Rahul", 25));


        User user = userHashMap.get(12);
        user.setRollNo(30);
        // will reflect in original HM.

        // NOTE: Original hashmap will change.
        userHashMap.forEach((k,v) -> {
            System.out.println(k + "" + v.name + " " + v.rollNo);
        });

    }
}

class User {
    String name;
    int rollNo;

    public User(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
