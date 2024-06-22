package creational.builder.javatPoint;

public abstract class ColdDrink implements Item{
    private ItemType itemType = ItemType.COLDRINK;

    public ItemType getItemType() {
        return itemType;
    }
}
