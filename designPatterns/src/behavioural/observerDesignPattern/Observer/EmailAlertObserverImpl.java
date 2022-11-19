package behavioural.observerDesignPattern.Observer;

import behavioural.observerDesignPattern.Observable.StocksObervable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;

    public EmailAlertObserverImpl(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update(StocksObervable obj) {
        sendEmail(emailId, "new product arrived, stock count: " + obj.getStockCount());
    }

    private void sendEmail(String emailId, String msg){
        System.out.println("mail sent to:" + emailId + " " + msg);
        // send the actual email to the end user.
    }
}
