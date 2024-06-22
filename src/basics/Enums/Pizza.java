package basics.Enums;

public class Pizza {
    private PizzaStatus status;

    public enum PizzaStatus{
        ORDERED,
        READY,
        DELIVERED
    }

    boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

}
