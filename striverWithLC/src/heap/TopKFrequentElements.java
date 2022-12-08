package heap;

import java.util.*;

class Element {
    int value;
    int count;

    public Element(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        // compare based on count
        // 1 means swap
        // NOTE: we want higher count in the beg.
        // NOTE: 1 means swap
        if(o1.count < o2.count) {
            return 1;
        } else if(o1.count > o2.count) {
            return -1;
        } else
            return 0;
    }
}

public class TopKFrequentElements {
    // Approach 1
    // use HashMap to store count.
    // then put the values in array list
    // sort using a custom compraotor
    // TC - O(N) + O(Nlogn)
    // SC - O(N)
    // AC
    public int[] topKFrequentSorting(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x: nums){
            hashMap.put(x, hashMap.getOrDefault(x, 0)+1);
        }

        List<Element> list = new ArrayList<>();
        hashMap.forEach((x,y) ->
                list.add( new Element(x,y))
                );

        ElementComparator elementComparator = new ElementComparator();

        Collections.sort(list, elementComparator);
        int[] ans = new int[k];
        for(int i = 0; i<k;i++){
            ans[i] = list.get(i).value;
        }

        return ans;
    }

    // Approach 2
    // Use Min Heap
    // NOTE: The trick always - if you want max
    // use min heap, as you can eject min elements and at the end you have max left.
    // TC - O(n) + O(nlogk)
    // SC - O(n) + O(k)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int x:nums){
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        ElementComparator elementComparator = new ElementComparator();
        // the comparator here for minHeap should put cnt of less first
        // basics if a.count - b.count > 1, we will return 1 hence swap i.e this is what we wanted.
        // smaller at the front.
        Queue<Element> minHeap = new PriorityQueue<>((Element a, Element b) -> (a.count - b.count));
        hashMap.forEach((value, cnt) -> {
                    minHeap.add(new Element(value, cnt));
                    if (minHeap.size() > k)
                        minHeap.remove();
                }
        );

        int[] result = new int[k];
        while(!minHeap.isEmpty()) {
            int x = minHeap.size();
            result[x-1] = minHeap.remove().value;
        }

        return result;

    }


        public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
    }
}
