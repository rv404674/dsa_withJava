package structural.decorator.javatpoint;

public class NonVegThali extends BaseThali{
    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public void getItems() {
        System.out.println("Non veg thali - chicken + two roti");
    }
}
