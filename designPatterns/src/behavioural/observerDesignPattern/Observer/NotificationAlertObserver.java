package behavioural.observerDesignPattern.Observer;

import behavioural.observerDesignPattern.Observable.StocksObervable;

public interface NotificationAlertObserver {
    public void update(StocksObervable obj);
}
