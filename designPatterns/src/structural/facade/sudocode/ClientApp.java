package structural.facade.sudocode;

public class ClientApp {
    public static void main(String[] args) {
        // FIXME: now here you can see the client needs to interact with multiple system
        // create a facade layer between them.
        User user = new User("rahul verma", "rahul@gmail.com");

//        TicketSystem ticketSystem = new TicketSystem();
//        PaymentSystem paymentSystem = new PaymentSystem();
//        NotificationSystem notificationSystem = new NotificationSystem();
//        boolean isBookingPossible = ticketSystem.validateAvailabilty("movie");
//        if(isBookingPossible){
//            ticketSystem.createTicket(100, user, "movie");
//
//            // call to payment system
//            paymentSystem.chargeCard();
//
//            // call to notif system
//            notificationSystem.sendEmail(user, ticketSystem.getTicketNumber());
//            notificationSystem.sendSms(user, ticketSystem.getTicketNumber());
//        }

        BookingFacade bookingFacade = new BookingFacade();
        bookingFacade.createBooking(user);

    }
}
