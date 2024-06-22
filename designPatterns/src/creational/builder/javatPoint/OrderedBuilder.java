package creational.builder.javatPoint;

public class OrderedBuilder {

    public static OrderedItems preparePizza() {
        OrderedItems orderedItems = new OrderedItems();
        orderedItems.addItems(new VegPizza());
        orderedItems.addItems(new NonVegPizza());

        return orderedItems;
    }
}
