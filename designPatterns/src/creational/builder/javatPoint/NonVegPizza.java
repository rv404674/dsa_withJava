package creational.builder.javatPoint;

public class NonVegPizza extends  Pizza{
    @Override
    public String getName() {
        return "Big Non Veg Pizza";
    }

    @Override
    public String getSize() {
        return "Medium";
    }

    @Override
    public float getPrice() {
        return 300;
    }
}
