package javaIO;

import java.util.Scanner;

public class scannerBasics {
    /**
     * Scanner class in java can be constructed from
     * Input Stream (stdio), a file or a string source as well
     *
     * Imp methods: next(), hasnext(), close(), useDelimiter(), defualt delimi is white space.
     * Typically, Scanner breaks the input into tokens using a delimiter pattern, which is, by default, any whitespace.
     */

    public static void main(String[] args) {
        // next - will just read a word until the next delimiter i.e space.
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls Enter your name");
        // FIXME: issue with this from "Rahul Verma" it will only take Rahul as name because space is the by defual delimiter.
        String name = sc.next();
        System.out.println(name);

        // use nextLine to read the whole line
        // NOTE: always use this in the interviews.
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Pls Enter your name");
        name = sc2.nextLine();
        System.out.println(name);


        // you can also read int
//        int marks = sc2.nextInt();

    }
}
