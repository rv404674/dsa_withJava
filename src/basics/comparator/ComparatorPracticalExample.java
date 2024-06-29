package basics.comparator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


// Problem
// https://leetcode.com/discuss/general-discussion/851939/ancestor-problem
class TransformedRomanName {
    String name;
    int cardinal;

    public TransformedRomanName(String name, int cardinal) {
        this.name = name;
        this.cardinal = cardinal;
    }
}

class TransformedNameComparator implements Comparator<TransformedRomanName> {

    @Override
    public int compare(TransformedRomanName o1, TransformedRomanName o2) {
        // if string name is not equal return here.
        if(!o1.name.equals(o2.name)){
            return o1.name.compareTo(o2.name);
        }

        // compare using cardinal
        return Integer.compare(o1.cardinal, o2.cardinal);
    }
}

public class ComparatorPracticalExample {
    public static List<TransformedRomanName> getAncestrolNames(List<String> names){
        List<TransformedRomanName> ancestralNames = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);


        for(String name: names){
            String[] tokens = name.split(" ");
            String romanName = tokens[0];
            String romanForm = tokens[1];

            int total = 0;
            for(int i=0; i<romanForm.length(); i++){
                Character c = romanForm.charAt(i);
                if(i+1 < romanForm.length() && hashMap.get(c) < hashMap.get(romanForm.charAt(i+1))){
                    // subtract
                    int substract = hashMap.get(romanForm.charAt(i+1)) - hashMap.get(c);
                    total = total + substract;
                    i++;
                } else {
                    // simply keep on adding.
                    total = total + hashMap.get(c) ;
                }
            }

            ancestralNames.add(new TransformedRomanName(romanName, total));
        }

        return ancestralNames;
    }

    public static void main(String[] args) {
        String[] names = {"Steven XVI", "David IX", "Steven XL", "Mary XV", "Mary XIII", "Mary XX"};
        List<String> wordList = Arrays.asList(names);

        List<TransformedRomanName> romanNames = getAncestrolNames(wordList);
        Comparator<TransformedRomanName> comparator = new TransformedNameComparator();
        romanNames.sort(comparator);

        List<String> ans = new ArrayList<>();
        for(TransformedRomanName name: romanNames){
            ans.add(name.name + " " + name.cardinal);
        }

        System.out.println(ans);

    }
}
