package classes.ch7;

/**
 * NOTE: In java Strings are immutable.
 * Two ways to modify them.
 * 1. Create a new copy and then modify.
 * 2. Use StringBuilder and StringBuffer to mutate.
 * https://www.baeldung.com/java-string-builder-string-buffer
 *
 * NOTE:
 * StringBuffer - Synchronized, hence thread-safe. Slower than StringBuilder
 * StringBuilder - Not a thread-safe implementation. Faster then StrinBuilder.
 */
public class StringBuilderAndStringBufferBasics {

    public static void main(String[] args){
        // NOTE: here even though it looks like we are modifying the original one.
        // but we are creating a new instance as string can't be modified. -> immutable
        String s1 = "Rahul Verma";
        System.out.println(s1.hashCode());
        s1 = s1 + "sachin";
        System.out.println(s1.hashCode());

        StringBuffer sb = new StringBuffer("abc");
        StringBuilder stringBuilder = new StringBuilder("xyz");
        stringBuilder.append("rhaul");
    }
}
