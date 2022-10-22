package creational.factory.gfg;

public class NotificationFactory {
    public static Notification getNotification(String notifType){
        switch (notifType){
            case "Push":
                return new PushNotification();
            case "Sms":
                return new SmsNotification();
            default:
                return null;
        }
    }
}
