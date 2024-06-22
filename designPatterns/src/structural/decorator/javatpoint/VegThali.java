package structural.decorator.javatpoint;

public class VegThali extends BaseThali{
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public void getItems() {
        System.out.println("Base Thali - has 2 roti + sabji");
    }
}
