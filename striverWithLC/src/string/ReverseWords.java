package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReverseWords {
    public static String reverseWords(String s) {
        // splits based on more than one string.
        String[] tags = s.trim().split(" +");
        List<String> result = new ArrayList<>();

        for(int i = tags.length - 1; i>=0; i--)
                result.add(tags[i]);

        return String.join(" ", result);
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));

        String s2 = "the sky is blue";
        System.out.println(reverseWords(s2));
    }


}
