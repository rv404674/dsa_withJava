package solid.ConceptAndCoding.InterfaceSegmentedPrinciple;

public interface RestaurantEmployee {
    void washDishes();
    void serveFood();
    void cookFood();
}

// FIXME: Violation of I
// as Waiter's jobs is not care about cooking food.
class WaiterEmployee implements RestaurantEmployee{

    @Override
    public void washDishes() {
        // Dont care not my job.
    }

    @Override
    public void serveFood() {
        System.out.println("Serving Food");
    }

    @Override
    public void cookFood() {
        // Dont care not my job.
    }
}

//NOTE: break down it into smaller interface

interface WaiterInterface{
    void serveFood();
    void takeOrder();
}

class Waiter implements WaiterInterface{

    @Override
    public void serveFood() {

    }

    @Override
    public void takeOrder() {

    }
}

interface Chef{
    void cookFood();
    void decideMenu();
}

