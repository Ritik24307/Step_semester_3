class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("Invalid seat count");
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}

public class CineScreenBooking {
    public static void main(String[] args) {

        CineScreen c = new CineScreen(2);

        c.bookSeat();
        c.bookSeat();
        c.bookSeat();

        System.out.println("Available seats: " + c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();

        System.out.println("Available seats: " + c.getSeatsAvailable());

        try {
            CineScreen invalid = new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Construction rejected");
        }
    }
}