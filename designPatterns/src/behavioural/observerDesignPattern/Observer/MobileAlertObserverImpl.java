package behavioural.observerDesignPattern.Observer;

import behavioural.observerDesignPattern.Observable.StocksObervable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;

    public MobileAlertObserverImpl(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(StocksObervable obj) {
        sendMsgOnMobile(userName, "new product arrived, stock count" + obj.getStockCount());
    }

    private void sendMsgOnMobile(String userName, String msg){
        System.out.println("msg sent to:" + userName + " " + msg);
        // send the actual sms.
    }
}
