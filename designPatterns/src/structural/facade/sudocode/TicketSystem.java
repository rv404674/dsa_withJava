package structural.facade.sudocode;

public class TicketSystem {
    String ticketNumber;

    public boolean validateAvailabilty(String movie){
        return true;
    }

    public void createTicket(int number, User user, String movieName){
        this.ticketNumber = number + user.getName() + movieName;
        System.out.println("Ticket created" + this.ticketNumber);
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }
}
