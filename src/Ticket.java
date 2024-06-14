import java.time.Instant;
import java.util.Objects;

public class Ticket {
    String ticketID;
    String concertHall;
    int eventCode;
    long ticketTime;
    boolean isPromo;
    char stadiumSector;
    double backpackWeight;

    //full ticket constructor
    public Ticket(String ticketID, String concertHall, int eventCode, long ticketTime, boolean isPromo,
                  char stadiumSector, double backpackWeight) {
        this.ticketID = ticketID;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.backpackWeight = backpackWeight;
        this.ticketTime = ticketTime;

    }

    //limited ticket constructor
    public Ticket(String concertHall, int eventCode, long ticketTime) {
        this.ticketID = "0000"; // Default value
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.ticketTime = ticketTime;
        this.isPromo = false; // Default value
        this.stadiumSector = 'A'; // Default value
        this.backpackWeight = 0.0; // Default value
    }

    //empty ticket constructor
    public Ticket() {
        this.ticketID = "0000"; // Default value
        this.concertHall = "N/A"; // Default value
        this.eventCode = 0; // Default value
        this.ticketTime = 0L; // Default value
        this.isPromo = false; // Default value
        this.stadiumSector = 'A'; // Default value
        this.backpackWeight = 0.0; // Default value
    }

    public String toString() {
        String readablePromo = isPromo ? "Promo" : "Not Promo";
        Instant readableTime = Instant.ofEpochSecond(ticketTime);
        return "Ticket " +
                "ID: " + ticketID +
                ", Concert hall: " + concertHall +
                ", Event code: " + eventCode +
                ", Time: " + readableTime +
                ", Promo: " + readablePromo +
                ", Stadium sector: " + stadiumSector +
                ", Backpack weight: " + backpackWeight + " kg";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Ticket))
            return false;
        if (obj == this)
            return true;
        return Objects.equals(this.ticketID, ((Ticket) obj).ticketID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, concertHall, eventCode, ticketTime, isPromo, stadiumSector, backpackWeight);
    }

    public void changeTimeAndSector(long ticketTime, char stadiumSector) {
        this.ticketTime = ticketTime;
        this.stadiumSector = stadiumSector;
        System.out.println("Time and stadium sector of this ticket has been altered");
    }

    public void share(Shareable shareable) {
        shareable.share();
    }
}
