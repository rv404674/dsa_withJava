package creational.builder.javatPoint;

public class VegPizza extends Pizza{
    @Override
    public String getName() {
        return "Macroni Veg Pizza";
    }

    @Override
    public String getSize() {
        return "Large Size";
    }

    @Override
    public float getPrice() {
        return 500;
    }
}
