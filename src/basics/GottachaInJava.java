package basics;

public class GottachaInJava {
    public static void main(String[] args) {
        // NOTE: For string comparison dont use ==
        // == in strings compares references not values
        String s1 = "rahul";
        String s2 = "rahul";
        String s3 = new String("rahul");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        // USE equals to
        System.out.println(s1.equals(s2));
    }
}
