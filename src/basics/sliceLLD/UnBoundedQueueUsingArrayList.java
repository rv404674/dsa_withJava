package basics.sliceLLD;

import java.util.*;

public class UnBoundedQueueUsingArrayList<T> implements UnBoundedQueueInterface<T> {
    private ArrayList<T> storage;
    private Comparator elementComparator;

    public UnBoundedQueueUsingArrayList(Comparator elementComparator) {
        this.storage = new ArrayList<>();
        this.elementComparator = elementComparator;
    }

    @Override
    public T get() {
        if(storage.isEmpty())
            return null;

//        while()

        return storage.remove(storage.size()-1);
    }


    // assumptiopm - element with highest priority will be most priortized.
    // highest at the end.
    @Override
    public void put(T element) {
        this.storage.add(element);
        Collections.sort(storage, this.elementComparator);
    }
}