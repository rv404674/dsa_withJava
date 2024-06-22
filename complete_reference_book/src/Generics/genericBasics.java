package Generics;

import java.util.ArrayList;
import java.util.List;

public class genericBasics {
    // NOTE: Generics was introduced in java to make the code stable.
    // before generics you could have added anything to the collection.
    // TO Study - https://www.javatpoint.com/generics-in-java

    public static void main(String[] args) {
        // Type Safety
        List list = new ArrayList();
        list.add("sdfs");
        list.add(10);

        // with generics, we need to specify the type we need to store
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        // will give compile time error: list2.add("sdfs");

        // NOTE: Syntax
        // ClassOrInterface<Type>
        MyGen<Integer> myGen = new MyGen<>();
        myGen.add(10);
        myGen.get();

        // NOTE:
        // T - type
        // E - element
        // K - Key, V - Value, N - number
        FuncGeneric funcGeneric = new FuncGeneric();
        Integer[] intArray = {10,20};
        funcGeneric.printArray(intArray);

        Character[] charArray = {'J', 'A'};
        funcGeneric.printArray(charArray);


    }
}

// created a Gneric Class
class MyGen<T>{
    T obj;
    void add(T ob){
        this.obj = ob;
    }

    T get(){
        return this.obj;
    }
}

class FuncGeneric {
    public <E> void printArray(E[] elements){
        for(E element: elements)
            System.out.println(element);
    }
}
