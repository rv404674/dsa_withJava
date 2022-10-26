package creational.builder.javatPoint;

public class PizzaService {
    public static void main(String[] args) {
        OrderedItems orderedItems = OrderedBuilder.preparePizza();
        System.out.println(orderedItems.getCost());
        orderedItems.showItems();
    }
}
