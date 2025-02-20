package CallTaxiBookingSystem;

public class Booking
{
    private final int bookingId;
    private final int customerId;
    private final int pickUpTime;
    private final int dropTime;
    private final double amount;
    private final char from;
    private final char to;

    public Booking(int bookingId, int customerId, int pickUpTime, int dropTime, double amount, char from, char to)
    {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickUpTime = pickUpTime;
        this.dropTime = dropTime;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public int getPickUpTime()
    {
        return pickUpTime;
    }

    public int getDropTime()
    {
        return dropTime;
    }

    public double getAmount()
    {
        return amount;
    }

    public char getFrom()
    {
        return from;
    }

    public char getTo()
    {
        return to;
    }
}
