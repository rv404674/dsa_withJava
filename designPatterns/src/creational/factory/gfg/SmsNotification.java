package creational.factory.gfg;

public class SmsNotification extends Notification{

    @Override
    public void notifyUser() {
        System.out.println("Sms Notification Send");
    }
}
