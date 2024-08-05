package basics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }
}

class RollComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // -1, 0, 1
        // -1 if o1 is less than o2.
        // 1 if o1 is > o2. WIll swap in this case
        // else 0
        return Integer.compare(o1.rollNo, o2.rollNo);
    }
}

public class ComparatorBasics {
    public static void main(String[] args) {
        // You can write your own custom comparator, to sort in a particular order.
        // compare based on rollNumber
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(100, "Rahul Verma"));
        studentArrayList.add(new Student(105, "Sachin Verma"));
        studentArrayList.add(new Student(99, "Sumedhahh"));

        Comparator rollComparator = new RollComparator();

        // before sorting
        System.out.println("Bfore sorting");
        for(Student x: studentArrayList)
            System.out.println(x.name + x.rollNo);
        Collections.sort(studentArrayList, rollComparator);

        System.out.println("After sorting");
        for(Student x: studentArrayList)
            System.out.println(x.name + x.rollNo);
        System.out.println(studentArrayList.toString());


    }

}


class Element implements Comparable<Element> {
    int frequency;
    int elementValue;

    Element(int count, int value) {
        this.frequency = count;
        this.elementValue = value;
    }


    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}

 class TopKFrequentElements {
    // NOTE: Intention is to get AC in first go itself.
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        List<Integer> topElements = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        // key is elementValue, and value is frequence
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            minHeap.offer(new Element(entry.getValue(), entry.getKey()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            topElements.add(minHeap.poll().elementValue);
        }

        return topElements.stream().mapToInt(Integer::intValue).toArray();
    }
}
