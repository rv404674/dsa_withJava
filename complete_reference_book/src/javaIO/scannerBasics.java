package javaIO;

import java.util.Scanner;

public class scannerBasics {
    /**
     * Scanner class in java can be constructed from
     * Input Stream (stdio), a file or a string source as well
     *
     * Imp methods: next(), hasnext(), close(), useDelimiter(), defualt delimi is white space.
     */

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Pls Enter your name");
//        // FIXME: issue with this from "Rahul Verma" it will only take Rahul as name because Verma is the by defual delimi
//        String name = sc.next();
//        System.out.println("Hello" + name);
//        sc.close();

        // NOTE: use this for interviews as well.
        Scanner sc2 = new Scanner(System.in);
        sc2.useDelimiter(System.getProperty("line.separator"));
        while (sc2.hasNext()) {
            String name2 = sc2.next();
            System.out.println("Hello" + name2);
        }
        sc2.close();

        // you can also read int
        int marks = sc2.nextInt();

    }
}
