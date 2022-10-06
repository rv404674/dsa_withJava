package basicsOnline;

/**
 * Resources - https://medium.com/@alifabdullah/easiest-explanation-of-abstract-class-and-interface-280741bc2daf
 * Example - https://stackoverflow.com/questions/10040069/abstract-class-vs-interface-in-java?answertab=scoredesc#tab-top
 * https://www.baeldung.com/java-interfaces
 * https://www.baeldung.com/java-abstract-class
 * https://www.baeldung.com/java-interface-vs-abstract-class
 *
 */

/**
 * NOTE: Abstract Class.
 * 1. Is a Class
 * 2. Can have both abstract and concrete methods.
 * (abstract means something that doesn't have physical existence, eg love)
 * Abstracts methods are methods will only signature.
 * 3. A class extending abstract class will have to implement all abstract members of the abstract class.
 * 4. Use extends here.
 * 5. Using an abstract class avoids reimplmentations, while preserving the power of the interface.
 */

/**
 * NOTE: Interface.
 * 1. Just a interface not a class.
 * 2. Can only have method signatures and static variables.
 * 3. Interfaces are best for creating contracts, that will ensure that all subclasses implement the behaviour by abiding the code.
 * 4. all the methods in interface are by default public and static.
 */

interface Automobile {
    void getTorque();
    void getCost();
    void getName();
}

abstract class Bike implements Automobile {
    public void getTyres(){
        System.out.println("Two Tyres");
    }

    public abstract void getTorque();
    public abstract void getCost();
    public abstract void getName();
}

abstract class Car implements Automobile {
    public void getTyres() {
        System.out.println("Four Tyres");
    }

    public abstract void getTorque();
    public abstract void getCost();
    public abstract void getName();
}


class Continental650 extends Bike{
    @Override
    public void getTorque() {
        System.out.println("52Nm at 5000 RPM");
    }

    @Override
    public void getCost() {
        System.out.println("4lakhs on road in bangalore");
    }

    @Override
    public void getName() {
        System.out.println("Continental 650");
    }
}

class Gixer150 extends Bike {

    @Override
    public void getTorque() {
        System.out.println("13Nm at 8000RPM");
    }

    @Override
    public void getCost() {
        System.out.println("2lakhs on road in bangalore");
    }

    @Override
    public void getName() {
        System.out.println("Gixer SF");
    }
}

public class InterfaceAndAbstractBasics {
    public static void main(String[] args) {
        Automobile continental = new Continental650();
        Automobile gixer = new Gixer150();

        continental.getName();
        continental.getTorque();
        continental.getCost();

        gixer.getName();
        gixer.getTorque();
    }

}
