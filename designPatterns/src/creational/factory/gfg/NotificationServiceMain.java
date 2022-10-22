package creational.factory.gfg;

public class NotificationServiceMain {
    public static void main(String[] args) {
        // NotifService main.
        Notification pushNotification = NotificationFactory.getNotification("Push");
        Notification smsNotification = NotificationFactory.getNotification("Sms");

        // Push Notif Sent
        pushNotification.notifyUser();

        // sms notif sent
        smsNotification.notifyUser();
    }
}
