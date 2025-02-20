package CallTaxiBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Taxi
{
    private final int id;
    private char currentLocation = 'A';
    private double totalEarning = 0.0;
    private final List<Booking> bookingHistory = new ArrayList<>();

    private static final int BASE_FARE = 100;
    private static final int DISTANCE_RATE = 10;
    private static final int MIN_DISTANCE_FARE = 5;
    private static final int DISTANCE_UNIT = 15;

    public Taxi(int id)
    {
        this.id = id;
    }

    public boolean isAvailable(int requestTime)
    {
        if (bookingHistory.isEmpty()) return true;
        Booking lastBooking = bookingHistory.get(bookingHistory.size() - 1);
        return lastBooking.getDropTime() <= requestTime;
    }

    public double calculateFare(char from, char to)
    {
        int distance = Math.abs(from - to) * DISTANCE_UNIT;
        return BASE_FARE + Math.max(0, (distance - MIN_DISTANCE_FARE) * DISTANCE_RATE);
    }

    public void addBooking(Booking booking)
    {
        bookingHistory.add(booking);
        totalEarning += booking.getAmount();
        currentLocation = booking.getTo();
    }

    public int getId()
    {
        return id;
    }

    public char getCurrentLocation()
    {
        return currentLocation;
    }

    public double getTotalEarning()
    {
        return totalEarning;
    }

    public List<Booking> getBookingHistory()
    {
        return bookingHistory;
    }

    public int getNextBookingId()
    {
        return bookingHistory.size() + 1;
    }

    @Override
    public String toString()
    {
        return "Taxi-" + id + " | Current Location: " + currentLocation + " | Total Earnings: Rs." + totalEarning;
    }
}
