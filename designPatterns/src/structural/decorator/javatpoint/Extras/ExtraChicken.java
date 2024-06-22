package structural.decorator.javatpoint.Extras;

import structural.decorator.javatpoint.BaseThali;

public class ExtraChicken extends ExtrasDecorator {
    BaseThali baseThali;

    public ExtraChicken(BaseThali baseThali) {
        this.baseThali = baseThali;
    }

    @Override
    public int getCost() {
        return this.baseThali.getCost() + 200;
    }

    @Override
    public void getItems() {
        System.out.println("extra chicken added");
    }
}
