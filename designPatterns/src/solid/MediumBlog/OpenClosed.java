package solid.MediumBlog;

public class OpenClosed {
    // Open for extension, closed for modification.
    // which means you should be able to extend a class behaviour, without modifying it.
}

class NotificationService {
    public void sendOTP(String medium){
        if(medium.equals("email")){
            // write email related logic
        }
    }
}

// Now if I want to send OTP via SMS/WhatsApp you need to modify source code.
// FIXME: Violoation of OCP. It is not recommended to modify Notif Service for each OTP Feature, as it will
// violate OCP.

// REFACTORING

interface NotificationServiceInterface {
    public void sendOTP();
    public void sendTransactionNotification();
}

class WhatsAppService implements NotificationServiceInterface{

    @Override
    public void sendOTP() {

    }

    @Override
    public void sendTransactionNotification() {

    }
}

class EmailService implements NotificationServiceInterface{

    @Override
    public void sendOTP() {

    }

    @Override
    public void sendTransactionNotification() {

    }
}

