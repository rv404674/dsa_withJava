package structural.decorator.conceptAndCoding.toppings;

import structural.decorator.conceptAndCoding.BasePizza;
import structural.decorator.conceptAndCoding.ToppingDecorator;

public class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
