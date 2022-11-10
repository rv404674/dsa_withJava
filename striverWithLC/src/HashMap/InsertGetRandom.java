package HashMap;

import java.util.*;

// NOTE: O(n) for getRandom.
public class InsertGetRandom {
    Set<Integer> set;
    Random random;

    public InsertGetRandom() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        } else
            return false;
    }

    public int getRandom() {
        // O(n)
        // convert set to array
        // and get a random
        Integer[] array = set.toArray(new Integer[set.size()]);
        int x = random.nextInt(array.length);
        return array[x];
    }
}


// NOTE: O(1) for all.
// Thought Process - We need to have a list to get random.
// but deletion is taking - O(n)
// Smart Trick - delete in such a way that it takes O(1)
// swap(element_to_be_deleted, last_number)
// delete last element
// update hashmaps.
// NOTE: Because we didn't cared for the ordering the above trick for deletion works here.
class RandomizedSet {
    HashMap<Integer, Integer> valueToKeysHashMap;
    Random random;
    List<Integer> list;

    public RandomizedSet() {
        valueToKeysHashMap = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    // O(1)
    public boolean insert(int val) {
        if(valueToKeysHashMap.containsKey(val)){
            return false;
        } else {
            list.add(val);
            valueToKeysHashMap.put(val, list.size()-1);
            return true;
        }
    }

    // O(1), remove it in a tricky way.
    public boolean remove(int val) {
        if(!valueToKeysHashMap.containsKey(val)){
            return false;
        } else {
            int indexToBeRemoved = valueToKeysHashMap.get(val);
            if(indexToBeRemoved != list.size() -1){
                // if it is the last index, directly remove.
                // Removing starts
                int lastOne = list.get(list.size() - 1);
                Collections.swap(list, indexToBeRemoved, list.size() - 1);
                valueToKeysHashMap.put(lastOne, indexToBeRemoved);
            }

            valueToKeysHashMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

    }

    public int getRandom() {
        int x = random.nextInt(list.size());
        return list.get(x);
    }
}

// NOTE: if duplicates are allowed, use Map<Integer, Set<Int, Int>>

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
