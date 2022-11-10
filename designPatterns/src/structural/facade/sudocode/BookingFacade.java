package structural.facade.sudocode;

public class BookingFacade {
    public void createBooking(User user) {
        TicketSystem ticketSystem = new TicketSystem();
        PaymentSystem paymentSystem = new PaymentSystem();
        NotificationSystem notificationSystem = new NotificationSystem();
        boolean isBookingPossible = ticketSystem.validateAvailabilty("movie");
        if (isBookingPossible) {
            ticketSystem.createTicket(100, user, "movie");

            // call to payment system
            paymentSystem.chargeCard();

            // call to notif system
            notificationSystem.sendEmail(user, ticketSystem.getTicketNumber());
            notificationSystem.sendSms(user, ticketSystem.getTicketNumber());
        }
    }
}
