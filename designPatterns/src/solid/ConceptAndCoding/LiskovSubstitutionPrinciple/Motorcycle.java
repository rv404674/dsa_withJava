package solid.ConceptAndCoding.LiskovSubstitutionPrinciple;

public class Motorcycle implements Bike{
    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        this.isEngineOn = true;
    }

    @Override
    public void accelerate() {
        this.speed = this.speed + 10;
    }
}

class Bicyle implements Bike {
    // FIXME: Violation of L
    // when you pass Bike, and call turnOnEngine(), engine will turn on.
    // as now if you pass Bicyle and call turnOnEngine() the code will break.
    // NOTE: we changed the behaviour.
    @Override
    public void turnOnEngine() {
        throw new AssertionError("Bicyle doesst hanvean engine");
    }

    @Override
    public void accelerate() {
        // increase spped
    }
}
