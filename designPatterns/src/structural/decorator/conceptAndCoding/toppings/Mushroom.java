package structural.decorator.conceptAndCoding.toppings;

import structural.decorator.conceptAndCoding.BasePizza;
import structural.decorator.conceptAndCoding.ToppingDecorator;

public class Mushroom extends ToppingDecorator {
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 40;
    }
}
