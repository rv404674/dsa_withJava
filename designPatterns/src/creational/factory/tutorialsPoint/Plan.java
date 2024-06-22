package creational.factory.tutorialsPoint;

public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void getBill(int units){
        System.out.println(units*rate);
    }
}

// NOTE:
// abstract class vs interface.
// in an inteface, you cant have a common functionality like getBill method.
