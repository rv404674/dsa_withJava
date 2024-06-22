package collectionbasics.lists;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

/**
 * NOTE: Properties
 * Arraylist is a list implementation built on top of an ARRAY, then can dynamically grow,
 * Has the following properties
 * fetch - O(1), adding element (at the end)/ removing from end- O(1)
 * adding/removing from other index - O(n)
 * searching - O(n)
 */

/**
 * NOTE: ArrayList vs LinkedList
 * both implements List. Hence it is best to use List<>, as if later we want
 * to change it to something else, it will be easy.
 * Keeps the code loosely coupled.
 */
public class ArrayListsBasics {

    public static void basics(){
        // this one is better as list is a interface that other lists implement.
        // so it is keeps the code decoupled.
        List<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        List<String> list3 = new LinkedList<>();

        Collection<Integer> numbers
                = IntStream.range(0,10).boxed().collect(toSet());

        list3.add("rahul verma");

        // iterate over array list
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            System.out.println(it);
            it.next();
        }
    }
}
