package behavioural.observerDesignPattern;

import behavioural.observerDesignPattern.Observable.IphoneObservableImpl;
import behavioural.observerDesignPattern.Observable.StocksObervable;
import behavioural.observerDesignPattern.Observer.EmailAlertObserverImpl;
import behavioural.observerDesignPattern.Observer.MobileAlertObserverImpl;
import behavioural.observerDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        // NOTE: This is observer design pattern
        // we are implementing notify me.
        StocksObervable iphoneObservale = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com");
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com");
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username");

        iphoneObservale.add(observer1);
        iphoneObservale.add(observer2);
        iphoneObservale.add(observer3);

        iphoneObservale.setStockCount(20);
    }
}
