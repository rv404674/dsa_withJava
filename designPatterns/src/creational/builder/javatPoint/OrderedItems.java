package creational.builder.javatPoint;

import java.util.ArrayList;
import java.util.List;

public class OrderedItems {
    List<Item> items = new ArrayList<>();

    public void addItems(Item item){
        items.add(item);
    }

    public float getCost(){
        float totalCost = 0;
        for(Item x: items)
            totalCost += x.getPrice();
        return totalCost;
    }

    public void showItems(){
        for(Item x: items)
            System.out.println(x.getName());
    }
}
