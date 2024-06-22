package classes.ch7;

public class MethodOverloadingBasics {
    /**
     * Method Overloading - Java will use number/type of the argument to determine which overloaded function to call.
     * Method Overloading is the type of Polymorphism due to which you dont need to have multiple functions doing the smae thing.
     * NOTE: In case of three for abs() function there are three abs for each of primitive type.
     */

    static void test() {
        System.out.println("Test Function");
    }

    static void test(int a){
        System.out.println("a: " + a);
    }

    static void test(int a, int b){
        System.out.println("a: " + a + " b: " + b);
    }

    public static void main(String[] args) {
        test();
        test(1);
        test(1,2);
    }
}
