package behavioural.observerDesignPattern.Observable;

import behavioural.observerDesignPattern.Observer.NotificationAlertObserver;

// amazon has stocks for iphone/oneplus
// upon clicking notifyMe notify the observer that the stocks has come.
public interface StocksObervable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscriber();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}
