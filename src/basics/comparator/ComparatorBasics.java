package basics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        if(o1.rollNo < o2.rollNo){
            return -1;
        } else if(o1.rollNo > o2.rollNo){
            // swap o1 and o2
            return 1;
        }
        return 0;
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
