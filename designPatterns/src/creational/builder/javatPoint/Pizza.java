package creational.builder.javatPoint;

public abstract class Pizza implements Item{
    private ItemType itemType = ItemType.PIZZA;

    public ItemType getItemType() {
        return itemType;
    }
}

enum ItemType {
    PIZZA,
    COLDRINK;
}