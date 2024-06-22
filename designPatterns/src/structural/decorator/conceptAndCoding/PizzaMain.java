package structural.decorator.conceptAndCoding;

import structural.decorator.conceptAndCoding.toppings.ExtraCheese;
import structural.decorator.conceptAndCoding.toppings.Mushroom;

public class PizzaMain {
    public static void main(String[] args) {
        // Explanation in Notebook
        // Basically decorator pattern is what it says
        // it allows you to have a base object and decorator on top of it.
        // Decorator has a (is-a and has-a relation with the base object)

        // get a margherita + extraCheese
        // topping decorator is not being using directly
        BasePizza extraCheese = new ExtraCheese(new Margherita());
        System.out.println(extraCheese.cost());

        BasePizza mushRooomWithExtraCheese = new Mushroom(extraCheese);
        System.out.println(mushRooomWithExtraCheese.cost());
    }
}
