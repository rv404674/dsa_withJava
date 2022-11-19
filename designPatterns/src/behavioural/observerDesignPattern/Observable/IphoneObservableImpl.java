package behavioural.observerDesignPattern.Observable;

import behavioural.observerDesignPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObervable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver observer: observerList){
            observer.update(this);
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        // if the stockcount is 0, it means new stock has came. update the subscribers
        int prevStockCount = this.stockCount;
        this.stockCount += newStockAdded;
        if(prevStockCount == 0){
            notifySubscriber();
        }
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
