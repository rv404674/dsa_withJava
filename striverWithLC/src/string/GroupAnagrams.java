package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    // NOTE: ThoughProcess
    // see the crux is you need to find a unique hashKey
    // that is basically the array.
    // convert the array to string and voila you have a key.

    // HashTable Problem.

    // TC - O(N*M)
    // n = size of string
    // m = size of strs array
    // SC -
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String s: strs){
            String hash = getHash(s);
            if(!hashMap.containsKey(hash))
                hashMap.put(hash, new ArrayList<>());
            hashMap.get(hash).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }

    public String getHash(String x){
        int[] a = new int[26];
        for(Character c: x.toCharArray())
            a[c - 'a'] +=1;
        // NOTE: this will serve as a unique hash value
        // Eg
        // int[] x = {2, 10};
        // for this Arrays.toString(x) will give "[2, 10]"
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        int[] x = {2, 10};
        String temp = Arrays.toString(x);
        System.out.println(temp);
    }
}
