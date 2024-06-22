package classes.ch7;

/**
 * NOTE: Basics
 * https://www.baeldung.com/java-static
 * 1. Anything that preceeds with a static basically means that, that thing belongs to the type itself rather than the instance itself.
 * 2. Static Variables - Will be created in heap space, will be created only one and shared across all instances.
 * 3. Static Methods - Is used mainly as utility methods and can be called without creatina any instance
 *
 * All util methods of Collection class are static.
 * Collections.reverse(A);
 */

/**
 * NOTE: Final basics
 * Any Variable once declared final, can't be modified. It will be treated like a constant then.
 */
interface Bike {
    void getName();
    void getPower();
}

class Continental  {
    final static int TYRES = 2;
    final int CYLINDER = 2;

    public static void getName() {
        System.out.println("Name is Continental 650");
    }

    public void getPower(){
        System.out.println("52Nm at 5000Rpm");
    }
}

public class StaticBasics {
    public static void main(String[] args) {
        Continental continental1 = new Continental();
        Continental continental2 = new Continental();

        System.out.println(Continental.TYRES);
        Continental.getName();
    }
}
