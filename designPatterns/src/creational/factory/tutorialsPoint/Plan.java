package creational.factory.tutorialsPoint;

public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void getBill(int units){
        System.out.println(units*rate);
    }

}
