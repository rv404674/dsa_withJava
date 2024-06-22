package structural.decorator.javatpoint;

import structural.decorator.javatpoint.Extras.ExtraChicken;
import structural.decorator.javatpoint.Extras.ExtraDaal;

public class MainFood {
    public static void main(String[] args) {
        BaseThali extraDaal = new ExtraDaal(new VegThali());
        System.out.println(extraDaal.getCost());
        extraDaal.getItems();

        BaseThali extraChicken = new ExtraChicken(new NonVegThali());
        System.out.println(extraChicken.getCost());
        extraChicken.getItems();

    }
}
