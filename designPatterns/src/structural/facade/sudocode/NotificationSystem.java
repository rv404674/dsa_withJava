package structural.facade.sudocode;

public class NotificationSystem {
    public void sendEmail(User user, String ticket){
        System.out.println("email sent to" + user.getName() + ticket);
    }

    public void sendSms(User user, String ticket){
        System.out.println("sms sent to" + user.getName() + ticket);
    }
}
