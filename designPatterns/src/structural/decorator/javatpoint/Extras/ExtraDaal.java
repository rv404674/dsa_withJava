package structural.decorator.javatpoint.Extras;

import structural.decorator.javatpoint.BaseThali;

public class ExtraDaal extends ExtrasDecorator{
    BaseThali baseThali;

    public ExtraDaal(BaseThali baseThali) {
        this.baseThali = baseThali;
    }

    @Override
    public int getCost() {
        return this.baseThali.getCost() + 50;
    }

    @Override
    public void getItems() {
        System.out.println("base thali + extra daal");
    }
}
