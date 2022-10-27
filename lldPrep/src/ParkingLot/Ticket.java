package ParkingLot;

public class Ticket {
    String parkingId;
    int floorNo;
    int slotNo;

    public Ticket(String parkingId, int floorNo, int slotNo) {
        this.parkingId = parkingId;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
    }

    public String getTicketId() {
        StringBuilder ticketBuilder = new StringBuilder();
        ticketBuilder.append(this.parkingId)
                .append("_")
                .append(this.floorNo)
                .append("_")
                .append(this.slotNo);
        return ticketBuilder.toString();
    }
}
